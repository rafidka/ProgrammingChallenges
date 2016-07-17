import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeNode {
  public int value;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int value) {
    this.value = value;
  }

  public boolean isSymmetric() {
    if (this.left == null && this.right == null) {
      return true;
    }
    if (this.left == null || this.right == null) {
      return false;
    }
    return this.left.isSymmetricallyEqualTo(this.right);
  }

  public boolean isSymmetricallyEqualTo(BinaryTreeNode other) {
    if (this.value != other.value) {
      return false;
    }

    // Ensure the left branch of this tree is the same as the right branch
    // of the other tree.
    if (this.left != null) {
      if (other.right == null || other.right.value != this.left.value) {
        return false;
      }
    } else {
      if (other.right != null) {
        return false;
      }
    }

    // Ensure the right branch of this tree is the same as the left branch
    // of the other tree.
    if (this.right != null) {
      if (other.left == null || other.left.value != this.right.value) {
        return false;
      }
    } else {
      if (other.left != null) {
        return false;
      }
    }

    return true;
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