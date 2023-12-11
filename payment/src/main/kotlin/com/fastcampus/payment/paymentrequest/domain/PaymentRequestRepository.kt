package com.fastcampus.payment.paymentrequest.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRequestRepository : JpaRepository<PaymentRequest, String> {

}
