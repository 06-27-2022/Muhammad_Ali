import java.util.Scanner;
import java.util.ArrayList;

public class ERS {
	static ArrayList<userAccount> registeredAccounts = new ArrayList<userAccount>();
	static ArrayList<Ticket> ticketsList = new ArrayList<Ticket>();
	static userAccount currentAccount = null;
	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		userAccount newAccount = new userAccount("Muhammad", "adison","Manager",1000000);
		registeredAccounts.add(newAccount);
		
		newAccount = new userAccount("ali", "adison");
		registeredAccounts.add(newAccount);
		
		
		boolean quit = false;
		
		while(!quit) {
			System.out.println();
			System.out.println("1) Login");
			System.out.println("2) Register");
			System.out.println("3) Show all employees");
			System.out.println("4) Quit");
			System.out.print("Select: ");
			
			int mainMenuOption = scan.nextInt();
			switch (mainMenuOption) {
			case 1:
				currentAccount = userAccount.login(); 
				if(currentAccount != null) 
					displayAccountMenu();				
				break;
			case 2:
				userAccount.register();
				break;
			case 3:
				userAccount.showAllEmployees();
				break;
			case 4:
				System.out.println("Exiting program...");
				quit = true;
				scan.close();
				break;
			}			
		}

	}

	static void displayAccountMenu() {
		System.out.println("Welcome " + currentAccount.username);	

		boolean logOut = false;		
		while(!logOut) {
			System.out.println();
			System.out.println("1) Show Balance");
			
			if(currentAccount.role == "Employee")
				System.out.println("2) Request Reimbursement");
			else if(currentAccount.role == "Manager")
				System.out.println("2) Reimbursement Requests");
			
			if(currentAccount.role == "Employee")
				System.out.println("3) Pending requests");
			
			System.out.println("4) Log out");
			System.out.print("Select: ");
			
			int userMenuOption = scan.nextInt();			
			switch (userMenuOption) {
			case 1:
				currentAccount.showAccountBalance();
				break;
			case 2:
				if(currentAccount.role == "Employee") {
					currentAccount.makeNewTicket();					
				}else if(currentAccount.role == "Manager")
					currentAccount.manageRequests();
				break;
			case 3:
				currentAccount.showEmployeePendingRequests();
				break;
			case 4:
				System.out.println("Logging out...");
				logOut = true;
				break;
			}	
		}		
	}


	
}
