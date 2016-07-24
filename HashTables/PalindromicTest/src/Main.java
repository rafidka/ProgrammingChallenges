import java.util.Collection;
import java.util.HashMap;

public class Main {
  /**
   * Determines whether the given string is palindrome or not.
   * @param str The string to be tested.
   * @return True or false.
   */
  public static Boolean isPalindrome(String str) {
    HashMap<Character, Integer> charCounts = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (!charCounts.containsKey(str.charAt(i))) {
        charCounts.put(str.charAt(i), 1);
      } else {
        charCounts.put(str.charAt(i), charCounts.get(str.charAt(i)) + 1);
      }
    }

    int oddChars = 0;
    Collection<Integer> values = charCounts.values();
    for (int v : values) {
      if (v % 2 != 0) {
        oddChars++;
      }
    }

    return oddChars <= 1;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("edified"));
  }
}
