import static java.lang.System.out;

public class Main {
  public static void printTreeHeightBalanced(BinaryTreeNode node) {
    out.println("Tree: " + node.encode());
    out.println("Height: " + node.height());
    out.println("Balanced: " + node.isBalanced());
    out.println();
  }

  public static void main(String[] args) {
    printTreeHeightBalanced(BinaryTreeNode.decode("1"));
    printTreeHeightBalanced(BinaryTreeNode.decode("1,2,#,#,3,#,#"));
    printTreeHeightBalanced(BinaryTreeNode.decode("1,2,#,#,3,4,5,6,7,#,#"));
  }
}
