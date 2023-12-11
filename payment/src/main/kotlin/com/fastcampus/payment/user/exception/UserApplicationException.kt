package com.fastcampus.payment.user.exception

import com.fastcampus.payment.exception.EntityNotFoundException

class UserApplicationException {

    companion object {
        const val PREFIX: String = "USR"
    }

    class NotFoundException : EntityNotFoundException("${PREFIX}00001", "유저 정보를 찾을 수 없습니다.")
}
