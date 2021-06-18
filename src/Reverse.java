import java.util.Scanner;
import java.util.stream.IntStream;

public class Reverse {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        IntStream.range(0, n).forEach(i -> {
            array[i] = scanner.nextInt();
        });

        for(int i = n-1 ; i >= 0 ; i--) {
            System.out.println(array[i]);
        }
    }
}
