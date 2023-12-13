package com.fastcampus.payment.payment.domain.exception

import com.fastcampus.payment.exception.DomainException

class PaymentException {
    companion object {

        private const val PREFIX: String = "PAYD"
    }

    class AlreadyCompletedException :
        DomainException(code = "${PREFIX}00001", messageCode = "이미 결제가 완료되었습니다")

    class ExpiredException :
        DomainException(code = "${PREFIX}00002", messageCode = "결제가 만료되었습니다")

    class InvalidAmountException :
        DomainException(code = "${PREFIX}00003", messageCode = "결제 금액이 일치하지 않습니다")
}
