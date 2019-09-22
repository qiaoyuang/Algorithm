package com.qiaoyuang.algorithm

import kotlin.native.ref.WeakReference

/**
 * 实现单例模式
 */

fun test2() {
    println(Instance1.InstanceHolder.instance)
    println(Instance2.instance)
}

/**
 * 静态内部类
 */
class Instance1 private constructor() {

    class InstanceHolder {
        companion object {
            val instance = Instance1()
        }
    }

    override fun toString(): String = "我是单例1"
}

/**
 * 弱引用防止内存泄漏
 */
class Instance2 private constructor() {

    companion object {
        private var mRef = WeakReference(Instance2())
        val instance: Instance2
            get() {
                var instance = mRef.get()
                return if (instance != null) instance else {
                    instance = Instance2()
                    mRef = WeakReference(instance)
                    instance
                }
            }
    }

    override fun toString(): String = "我是单例2"
}

/**
 * 其它实现单例模式的方法
 * 1.懒汉与饿汉：太简单，这里就不写了
 * 2.Object 关键字：Kotlin 中最推荐使用 Object 关键字来实现单例，可以应对绝大多数情况
 * 3.枚举：也较为简单，这里也不写了
 * 4.双重校验锁：Kotlin/Native 中不存在线程的概念，而且也不一定会有指令重排序，所以双重校验锁在 Kotlin/Native 中没有意义
 * 5
 */