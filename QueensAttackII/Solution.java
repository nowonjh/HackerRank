import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        r_q--;
        c_q--;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] h: obstacles) {
            if (map.get(h[0] -1) == null) {
                map.put(h[0] -1, new ArrayList<>());
            }
            map.get(h[0] -1).add(h[1] -1);
        }
        int[][] test = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1, 1},
                {-1, -1},
                {-1, 1},
                {1, -1}
        };
        
        int result = 0;
        for (int[] t: test) {
            int x = r_q;
            int y = c_q;
            while (true) {
                x += t[0];
                y += t[1];
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                } else if (map.get(x) != null && map.get(x).contains(y)) {
                    break;
                } else {
                    result++;
                }
            }
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }
}
