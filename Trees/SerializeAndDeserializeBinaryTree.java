package Trees;

import java.util.*;

//problem , given a binary tree so that we have serialize and deserialize.
//serialize mean , convert the tree into unique string that can again reconstruct the same tree

//i am using level order traversal 
//when null visits , i place N while serializing 
// and while deserializing , i use N to skip the node and rebuild tree sequentially in order.

//most of logic is same as Level Order Building tree and traversing , but here we must use StringBuilder 
// and string arrays... to serialize and deserialize

public class SerializeAndDeserializeBinaryTree{
    public static void main(String args[]){
        Integer [] arr = {1,2,3,null,null,4,5};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);

        String ans = serialize(root);
        System.out.println("serialized string is : " + ans);

        TreeNode rootD = deserialize(ans);
        System.out.print("deserialized tree is : ");
        TreeNode.printLevelOrder(rootD);
    }
    public static String serialize(TreeNode root){
        if(root == null){
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();

            if(current == null){
                sb.append("N,");
                continue;
            }

            sb.append(current.val).append(",");

            q.offer(current.left);
            q.offer(current.right);
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static TreeNode deserialize(String s){

        if (s == null || s.isEmpty()) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();

        String [] str = s.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        q.offer(root);

        int i = 1;
        while(!q.isEmpty() && i < str.length){
            TreeNode current = q.poll();

            if(!str[i].equals("N")){
                current.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(current.left);
            }
            i++;

            if(!str[i].equals("N")){ 
                current.right = new TreeNode(Integer.parseInt(str[i]));
                q.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
