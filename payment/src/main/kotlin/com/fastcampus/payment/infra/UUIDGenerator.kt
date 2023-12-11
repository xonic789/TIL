package com.fastcampus.payment.infra

import com.fastcampus.payment.interfaces.UUIDGenerator
import com.fasterxml.uuid.Generators
import org.springframework.stereotype.Component
import java.lang.Long.parseUnsignedLong
import java.nio.ByteBuffer
import java.util.*


@Component
class UUIDGenerator() : UUIDGenerator {

    companion object {
        private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()
    }

    override fun generate(): String {
        val bytes = createUUID()
        return bytesToHex(bytes)
    }

    private fun bytesToHex(bytes: ByteArray): String {
        val hexChars = CharArray(bytes.size * 2)
        for (i in bytes.indices) {
            val v = bytes[i].toInt() and 0xFF
            hexChars[i * 2] = HEX_ARRAY[v ushr 4]
            hexChars[i * 2 + 1] = HEX_ARRAY[v and 0x0F]
        }
        return String(hexChars).lowercase(Locale.getDefault())
    }

    private fun createUUID(): ByteArray {
        val uuidV1 = Generators.timeBasedGenerator().generate()
        val uuidV1Parts = uuidV1.toString().split("-".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val sequentialUUID =
            uuidV1Parts[2] + uuidV1Parts[1] + uuidV1Parts[0] + uuidV1Parts[3] + uuidV1Parts[4]
        val sequentialUuidV1 = java.lang.String.join("", sequentialUUID)
        val bb: ByteBuffer = ByteBuffer.wrap(ByteArray(16))

        bb.putLong(parseUnsignedLong(sequentialUuidV1.substring(0, 16), 16))
        bb.putLong(parseUnsignedLong(sequentialUuidV1.substring(16), 16))
        return bb.array()
    }
}
