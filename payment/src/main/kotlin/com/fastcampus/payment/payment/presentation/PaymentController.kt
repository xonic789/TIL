package com.fastcampus.payment.payment.presentation

import com.fastcampus.payment.payment.application.PaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController(
    private val paymentService: PaymentService,
) {

    @PostMapping
    fun payment(
        @RequestBody request: PaymentRequest
    ): ResponseEntity<PaymentResponse> {
        return ResponseEntity.ok(paymentService.payment(request))
    }
}
