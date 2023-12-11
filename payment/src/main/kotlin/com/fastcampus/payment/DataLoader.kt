package com.fastcampus.payment

import com.fastcampus.payment.infra.UUIDGenerator
import com.fastcampus.payment.merchant.domain.Merchant
import com.fastcampus.payment.merchant.domain.MerchantRepository
import com.fastcampus.payment.user.domain.User
import com.fastcampus.payment.user.domain.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
    private val userRepository: UserRepository,
    private val uuidGenerator: UUIDGenerator,
    private val merchantRepository: MerchantRepository,
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        val user = User.create(
            id = "11ee982bf1f254c091f76b4ba6b082a2",
            name = "홍길동",
            userBalanceId = uuidGenerator.generate(),
        )
        user.chargeBalance(10000)
        userRepository.saveAll(
            listOf(
                user
            )
        )
        merchantRepository.saveAll(
            listOf(
                Merchant.create(
                    id = "11ee982bb369b970aa864daaa5a26fcc",
                    name = "가맹점1",
                )
            )
        )
    }
}
