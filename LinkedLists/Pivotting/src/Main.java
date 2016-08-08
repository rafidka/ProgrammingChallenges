public class Main {
  private static class ListNode<E> {
    E value;
    ListNode<E> next;

    ListNode() {

    }

    ListNode(E[] values) {
      if (values.length == 0) {
        throw new IllegalArgumentException();
      }
      ListNode<E> node = this;
      for (int i = 0; i < values.length; i++) {
        node.value = values[i];
        if (i < values.length - 1) {
          node.next = new ListNode<>();
          node = node.next;
        }
      }
    }
  }

  private static ListNode<Integer> partition(ListNode<Integer> list, int x) {
    ListNode<Integer> smallerFirst = null;
    ListNode<Integer> smaller = null;
    ListNode<Integer> equalFirst = null;
    ListNode<Integer> equal = null;
    ListNode<Integer> greaterFirst = null;
    ListNode<Integer> greater = null;
    ListNode<Integer> iter = list;
    while (iter != null) {
      if (iter.value < x) {
        if (smaller == null) {
          smaller = smallerFirst = iter;
        } else {
          smaller.next = iter;
          smaller = iter;
        }
      } else if (iter.value == x) {
        if (equal == null) {
          equal = equalFirst = iter;
        } else {
          equal.next = iter;
          equal = iter;
        }
      } else {
        if (greater == null) {
          greater = greaterFirst = iter;
        } else {
          greater.next = iter;
          greater = iter;
        }
      }
      iter = iter.next;
    }

    if (smaller != null) {
      if (equal != null) {
        smaller.next = equal;
      } else {
        smaller.next = greater;
      }
    }

    if (equal != null) {
      equal.next = greater;
    }

    if (greater != null) {
      greater.next = null;
    }

    if (smallerFirst != null) {
      return smallerFirst;
    } else if (equalFirst != null) {
      return equalFirst;
    } else {
      return greaterFirst;
    }
  }

  public static void main(String[] args) {
    ListNode<Integer> list = new ListNode<>(new Integer[]{2, 3, 10, -1, 0, 100, 9});
    list = partition(list, 10);
    while (list != null) {
      System.out.println(list.value);
      list = list.next;
    }
  }
}
