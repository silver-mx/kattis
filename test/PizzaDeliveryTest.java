import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by diego on 10/5/16.
 */
public class PizzaDeliveryTest {

    @Test
    public void calculateLowestDeliveryCost() throws Exception {
        Assert.assertTrue(PizzaDelivery.calculateMinDeliveryCost(generateRandomMatrix(PizzaDelivery.NUM_ROWS, PizzaDelivery.NUM_COLS)) > 0);
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