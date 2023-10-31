package com.qiaoyuang.algorithm.special

fun test5() {
    printlnResult(arrayOf("abcw", "foo", "bar", "fxyz", "abcdef"))
}

/**
 * Questions 5: We have a String array, find the maximum product
 * of the two strings that don't have any same alphabet, the all
 * stings are composed by lowercase alphabets
 */
private fun Array<String>.findMaxProduct(): Int {
    val alphabets = IntArray(size)
    forEachIndexed { i, str ->
        str.forEach {
            alphabets[i] = 1 shl (it.code - 'a'.code) or alphabets[i]
        }
    }
    var result = 0
    for (i in 0 ..< lastIndex)
        for (j in i + 1..lastIndex)
            if (alphabets[i] and alphabets[j] == 0) {
                val product = this[i].length * this[j].length
                if (product > result)
                    result = product
            }
    return result
}

private fun printlnResult(array: Array<String>) {
    println("The string array is: ${array.toList()}")
    println("The maximum product of two strings that don't have same alphabets is: ${array.findMaxProduct()}")
}
