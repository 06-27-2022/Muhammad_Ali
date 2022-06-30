public class gradingCalculator {
	public static void main(String[] args) {
		int [] arr = {95, 85, 62, 40, 79};
		for (int i = 0; i<arr.length;i++) {
			switch(i) {
			case 0:
				System.out.print("Math: ");
				break;
			case 1:
				System.out.print("English: ");
				break;
			case 2:
				System.out.print("Science: ");
				break;
			case 3:
				System.out.print("History: ");
				break;
			case 4:
				System.out.print("Art: ");
			}
			
			if(arr[i] >= 90 && arr[i] <=100) {
				System.out.println("A");
			}else if(arr[i] >= 80 && arr[i] <90) {
				System.out.println("B");
			}else if(arr[i] >= 70 && arr[i] <80) {
				System.out.println("C");
			}else if(arr[i] >= 60 && arr[i] <70) {
				System.out.println("D");
			}else if(arr[i] <60) {
				System.out.println("F");
			}
	}
}
	}
