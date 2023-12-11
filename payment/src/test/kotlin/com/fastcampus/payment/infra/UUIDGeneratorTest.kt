package com.fastcampus.payment.infra

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class UUIDGeneratorTest {

    @Test
    fun `UUIDGenerator가 UUID를 생성한다`() {
        val uuidGenerator = UUIDGenerator()
        val uuid = uuidGenerator.generate()
        assertNotNull(uuid)
    }
}
