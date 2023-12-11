package com.fastcampus.payment.payment.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, String>


