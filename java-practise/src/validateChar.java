import java.util.Scanner;

public class validateChar {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char input = Character.MIN_VALUE;

		System.out.print("Accept(a)/ Deny(d): ");
		String msg = "["+ "adAD" + "]";
		
		while (!scan.hasNext(msg)) {
			System.out.println("Not a valid input!");
			System.out.println();
			System.out.print("Accept(a)/ Deny(d): ");
			input = scan.nextLine().toLowerCase().charAt(0);
		}
		input = scan.nextLine().toLowerCase().charAt(0);
		if (input == 'a') {
			System.out.println("Accepted. " + input);
		} else if (input == 'd') {
			System.out.println("Denied."+ input);
		}
		System.out.println("Exited with " + input);
		
		scan.close();
	}
}
