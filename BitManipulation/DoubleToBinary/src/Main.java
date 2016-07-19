public class Main {
  public static String doubleToBinary(double d) {
    StringBuffer buf = new StringBuffer();

    buf.append("0.");
    int maxBits = 30;

    while (maxBits-- > 0 && d != 0) {
      d *= 2;
      if (d >= 1) {
        buf.append("1");
        d -= 1;
      } else {
        buf.append("0");
      }
    }

    if (maxBits <= 0 && d != 0) {
      return "ERROR";
    }

    return buf.toString();
  }

  public static void main(String[] args) {
    System.out.println(doubleToBinary(0.25));
    System.out.println(doubleToBinary(0.05));
    System.out.println(doubleToBinary(0.5));
    System.out.println(doubleToBinary(0.75));
  }
}
