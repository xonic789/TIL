package com.fastcampus.payment.merchant.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository<Merchant, String>
