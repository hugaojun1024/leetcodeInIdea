package com.algorithm.javaCollection;

import java.util.List;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-08-09-[下午 9:27]-周五
 */
public class BinaryTreeTraversal {

    // 前序遍历（根 -> 左 -> 右）
    public void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }

    // 中序遍历（左 -> 根 -> 右）
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // 后序遍历（左 -> 右 -> 根）
    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }
}
