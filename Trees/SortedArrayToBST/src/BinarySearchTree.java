import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree {
  public int value;
  public BinarySearchTree left;
  public BinarySearchTree right;

  public BinarySearchTree(int value) {
    this.value = value;
  }

  public void add(int value) {
    if (value < this.value) {
      if (this.left == null) {
        this.left = new BinarySearchTree(value);
      } else {
        this.left.add(value);
      }
    } else {
      if (this.right == null) {
        this.right = new BinarySearchTree(value);
      } else {
        this.right.add(value);
      }
    }
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

  public static BinarySearchTree fromSortedArray(int[] array) {
    int s = 0;
    int e = array.length - 1;
    int m = s + (e - s) / 2;
    BinarySearchTree bst = new BinarySearchTree(array[m]);
    addSortedArrayElems(bst, array, 0, m - 1);
    addSortedArrayElems(bst, array, m + 1, e);
    return bst;
  }

  private static void addSortedArrayElems(BinarySearchTree bst, int[] arr, int s, int e) {
    if (s > e) {
      return;
    }
    int m = s + (e - s) / 2;
    bst.add(arr[m]);
    addSortedArrayElems(bst, arr, s, m - 1);
    addSortedArrayElems(bst, arr, m + 1, e);
  }
}