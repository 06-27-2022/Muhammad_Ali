
public class Split {
	public static void main(String[] args) {
		String date = "07/12/2022";
		
		String [] StrArr = date.split("/");
		System.out.println(StrArr[StrArr.length-1]);
	}
}
