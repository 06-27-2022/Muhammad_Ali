
public class ToCharArray {
	public static void main(String[] args) {
		String names = "asBcDeE";
		int j;
		String result = "";
		char[] charNames = names.toCharArray();
		for (char i : charNames) {
			if (Character.isUpperCase(i)) {
				j = (int) i;
				result += j;
			} else
				result += i;
		}
		
		System.out.println(result);

	}
}
