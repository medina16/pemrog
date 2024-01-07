import java.util.TreeMap;

public class TreeNode {
    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<>();

        // Insert nodes
        tree.put(50, "Node 50");
        tree.put(30, "Node 30");
        tree.put(20, "Node 20");
        tree.put(40, "Node 40");
        tree.put(70, "Node 70");
        tree.put(60, "Node 60");
        tree.put(80, "Node 80");

        // Print key-value pairs with an inorder traversal
        for (Integer key : tree.keySet()) {
            System.out.println(key + ": " + tree.get(key));
        }
    }
}
