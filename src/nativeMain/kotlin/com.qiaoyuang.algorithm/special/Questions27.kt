package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round1.SingleDirectionNode
import com.qiaoyuang.algorithm.round1.printlnLinkedList

fun test27() {
    printlnResult(SingleDirectionNode(element = 8, next = SingleDirectionNode(element = 8)))
    printlnResult(SingleDirectionNode(element = 8, next = SingleDirectionNode(element = 9, next = SingleDirectionNode(element = 8))))
    printlnResult(SingleDirectionNode(element = 8, next = SingleDirectionNode(element = 8, next = SingleDirectionNode(element = 8))))
    printlnResult(complicatedPalindromeLinkedList())
    printlnResult(SingleDirectionNode(element = 0, next = complicatedPalindromeLinkedList()))
}

/**
 * Questions 27: Palindrome linked list. Time complexity O(n), space complexity O(1).
 */
private fun <T> SingleDirectionNode<T>.isPalindrome(): Boolean {
    if (next == null)
        return true
    var pointer1: SingleDirectionNode<T>? = this
    var pointer2: SingleDirectionNode<T>? = next
    pointer1?.next = null
    while (pointer2 != null) {
        when (pointer1?.element) {
            pointer2.element -> {
                pointer1 = pointer1?.next
                pointer2 = pointer2.next
                var result = true
                while (pointer1 != null || pointer2 != null) {
                    if (pointer1?.element != pointer2?.element) {
                        result = false
                        break
                    }
                    pointer1 = pointer1?.next
                    pointer2 = pointer2?.next
                }
                if (result)
                    return true
            }
            pointer2.next?.element -> {
                pointer1 = pointer1?.next
                pointer2 = pointer2.next?.next
                var result = true
                while (pointer1 != null || pointer2 != null) {
                    if (pointer1?.element != pointer2?.element) {
                        result = false
                        break
                    }
                    pointer1 = pointer1?.next
                    pointer2 = pointer2?.next
                }
                if (result)
                    return true
            }
            else -> {
                val temp = pointer2.next
                pointer2.next = pointer1
                pointer1 = pointer2
                pointer2 = temp
            }
        }
    }
    return false
}

private fun printlnResult(head: SingleDirectionNode<Int>) {
    print("The linked list: ")
    printlnLinkedList(head)
    println("Is it palindrome linked list? ${head.isPalindrome()}")
}

private fun complicatedPalindromeLinkedList(): SingleDirectionNode<Int> =
    SingleDirectionNode(element = 1, next =
    SingleDirectionNode(element = 2, next =
    SingleDirectionNode(element = 1, next =
    SingleDirectionNode(element = 3, next =
    SingleDirectionNode(element = 4, next =
    SingleDirectionNode(element = 5, next =
    SingleDirectionNode(element = 4, next =
    SingleDirectionNode(element = 3, next =
    SingleDirectionNode(element = 1, next =
    SingleDirectionNode(element = 2, next =
    SingleDirectionNode(element = 1, )))))))))))
