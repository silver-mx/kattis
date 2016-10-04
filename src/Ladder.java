import java.util.Scanner;

public class Ladder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int v = scan.nextInt();
		System.out.println((int) Math.ceil(h/Math.sin(Math.toRadians(v))));
	}

}
