package treeGraphs.general_binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import treeGraphs.util.TreeNode;

public class PostOrderTraversal_DFS {

    List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        traversePostOrder(root, answer);
        return answer;
    }

    private void traversePostOrder(TreeNode node, List<Integer> answer) {
        if (node == null) return;
        traversePostOrder(node.left, answer);
        traversePostOrder(node.right, answer);
        answer.add(node.val);
    }
}
