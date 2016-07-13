public class Main {
  public static int find(int[] array, int elem) {
    int l = 0;
    int r = array.length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (array[m] == elem) {
        return m;
      } else if (array[m] < elem) {
        // The element we want is larger than the one in the middle.
        if (array[m] <= array[r] && elem <= array[r]) {
          l = m + 1;
        } else if (array[l] >= array[m]) {
          r = m - 1;
        } else if (array[m] >= array[r]) {
          l = m + 1;
        } else {
          break;
        }
      } else {
        // The element we want is smaller than the one in the middle.
        if (array[l] <= array[m] && array[l] <= elem) {
          r = m - 1;
        } else if (array[l] >= array[m]) {
          r = m - 1;
        } else if (array[m] >= array[r]) {
          l = m + 1;
        } else {
          break;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] array = new int[] { 20, 30, 100, 102, 509, 1000, 2000, 9800, 12000, 12001, 12502, 1, 3, 7, 12, 15, 16, 17, 18};
    System.out.println(find(array, array[10]));
    for (int i : array) {
      System.out.println(find(array, i));
    }
  }
}
