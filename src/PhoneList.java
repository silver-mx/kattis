import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = Integer.valueOf(scan.nextLine());
		
		while (t-- > 0) {
			int n = Integer.valueOf(scan.nextLine());
			
			List<String> phonesLst = new ArrayList<String>();
			while (n-- > 0) {
				String phone = scan.nextLine();
				phonesLst.add(phone);
			}
			
			System.out.println(isConsistent(phonesLst));
		}
	}
	
	private static boolean isConsistent(List<String> phoneLst) {
	
		for (String phone : phoneLst) {
			int matches = (int) phoneLst.stream().filter(item -> item.startsWith(phone) && !item.equals(phone)).count();
			if (matches > 0) {
				return false;
			}
		}
		
		return true;
	}
}
