public class Main {

  public static void main(String[] args) {
    BinarySearchTree bst = BinarySearchTree.fromSortedArray(new int[] { 1, 2, 30, 40, 50, 100, 1000, 1999});
    System.out.println(bst.encode());
  }
}
