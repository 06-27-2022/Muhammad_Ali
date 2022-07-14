
public class CharAt {
	public static void main(String[] args) {
			String myS = "learnByDoingny";
			
			char [] arr = myS.toCharArray();
			int counter = 0;
			String done = "";
			for(int i = 0; i < arr.length; i++) {
				if(done.indexOf(arr[i])== -1) {
					counter = 1;
					System.out.print("[" + arr[i] + ", ");
					for (int j = i+1; j <arr.length ; j++) {
						if(arr[i]== arr[j]) {
							counter++;
						}
					}
					System.out.print(counter + "]");
					done += arr[i];
				}
				
				
			}
	}
}
