public class Main {
  public static boolean stringExistsInGrid(Character[][] grid, String string) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == string.charAt(0)) {
          if (substringExistsInGrid(grid, string.substring(1), i, j)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public static boolean substringExistsInGrid(Character[][] grid, String subStr, int i, int j) {
    if (subStr.length() == 0) {
      return true;
    }

    if (i > 0 && grid[i - 1][j] == subStr.charAt(0) &&
        substringExistsInGrid(grid, subStr.substring(1), i - 1, j)) {
      return true;
    }

    if (i < grid.length - 1 && grid[i + 1][j] == subStr.charAt(0) &&
        substringExistsInGrid(grid, subStr.substring(1), i + 1, j)) {
      return true;
    }

    if (j > 0 && grid[i][j - 1] == subStr.charAt(0) &&
        substringExistsInGrid(grid, subStr.substring(1), i, j - 1)) {
      return true;
    }

    if (j < grid[i].length - 1 && grid[i][j + 1] == subStr.charAt(0) &&
        substringExistsInGrid(grid, subStr.substring(1), i, j + 1)) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    Character[][] grid = new Character[4][];
    grid[0] = new Character[] { 'a', 't', 'o', 'a' };
    grid[1] = new Character[] { 'm', 's', 't', 's' };
    grid[2] = new Character[] { 'a', 'z', 'o', 'n' };
    grid[3] = new Character[] { 't', 'o', 'c', 'd' };
    System.out.println(stringExistsInGrid(grid, "toast"));
  }
}
