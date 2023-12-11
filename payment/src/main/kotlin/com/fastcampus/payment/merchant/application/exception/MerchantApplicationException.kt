package com.fastcampus.payment.merchant.application.exception

import com.fastcampus.payment.exception.EntityNotFoundException

class MerchantApplicationException {

    companion object {
        private const val PREFIX: String = "MCH"
    }

    class NotFoundException : EntityNotFoundException("${PREFIX}00001", "가맹점 정보를 찾을 수 없습니다.")
}


