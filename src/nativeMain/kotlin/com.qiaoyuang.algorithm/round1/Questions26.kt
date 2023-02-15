package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.BinaryTreeNode

fun test26() {
    val (head0, head1) = testCase1()
    printlnResult(head0, head1)
    val (head2, head3) = testCase2()
    printlnResult(head2, head3)
    val (head4, head5) = testCase3()
    printlnResult(head4, head5)
    val (head6, head7) = testCase4()
    printlnResult(head6, head7)
    val (head8, head9) = testCase5()
    printlnResult(head8, head9)
    printlnResult(head0, head0)
}

/**
 * Questions26: Judged a binary tree whether is other binary tree's subtree
 */
private infix fun <T> BinaryTreeNode<T>.judgeSubtree(root: BinaryTreeNode<T>): Boolean =
    judge(root, root)

private fun <T> BinaryTreeNode<T>.judge(subRoot: BinaryTreeNode<T>, currentSubNode: BinaryTreeNode<T>): Boolean =
    (value == currentSubNode.value && currentSubNode.left?.let { left?.judge(subRoot, it) == true } != false && currentSubNode.right?.let { right?.judge(subRoot, it) == true } != false)
            || left?.judge(subRoot, subRoot) == true
            || right?.judge(subRoot, subRoot) == true
private fun <T> printlnResult(head: BinaryTreeNode<T>, subHead: BinaryTreeNode<T>) =
    println("Whether the tree: ${subHead.preOrderList()} is subtree of the tree: ${head.preOrderList()}: ${head judgeSubtree subHead}")

private fun testCase1(): Pair<BinaryTreeNode<Int>, BinaryTreeNode<Int>> {
    val node0 = BinaryTreeNode(8, right = BinaryTreeNode(7))
    val node1 = BinaryTreeNode(8, BinaryTreeNode(9))
    val node4 = BinaryTreeNode(2, BinaryTreeNode(4), BinaryTreeNode(7))
    node0.left = node1
    node1.right = node4

    val node7 = BinaryTreeNode(8, BinaryTreeNode(9), BinaryTreeNode(2))
    return node0 to node7
}

private fun testCase2(): Pair<BinaryTreeNode<Int>, BinaryTreeNode<Int>> {
    val node0 = BinaryTreeNode(8, right = BinaryTreeNode(7))
    val node1 = BinaryTreeNode(8, BinaryTreeNode(9, BinaryTreeNode(3), BinaryTreeNode(7)))
    val node4 = BinaryTreeNode(2, BinaryTreeNode(4), BinaryTreeNode(7))
    node0.left = node1
    node1.right = node4

    val node7 = BinaryTreeNode(8, BinaryTreeNode(9), BinaryTreeNode(2))
    return node0 to node7
}

private fun testCase3(): Pair<BinaryTreeNode<Int>, BinaryTreeNode<Int>> {
    val node0 = BinaryTreeNode(8, right = BinaryTreeNode(7))
    val node1 = BinaryTreeNode(8, BinaryTreeNode(9, BinaryTreeNode(3), BinaryTreeNode(7)))
    val node4 = BinaryTreeNode(2, BinaryTreeNode(4), BinaryTreeNode(7))
    node0.left = node1
    node1.right = node4

    val node7 = BinaryTreeNode(8, BinaryTreeNode(9), BinaryTreeNode(2, BinaryTreeNode(5)))
    return node0 to node7
}

private fun testCase4(): Pair<BinaryTreeNode<Int>, BinaryTreeNode<Int>> =
    BinaryTreeNode(9) to BinaryTreeNode(9)

private fun testCase5(): Pair<BinaryTreeNode<Int>, BinaryTreeNode<Int>> {
    val node0 = BinaryTreeNode(8, right = BinaryTreeNode(7))
    val node1 = BinaryTreeNode(8, BinaryTreeNode(9))
    val node4 = BinaryTreeNode(2, BinaryTreeNode(4), BinaryTreeNode(7))
    node0.left = node1
    node1.right = node4

    val node7 = BinaryTreeNode(2)
    return node0 to node7
}