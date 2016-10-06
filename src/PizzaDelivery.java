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

    private int[][] allCostsMatrix;
    private char[][] marks;
    private int minCost;

    public PizzaDelivery(int n) {
        allCostsMatrix = new int[n][n];
        minCost = Integer.MAX_VALUE;
        marks = new char[n][n];
    }

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

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
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

        PizzaDelivery delivery = new PizzaDelivery(matrix.length);
        int minCost = delivery.calculateMinCostFor(matrix);
        System.out.println(minCost + " blocks");

        return minCost;
    }

    private int calculateMinCostFor(int[][] matrix) {

        if (IS_DEBUG) {
            System.out.println("************ COSTS **************");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                calculateCostFor(i, j, matrix);

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


    private void calculateCostFor(int x, int y, int[][] matrix) {
        int[][] costMatrix = new int[matrix.length][matrix.length];

        if (IS_DEBUG) {
            System.out.println("************ MATRIX[" + x + "][" + y + "] **************");
        }

        int upToHalfMatrix = (int) Math.ceil(matrix.length / 2);

        for (int i = 0; i < upToHalfMatrix; i++) {

            for (int j = i; j < matrix.length - i; j++) {


                int distance = (Math.abs(x - i) + Math.abs(y - j));

                //if (costMatrix[i][j] != 0) throw new IllegalStateException("Trying to set value");
                costMatrix[i][j] = matrix[i][j] * distance;
                allCostsMatrix[x][y] += costMatrix[i][j];
                marks[i][j] = 'X';

                if (i != matrix.length - (i + 1) && j != matrix.length - (j + 1)) {

                    int distanceB = (Math.abs(x - (matrix.length - (i + 1))) + Math.abs(y - (matrix.length - (j + 1))));

                    costMatrix[matrix.length - (i + 1)][matrix.length - (j + 1)] = matrix[matrix.length - (i + 1)][matrix.length - (j + 1)] * distanceB;
                    allCostsMatrix[x][y] += costMatrix[matrix.length - (i + 1)][matrix.length - (j + 1)];

                    marks[matrix.length - (i + 1)][matrix.length - (j + 1)] = '#';
                }

                if (i != j && j < matrix.length - 1 && j != (matrix.length - (i + 1))) {

                    int distanceOpposite = (Math.abs(x - j) + Math.abs(y - i));
                    costMatrix[j][i] = matrix[j][i] * distanceOpposite;
                    allCostsMatrix[x][y] += costMatrix[j][i];

                    marks[j][i] = '-';

                    int distanceD = (Math.abs(x - (matrix.length - (j + 1))) + Math.abs(y - (matrix.length - (i + 1))));
                    costMatrix[matrix.length - (j + 1)][matrix.length - (i + 1)] = matrix[matrix.length - (j + 1)][matrix.length - (i + 1)] * distanceD;
                    //System.out.println("i=" + (matrix.length - (j + 1)) + " j = " + (matrix.length - (i + 1)) + " distance = " + distanceD +  " total = " +  costMatrix[matrix.length - (j + 1)][matrix.length - (i + 1)]);
                    allCostsMatrix[x][y] += costMatrix[matrix.length - (j + 1)][matrix.length - (i + 1)];
                    marks[matrix.length - (j + 1)][matrix.length - (i + 1)] = '%';
                }

            }


        }

        if (IS_DEBUG) {
            System.out.println("Calculated cost: " + allCostsMatrix[x][y]);
        }

        if (IS_DEBUG) {

            for (int k = 0; k < matrix.length; k++) {
                //System.out.println(Arrays.toString(marks[k]));
            }

            for (int k = 0; k < matrix.length; k++) {
                System.out.println(Arrays.toString(costMatrix[k]));
            }
        }

    }

}