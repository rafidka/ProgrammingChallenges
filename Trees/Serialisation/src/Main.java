public class Main {

  public static void main(String[] args) {
    BinaryTreeNode node = BinaryTreeNode.decode("1,2,#,#,3,#,#");
    System.out.println(node.value);
    System.out.println(node.left.value);
    System.out.println(node.right.value);
    System.out.println(node.encode());
  }
}
