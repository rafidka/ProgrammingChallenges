public class Main {
  public static String compress(String str) {
    if (compressedSize(str) >= str.length()) {
      return str;
    }

    StringBuffer buf = new StringBuffer();
    char c = str.charAt(0);
    int count = 1;
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) != c) {
        buf.append(c);
        buf.append(count);
        c = str.charAt(i);
        count = 1;
      } else {
        count++;
      }
    }

    buf.append(c);
    buf.append(count);

    return buf.toString();
  }

  public static int compressedSize(String str) {
    int size = 0;
    int count = 1;
    char c = str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) != c) {
        size += 1 + String.valueOf(count).length();
        c = str.charAt(i);
        count = 1;
      } else {
        count++;
      }
    }
    size += 1 + String.valueOf(count).length();

    return size;
  }

  public static void main(String[] args) {
    System.out.println(compress("aabcccccaaa"));
    System.out.println(compress("aabccdeeaa"));
    System.out.println(compress("aabccaa"));
  }
}
