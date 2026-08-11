package Trees;
import java.util.ArrayList;
import java.util.List;


public class LeafSimillarTree{
    public static void main(String [] args){
        Integer [] arr1 = {3,5,1,6,2,9,8,null,null,7,4};
        Integer [] arr2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode root1 = TreeNode.buildTreeLevelOrder(arr1);
        TreeNode root2 = TreeNode.buildTreeLevelOrder(arr2);
        boolean ans = leafSimillar(root1, root2);
        System.out.println(ans);
    }
    public static boolean leafSimillar(TreeNode root1, TreeNode root2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        printLeaves(root1, list1);
        printLeaves(root2, list2);

        return list1.equals(list2);
    }
    public static void printLeaves(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        printLeaves(root.left, list);
        printLeaves(root.right, list);
    }
}