package com.fastcampus.payment.paymentrequest.application.exception

import com.fastcampus.payment.exception.EntityNotFoundException

class PaymentRequestApplicationException {

    companion object {
        private const val PREFIX: String = "PAR"
    }

    class NotFoundException : EntityNotFoundException("${PREFIX}00001", "결제 정보를 찾을 수 없습니다.")
}
