import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by diego on 10/5/16.
 */
public class PizzaDelivery {

    public static final int MAX_DELIVERIES = 1000;
    public static boolean IS_DEBUG = false;
    public static final int NUM_ROWS = 100;
    public static final int NUM_COLS = 100;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());

        while (n-- > 0) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            if (x > y) {
                x = y;
            } else {
                y = x;
            }
            int[][] matrix = new int[x][y];

            for (int i = 0; i < matrix.length ; i++) {
                for (int j = 0; j < matrix[i].length ; j++) {
                    matrix[i][j] = scan.nextInt();
                }

                if (IS_DEBUG) {
                    System.out.println(Arrays.toString(matrix[i]));
                }
            }

            calculateMinDeliveryCost(matrix);
        }
    }

    public static int calculateMinDeliveryCost(int[][] matrix) {

        long startTime = System.currentTimeMillis();
        int minCost = calculateMinCostFor(matrix);
        if (IS_DEBUG) System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " millis");

        System.out.println(minCost + " blocks");

        return minCost;
    }

    private static int calculateMinCostFor(int[][] matrix) {

        int[][] allCostsMatrix = new int[matrix.length][matrix[0].length];
        int minCost = Integer.MAX_VALUE;

        if (IS_DEBUG) {
            System.out.println("************ COSTS **************");
        }

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                allCostsMatrix[i][j] = calculateCostFor(i, j, matrix);

                if (allCostsMatrix[i][j] < minCost) {
                    minCost = allCostsMatrix[i][j];
                }
            }

            if (IS_DEBUG) {
                System.out.println(Arrays.toString(allCostsMatrix[i]));
            }
        }

        if (IS_DEBUG) {
            System.out.println("Min cost: " + minCost);
        }

        return minCost;
    }


    private static int calculateCostFor(int x, int y, int[][] matrix) {
        int[][] costMatrix = new int[matrix.length][matrix[x].length];
        int totalCost = 0;

        if (IS_DEBUG) {
            System.out.println("************ MATRIX[" + x + "][" + y + "] **************");
        }

        for (int i = 0; i < matrix.length ; i++) {

            for (int j = 0; j < matrix[i].length ; j++) {

                if (i != x || j != y) {
                    costMatrix[i][j] = matrix[i][j] * (Math.abs(x - i) + Math.abs(y - j));
                    totalCost += costMatrix[i][j];
                }

            }

            if (IS_DEBUG) {
                System.out.println(Arrays.toString(costMatrix[i]));
            }
        }

        if (IS_DEBUG) {
            System.out.println("Calculated cost: " + totalCost);
        }

        return totalCost;
    }

}
