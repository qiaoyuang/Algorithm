package offer

import java.io.File
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.security.MessageDigest

/*
 * 正则表达式匹配
 * 这题以后写，现在用来做测试
 */
fun main(args: Array<String>) {
	val resource = "/Users/qiaoyuang/Downloads/第三方库/gui-config.json"
	val file = File(resource)
	val bufferedReader = BufferedReader(FileReader(file))
	var line = bufferedReader.readLine()
	while (line != null) {
		println("MD5:${md5Hash(line)}")
		println("SHA_256:${sha256Hash(line)}")
		println("SHA_512:${sha512Hash(line)}")
		println()
		line = bufferedReader.readLine()
	}
}

fun sha256Hash(str: String): String = getHashAlgorithm(SHA_256, str)

fun sha512Hash(str: String): String = getHashAlgorithm(SHA_512, str)

fun md5Hash(str: String): String = getHashAlgorithm(MD5, str)

private fun getHashAlgorithm(key: String, str: String): String {
    val mDigest = MessageDigest.getInstance(key)
    mDigest.update(str.toByteArray())
    return bytesToHexString(mDigest.digest())
}

private fun bytesToHexString(bytes: ByteArray): String {
    val sb = StringBuilder()
    for (b in bytes) {
        val hex = Integer.toHexString(0xFF and b.toInt())
        if (hex.length == 1) {
            sb.append('0')
        }
        sb.append(hex)
    }
    return sb.toString()
}

const val MD5 = "MD5"
const val SHA_256 = "SHA-256"
const val SHA_512 = "SHA-512"