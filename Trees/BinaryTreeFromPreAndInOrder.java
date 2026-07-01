package Trees;

import java.util.HashMap;

//given two integer arrays that represents the traveral order of preorder and inorder
// we have to build binary tree using traversal values of both

//solution is , we can observer that starting value is root in preorder 
// and that root in inorder represents left side is left sub tree and right side right sub tree

//so , by using this logic we can build the tree

//after building the tree , i have used preOrder and inorder travrsal techniques applied on builded tree 
// to cross check the values of array  --> note , this code needs root structure code of TreeNode.java

public class BinaryTreeFromPreAndInOrder{
    private static HashMap<Integer, Integer> inMap = new HashMap<>();
    private static int preIndex = 0;
    public static void main(String args[]){
        int [] preOrder = {3,9,20,15,7};
        int [] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder,inOrder);
        TreeNode.print(root); //preOrder
        System.out.println();
        TreeNode.printInOrder(root);
    }
    private static TreeNode buildTree(int [] preOrder, int[] inOrder){
        for(int i = 0; i < inOrder.length; i++){
            inMap.put(inOrder[i],i);
        }
         
        TreeNode root = build(preOrder, 0 , inOrder.length - 1);
        return root;
    }
    private static TreeNode build(int[] preOrder, int inStart, int inEnd){
        if (inStart > inEnd) {
            return null;
        }

        int rootValue = preOrder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = inMap.get(rootValue);

        root.left = build(preOrder, inStart, inOrderIndex - 1);
        root.right = build(preOrder, inOrderIndex + 1, inEnd);

        return root;
    }
}