package com.qiaoyuang.algorithm.special

fun test73() {
    println("At least eat ${eatBananas(intArrayOf(3, 6, 7, 11), 8)} bananas per hour")
}

/**
 * Questions 73
 */
private fun eatBananas(piles: IntArray, h: Int): Int {
    var start = 1
    var end = piles.max()
    while (start < end) {
        val mid = (start + end) / 2
        val time = piles.fold(0) { acc, i ->
            acc + if (i % mid == 0) i / mid else i / mid + 1
        }
        if (time <= h) {
            val midSub1 = mid - 1
            if (piles.fold(0) { acc, i -> acc + if (i % midSub1 == 0) i / midSub1 else i / midSub1 + 1 } > h)
                return mid
            end = mid
        } else
            start = mid + 1
    }
    return -1
}