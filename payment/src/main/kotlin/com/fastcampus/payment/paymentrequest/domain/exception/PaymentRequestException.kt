package com.fastcampus.payment.paymentrequest.domain.exception

import com.fastcampus.payment.exception.DomainException

class PaymentRequestException {

    companion object {
        private const val PREFIX: String = "PARD"
    }

    // 이미 처리된 결제 요청입니다.
    class AlreadyCompletedException :
        DomainException(code = "${PREFIX}00001", messageCode = "이미 처리된 결제 요청입니다.")
}
