package treeGraphs.Q103_binaryTreeZigzagLevelOrderTraversal;

import treeGraphs.util.TreeNode;

import java.util.*;

/*
    LinkedList addLast and addFirst are both O(1) because Java's LinkedList documentation says that:
    "All the operations perform as could be expected for a doubly-linked list"
    More specifically in linkLast() method, we can see that LinkedList holds a pointer to last element: "last=newNode"
*/
public class Q103_binaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lvl = -1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            lvl++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cNode = queue.remove();
                if (lvl % 2 == 0) {
                    level.addLast(cNode.val);
                } else {
                    level.addFirst(cNode.val);
                }
                if (cNode.left != null) {
                    queue.add(cNode.left);
                }
                if (cNode.right != null) {
                    queue.add(cNode.right);
                }
            }
            answer.add(level);
        }
        return answer;
    }


//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> listList = new ArrayList<>();
//        if (root == null) return listList;
//
//        boolean ltr = false;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            LinkedList<Integer> level = new LinkedList<>();
//            ltr = !ltr;
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = q.poll();
//                if (ltr) {
//                    level.addLast(cur.val);
//                } else {
//                    level.addFirst(cur.val);
//                }
//                if (cur.left != null) {
//                    q.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    q.offer(cur.right);
//                }
//            }
//            listList.add(level);
//        }
//        return listList;
//    }
}
