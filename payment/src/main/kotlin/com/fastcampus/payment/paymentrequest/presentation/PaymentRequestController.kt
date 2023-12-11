package com.fastcampus.payment.paymentrequest.presentation

import com.fastcampus.payment.paymentrequest.application.PaymentRequestService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payment-requests")
class PaymentRequestController(
    private val paymentRequestService: PaymentRequestService,
) {

    @PostMapping
    fun createPaymentRequest(
        @RequestBody request: PaymentRequestRequest
    ): ResponseEntity<PaymentRequestResponse> {
        return ResponseEntity.ok(paymentRequestService.createPaymentRequest(request))
    }

    @GetMapping("/{id}")
    fun getPaymentRequest(
        @PathVariable("id") id: String
    ): ResponseEntity<PaymentRequestResponse> {
        return ResponseEntity.ok(paymentRequestService.getPaymentRequest(id))
    }
}
