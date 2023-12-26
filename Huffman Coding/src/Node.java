public class Node {
  public byte name;
  public int key;
  public Node left;
  public Node right;

  public Node(byte name, int key) {
    this.name = name;
    this.key = key;
    this.left = null;
    this.right = null;
  }

  public Node(byte name, int key, Node left, Node right) {
    this.name = name;
    this.key = key;
    this.left = left;
    this.right = right;
  }
}
