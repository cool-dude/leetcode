package cracking_coding_int.chaper_four;
import data_structure.trees.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
class Sln {
    List<List<TreeNode>> helper(TreeNode root, List<List<TreeNode>> linkedLists, int level) {
        if (root==null) return null;
        LinkedList list=null;
        if(level==linkedLists.size()){
            list=new LinkedList<TreeNode>();
            linkedLists.add(list);
            list.add(root);
        }
        else{
            list=linkedLists.get(level);
        }
        list.add(root);
        helper(root.left,linkedLists,level+1);
        helper(root.right,linkedLists,level+1);
        return linkedLists;
    }
    List<List<TreeNode>> createLevelLinkedlist(TreeNode root) {
        return helper(root, new ArrayList<LinkedList<TreeNode>>(), 0);
    }
}