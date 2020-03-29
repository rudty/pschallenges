import java.io.*;
import java.util.*;

public class Solution {

    static int[][] offsetXY = new int[][]{
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1}, // 6
            {-1, 1},
    };

    static TreeSet<Integer> EMPTY_SET = new TreeSet<>();
    static TreeMap<Integer, TreeSet<Integer>> obstaclesYX = new TreeMap<>();

    static boolean canMove(int n, int x, int y) {
        if (x >= 0 &&
                y >= 0 &&
                x < n &&
                y < n) {
            TreeSet<Integer> s = obstaclesYX.getOrDefault(y, EMPTY_SET);
            boolean contain = s.contains(x);
            return !contain;
        }
        return false;
    }
    // Complete the queensAttack function below.
    static int queensAttack(int n, int beginY, int beginX) {
        beginY -= 1;
        beginX -= 1;
        int moveCount = 0;
        for (int[] xy : offsetXY) {
            int x = beginX;
            int y = beginY;
            x += xy[0];
            y += xy[1];

            while (canMove(n, x, y)) {
                //System.out.println((x + 1) + " " + (y + 1));
                x += xy[0];
                y += xy[1];

                moveCount += 1;
            }
        }
        return moveCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);


        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int y = Integer.parseInt(obstaclesRowItems[0]);
            int x = Integer.parseInt(obstaclesRowItems[1]);
            TreeSet<Integer> s = obstaclesYX.computeIfAbsent(y - 1, a -> new TreeSet<>());
            s.add(x - 1);
        }

        int result = queensAttack(n, r_q, c_q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
