 package QuadB_Tech;	

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
public class Tree_Maximum_Depth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
    	Tree_Maximum_Depth tree = new Tree_Maximum_Depth();

        // Creating a sample binary tree
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.right.right = new TreeNode(6);
        int depth = tree.maxDepth(rootNode);
        System.out.println("Maximum depth of the binary tree is: " + depth);
    }
}
