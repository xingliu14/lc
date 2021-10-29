// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Tree的题往递归想准没错，还是需要注意String的比较需要用.equals()，设置分隔符的时候不要选一些奇怪的，可能会和负号或者regex的符号冲突。

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }
    
    private String rSerialize(TreeNode node, String str) {
        if(node == null) {
            str += "null,";
        } else {
            str += node.val + ",";
            str = rSerialize(node.left, str);
            str = rSerialize(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<> (Arrays.asList(nodes));
        return rDeserialize(list);
    }
    
    private TreeNode rDeserialize(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        
        int currNum = Integer.valueOf(list.get(0));
        TreeNode currNode = new TreeNode(currNum);
        list.remove(0);
        currNode.left = rDeserialize(list);
        currNode.right = rDeserialize(list);
        return currNode;
    }
}