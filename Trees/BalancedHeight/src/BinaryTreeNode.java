import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeNode {
  public int value;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int value) {
    this.value = value;
  }

  public int height() {
    int height = 1;
    if (this.left != null) {
      height = 1 + this.left.height();
    }
    if (this.right != null) {
      height = Math.max(height, 1 + this.right.height());
    }
    return height;
  }

  public boolean isBalanced() {
    if (this.left == null && this.right == null) {
      return true;
    }
    if (this.left == null || this.right == null) {
      return false;
    }
    return Math.abs(this.left.height() - this.right.height()) <= 1 &&
        this.left.isBalanced() && this.right.isBalanced();
  }

  public String encode() {
    LinkedList<String> buffer = new LinkedList<>();
    encode(buffer);
    return String.join(",", buffer);
  }


  private void encode(LinkedList<String> buffer) {
    buffer.add(Integer.toString(this.value));

    // Encodes the left branch of the tree.
    if (this.left != null) {
      this.left.encode(buffer);
    } else {
      buffer.add("#");
    }

    // Encodes the right branch of the tree.
    if (this.right != null) {
      this.right.encode(buffer);
    } else {
      buffer.add("#");
    }
  }

  public static BinaryTreeNode decode(String buffer) {
    LinkedList<String> queue = new LinkedList<>();
    Arrays.stream(buffer.split(",")).forEach(s -> queue.add(s));
    return decode(queue);
  }

  private static BinaryTreeNode decode(LinkedList<String> bufferItems) {
    if (bufferItems.size() == 0) {
      return null;
    }
    String str = bufferItems.remove().trim();
    if (str.equals("#")) {
      return null;
    }
    BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(str));
    root.left = decode(bufferItems);
    root.right = decode(bufferItems);
    return root;
  }
}