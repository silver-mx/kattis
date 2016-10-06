import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by diego on 10/5/16.
 */
public class PizzaDeliveryTest {

    @Test
    public void calculateLowestDeliveryCost() throws Exception {
        int[][] matrixA = generateRandomMatrix(PizzaDelivery.NUM_ROWS, PizzaDelivery.NUM_COLS);
        int[][] matrixB = generateRandomMatrix(PizzaDelivery.NUM_ROWS, PizzaDelivery.NUM_COLS);
        long startTime = System.currentTimeMillis();
        Assert.assertTrue(PizzaDelivery.calculateMinDeliveryCost(matrixA) > 0);
        //Assert.assertTrue(PizzaDelivery.calculateMinDeliveryCost(matrixB) > 0);
        long totalTime = System.currentTimeMillis() - startTime;

        System.out.println("Total time: " + totalTime + " millis.");
    }

    private static int[][] generateRandomMatrix(int x, int y) {

        int[][] matrix = new int[x][y];

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                matrix[i][j] = (int) (Math.random() * (PizzaDelivery.MAX_DELIVERIES));
            }

            if (PizzaDelivery.IS_DEBUG) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }

        return matrix;
    }
}