import java.util.Scanner;

public class Planina {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        var points = calculatePoints(n);
        System.out.println("Points=" + points);

    }

    private static int calculatePoints(int n) {
        int m = (int) Math.pow(2, n) + 1;
        return m * m;
    }
}

