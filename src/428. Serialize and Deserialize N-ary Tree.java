// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
// 这道题太鸡巴蠢了，我灵光一现，在每一个node最后加一个null，这样指示了他children的结尾。编译器坑得我好惨

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        return recursion_serialize(root, "");
    }
    
    private String recursion_serialize(Node root, String str) {
        if(root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            if(root.children != null) {
                for(Node child : root.children) {
                    str = recursion_serialize(child, str);
                }
            }
        }
        return str + "null,";
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<> (Arrays.asList(nodes));
        return recursion_deserialize(list);
    }
    
    private Node recursion_deserialize(List<String> list) {
        if(list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        int currNum = Integer.valueOf(list.get(0));
        Node node = new Node(currNum, new LinkedList<> ());
        list.remove(0);
        while(true) {
            Node nextNode = recursion_deserialize(list);
            if(nextNode != null) {
                node.children.add(nextNode);
            } else {
                break;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));