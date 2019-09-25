package com.qiaoyuang.algorithm

/**
 * 机器人在一个矩阵中运动，当机器人当某一个格子的横纵坐标各位的值相加
 * 小于等于k时机器人可以进入该格子,求问机器人可以进入多少个格子
 */

fun main() {
	println(movingCount(5, 10, 10))
	println(movingCount(15, 20, 20))
	println(movingCount(10, 1, 100))
	println(movingCount(10, 1, 10))
	println(movingCount(15, 100, 1))
	println(movingCount(15, 10, 1))
	println(movingCount(12, 1, 1))
}

fun movingCount(k: Int, row: Int, col: Int): Int {
	require(k >= 0 && row >= 0 && col >= 0) { "输入的数据必须全部大于0" }
    var count = 0
	val booleanMatrix = Array<BooleanArray>(row) {
		BooleanArray(col) { true }
	}
	
	fun check(x: Int, y: Int): Boolean {
		var number = 0
		var indexX = x
		var indexY = y
		while (indexX != 0) {
			number += indexX % 10
			indexX /= 10
		}
		while (indexY != 0) {
			number += indexY % 10
			indexY /= 10
		}
		return number <= k
	}
	
	fun find(x: Int, y: Int) {
		if (!booleanMatrix[x][y])
			return
		if (check(x, y)) {
			booleanMatrix[x][y] = false
			count++
			if (x < row - 1) {
			    find(x+1, y)
		    }
			if (x > 0) {
			    find(x-1, y)
		    }
			if (y < col - 1) {
				find(x, y+1)
		    }
		    if (y > 0) {
			    find(x, y-1)
		    }
		} else {
			booleanMatrix[x][y] = false
		}
	}
	
	find(0, 0)
	return count
}