package com.qiaoyuang.algorithm.round1

fun test20() {
    printlnResult("+100")
    printlnResult("5e2")
    printlnResult("-123")
    printlnResult("3.1416")
    printlnResult("-1E-16")
    printlnResult("12e")
    printlnResult("1a3.14")
    printlnResult("1.2.3")
    printlnResult("+-5")
    printlnResult("12e+5.4")
}

private fun String.isNumber(): Boolean {
    if (isEmpty())
        return false
    var isHasPoint = false
    var eIndex = -1
    forEachIndexed { index, c ->
        when (c) {
            '+', '-' -> {
                if (index > 0 && this[index - 1] != 'e' && this[index - 1] != 'E')
                    return false
            }
            'e', 'E' -> {
                if (eIndex > 0 || index == 0 || index == lastIndex)
                    return false
                eIndex = index
            }
            '.' -> {
                if (isHasPoint || index == 0 || index == lastIndex || (eIndex in 1 until index))
                    return false
                isHasPoint = true
            }
            else -> {
                if (!c.isDigit())
                    return false
            }
        }
    }
    return true
}

private fun printlnResult(str: String) =
    println("Is $str a Number? Answer: ${str.isNumber()}")