import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static class Point extends Object {
    public int i;
    public int j;

    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Point)) {
        return false;
      }
      Point point = (Point) obj;
      return this.i == point.i && this.j == point.j;
    }

    @Override
    public int hashCode() {
      return 37 * this.i + this.j;
    }
  }

  public static int[] longestIncreasingSequence(int[][] grid) {
    int[] longest = null;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        int[] seq = longestSequenceFromPoint(grid, new HashSet<>(), i, j);
        if (longest == null || seq.length > longest.length) {
          longest = seq;
        }
      }
    }
    return longest;
  }

  public static int[] longestSequenceFromPoint(int[][] grid, HashSet<Point> visited,
                                               int i, int j) {
    /*Point key = new Point(i, j);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }*/

    int[] dis = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] djs = {1, 0, -1, 1, -1, 1, 0, -1};

    int[] maxSeq = {grid[i][j]};
    for (int n = 0; n < dis.length; n++) {
      int di = dis[n];
      int dj = djs[n];
      int new_i = i + di;
      int new_j = j + dj;

      if (new_i < 0 || new_i >= grid.length) {
        continue;
      }
      if (new_j < 0 || new_j >= grid[new_i].length) {
        continue;
      }
      if (grid[new_i][new_j] <= grid[i][j]) {
        continue;
      }
      Point p = new Point(new_i, new_j);
      if (visited.contains(p)) {
        continue;
      }
      visited.add(p);

      int[] start = {grid[i][j]};
      int[] subSeq = longestSequenceFromPoint(grid, visited, new_i, new_j);

      visited.remove(p);

      if ((1 + subSeq.length) <= maxSeq.length) {
        continue;
      }
      maxSeq = new int[1 + subSeq.length];

      System.arraycopy(start, 0, maxSeq, 0, 1);
      System.arraycopy(subSeq, 0, maxSeq, 1, subSeq.length);

    }

    return maxSeq;
  }

  public static void main(String[] args) {
    int[][] grid = {
        {97, 47, 56, 36, 60, 31, 57, 54, 12, 55},
        {35, 57, 41, 13, 82, 80, 71, 93, 31, 62},
        {89, 36, 98, 75, 91, 46, 95, 53, 37, 99},
        {25, 45, 26, 17, 15, 82, 80, 73, 96, 17},
        {75, 22, 63, 96, 96, 36, 64, 31, 99, 86},
        {12, 80, 42, 74, 54, 14, 93, 17, 14, 55},
        {14, 15, 20, 71, 34, 50, 22, 60, 32, 41},
        {90, 69, 44, 52, 54, 73, 20, 12, 55, 52},
        {39, 33, 25, 31, 76, 45, 44, 84, 90, 52},
        {94, 35, 55, 24, 41, 63, 87, 93, 79, 24}
    };
    int[] seq = longestIncreasingSequence(grid);
    System.out.println(Arrays.toString(seq));
  }
}
