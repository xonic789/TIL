package com.fastcampus.payment.payment.application

import com.fastcampus.payment.infra.UUIDGenerator
import com.fastcampus.payment.payment.domain.PaymentDomainService
import com.fastcampus.payment.payment.domain.PaymentRepository
import com.fastcampus.payment.payment.presentation.PaymentRequest
import com.fastcampus.payment.payment.presentation.PaymentResponse
import com.fastcampus.payment.payment.presentation.toResponse
import com.fastcampus.payment.paymentrequest.application.exception.PaymentRequestApplicationException
import com.fastcampus.payment.paymentrequest.domain.PaymentRequestRepository
import com.fastcampus.payment.user.domain.UserRepository
import com.fastcampus.payment.user.exception.UserApplicationException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val paymentRequestRepository: PaymentRequestRepository,
    private val uuidGenerator: UUIDGenerator,
    private val userRepository: UserRepository,
) {
    @Transactional
    fun payment(request: PaymentRequest): PaymentResponse {
        val paymentRequest = paymentRequestRepository.findByIdOrNull(request.requestId)
            ?: throw PaymentRequestApplicationException.NotFoundException()
        val user = userRepository.findByIdOrNull(request.userId)
            ?: throw UserApplicationException.NotFoundException()
        val service = PaymentDomainService()
        val payment = service.payment(user, paymentRequest, uuidGenerator)
        return payment.toResponse()
    }

}
