import java.util.Arrays;

//alphabetical order
//show 2 chars if it repeats more than 2
// omit chars that appear once
public class ArraySort {
	public static void main(String[] args) {
		String givenStr = "badbadfcbbg";
		System.out.println(alterStr(givenStr));
	}
	
	public static String alterStr(String str) {
		char [] charArr = str.toCharArray();
		Arrays.sort(charArr);
		String sortedStr = new String(charArr);
		String newStr = "";
		
		System.out.println(sortedStr);
		for(int i =0; i<sortedStr.length();i++) {
			char currentChar = sortedStr.charAt(i);
			if(newStr.contains(String.valueOf(currentChar))) {
				continue;
			}
			int counter = 1;
			
			for(int j = i+1; j<sortedStr.length();j++) {
				if(currentChar == sortedStr.charAt(j)) {
					counter++;
				}
			}
			if(counter >1) {
				newStr = newStr + currentChar+ currentChar;
			}
		}
		
		
		return newStr;
	}
}
