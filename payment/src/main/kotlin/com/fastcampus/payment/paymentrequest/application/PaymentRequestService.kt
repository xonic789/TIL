package com.fastcampus.payment.paymentrequest.application

import com.fastcampus.payment.infra.UUIDGenerator
import com.fastcampus.payment.merchant.application.exception.MerchantApplicationException
import com.fastcampus.payment.merchant.domain.MerchantRepository
import com.fastcampus.payment.payment.domain.Payment
import com.fastcampus.payment.payment.domain.PaymentRepository
import com.fastcampus.payment.paymentrequest.application.exception.PaymentRequestApplicationException
import com.fastcampus.payment.paymentrequest.domain.PaymentRequest
import com.fastcampus.payment.paymentrequest.domain.PaymentRequestRepository
import com.fastcampus.payment.paymentrequest.presentation.PaymentRequestRequest
import com.fastcampus.payment.paymentrequest.presentation.PaymentRequestResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentRequestService(
    private val paymentRequestRepository: PaymentRequestRepository,
    private val uuidGenerator: UUIDGenerator,
    private val merchantRepository: MerchantRepository,
    private val paymentRepository: PaymentRepository,
) {

    @Transactional
    fun createPaymentRequest(request: PaymentRequestRequest): PaymentRequestResponse {
        val merchant = merchantRepository.findByIdOrNull(request.merchantId)
            ?: throw MerchantApplicationException.NotFoundException()
        val paymentRequest = PaymentRequest.create(
            id = uuidGenerator.generate(),
            amount = request.amount,
            merchantId = request.merchantId,
        )
        val paymentRequestSaved = paymentRequestRepository.save(paymentRequest)
        val payment = Payment.ready(
            id = uuidGenerator.generate(),
            paymentRequestId = paymentRequestSaved.id,
            amount = paymentRequestSaved.amount,
            merchantId = paymentRequestSaved.merchantId,
        )
        paymentRepository.save(payment)
        return paymentRequestSaved.toResponse(merchant.name)
    }

    @Transactional(readOnly = true)
    fun getPaymentRequest(paymentRequestId: String): PaymentRequestResponse {
        val paymentRequest = paymentRequestRepository.findByIdOrNull(paymentRequestId)
            ?: throw PaymentRequestApplicationException.NotFoundException()
        val merchant = merchantRepository.findByIdOrNull(paymentRequest.merchantId)
            ?: throw MerchantApplicationException.NotFoundException()
        return paymentRequest.toResponse(merchant.name)
    }
}
