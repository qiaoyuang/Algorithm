package com.qiaoyuang.algorithm.round1

fun test50() {
    printlnResult1("abaccdeff")
    printlnResult2("We are students.", "aeiou")
    printlnResult3("google")
    printlnResult4("silent", "listen")
    getFirstCharacterAppearOnce(sequence {
        "google".forEach {
            yield(it)
        }
    })
}

/**
 * Questions 50-1: Find a character in a string that just appear once
 */
private fun String.findCharacterWithOnce(): Char? { // The string could contain any character
    require(isNotEmpty()) { "The string must be not empty" }
    val map = HashMap<Char, Int>()
    forEach { c ->
        map[c] = 1 + (map[c] ?: 0)
    }
    return map.entries.find { it.value == 1 }?.key
}

private fun printlnResult1(str: String) = println("The character: '${str.findCharacterWithOnce()}' just appear once in \"$str\"")

/**
 * Questions 50-2: Define a function that receives two string parameters a and b, delete all characters appear in b from a
 */
private fun deleteCharacters(a: String, b: String): String {
    val set = buildSet {
        b.forEach {
            if (!contains(it))
                add(it)
        }
    }
    val builder = StringBuilder(a)
    var index = 0
    while (index < builder.length) {
        if (set.contains(builder[index]))
            builder.deleteAt(index)
        else
            index++
    }
    return builder.toString()
}

private fun printlnResult2(a: String, b: String) = println("Delete all characters in \"$b\" from \"$a\", we can get: \"${deleteCharacters(a, b)}\"")

/**
 * Questions 50-3: Delete the repeated characters in a string
 */
private fun deleteRepeatCharacters(str: String): String {
    val builder = StringBuilder(str)
    val set = HashSet<Char>()
    var index = 0
    while (index < builder.length) {
        if (set.contains(builder[index]))
            builder.deleteAt(index)
        else
            set.add(builder[index++])
    }
    return builder.toString()
}

private fun printlnResult3(str: String) = println("Delete the repeated characters in \"$str\", we can get: \"${deleteRepeatCharacters(str)}\"")

/**
 * Questions 50-4: Judge if the two words are anagrams for each other
 */
private infix fun String.isAnagram(str: String): Boolean {
    if (length != str.length)
        return false
    val map = HashMap<Char, Int>(length)
    forEach {
        map[it] = 1 + (map[it] ?: 0)
    }
    str.forEach {
        if (!map.containsKey(it))
            return false
        if (map[it] == 1)
            map.remove(it)
        else
            map[it] = map[it]!! - 1
    }
    return map.isEmpty()
}

private fun printlnResult4(a: String, b: String) = println("If \"$a\" and \"$b\" are anagrams for each other: \"${a isAnagram b}\"")

/**
 * Questions 50-5: Find the first character that appear once in a characters sequence
 */
private fun getFirstCharacterAppearOnce(sequence: Sequence<Char>) {
    val map = HashMap<Char, Int>()
    sequence.forEachIndexed { index, c ->
        if (map.containsKey(c))
            map[c] = Int.MAX_VALUE
        else
            map[c] = index
        println("Current the first character that appear once is: ${map.minBy { it.value }.takeIf { it.value != Int.MAX_VALUE }?.key}")
    }
}