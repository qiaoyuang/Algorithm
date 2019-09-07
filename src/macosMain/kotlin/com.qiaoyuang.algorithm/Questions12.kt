package com.qiaoyuang.algorithm

/**
 * 一个含有多个字符的矩阵中是否含有某一个字符串的路径
 */

fun main() {
	val matrix = arrayOf(charArrayOf('a', 'b', 't', 'g'),
			charArrayOf('c', 'f', 'c', 's'),
			charArrayOf('j', 'd', 'e', 'h'))
	println(hasPath(matrix, "bfce"))
	println(hasPath(matrix, "abfb"))
	println(hasPath(matrix, "abfcj"))
}

fun hasPath(matrix: Array<CharArray>, str: String): Boolean {
	if (str.isBlank()) {
		return true
	}
	
	val rowX = matrix.size
	val rowY = matrix[0].size
	val booleanMatrix = Array<BooleanArray>(rowX) {
		BooleanArray(rowY) { true }
	}
	
	var index = 0
	val c = str.get(index)
	
	fun find(x: Int, y: Int): Boolean {
		if (!booleanMatrix[x][y]) {
			return false
		}
		if (matrix[x][y] == str.get(index)) {
			booleanMatrix[x][y] = false
			index++
			if (index == str.length) {
				return true
			}
			if (x > 0) {
			    if (find(x - 1, y)) {
					return true
				}
		    }
		    if (x < rowX - 1) {
			    if (find(x + 1, y)) {
					return true
				}
		    }
		    if (y > 0) {
			    if (find(x, y - 1)) {
					return true
				}
		    }
		    if (y < rowY - 1) {
				if (find(x, y + 1)) {
					return true
				}
		    }
			index--
			return false
		} else {
			return false
		}
	}
	
	for (i in 0 until rowX) {
		for (j in 0 until rowY) {
			if (matrix[i][j] == c) {
				if (find(i, j)) {
					return true
				}
				index = 0
			}
		}
	}
	return false
}