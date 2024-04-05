package com.qiaoyuang.algorithm.special

fun test73() {
    println("At least eat ${eatBananas(intArrayOf(3, 6, 7, 11), 8)} bananas per hour")
}

/**
 * Questions 73: Koko eaten bananas
 */
private fun eatBananas(piles: IntArray, h: Int): Int {
    var start = 1
    var end = piles.max()
    while (start <= end) {
        val mid = (start + end) / 2
        val time = getHours(piles, mid)
        if (time <= h) {
            val midMin1 = mid - 1
            if (mid == 1 || getHours(piles, midMin1) > h)
                return mid
            end = midMin1
        } else
            start = mid + 1
    }
    return -1
}

private fun getHours(piles: IntArray, k: Int): Int =
    piles.fold(0) { acc, i -> acc + if (i % k == 0) i / k else i / k + 1 }