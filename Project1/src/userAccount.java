public class userAccount {
	String username ;
	String password ;
	String role;
	private int accountBalance;
	
	userAccount(String username, String password){
		this.username = username;
		this.password = password;
		this.role = "Employee";
	}
	userAccount(String username, String password,String role, int accountBalance){
		this(username, password);
		this.role = role;
		this.accountBalance = accountBalance;
	}
	
	static userAccount login() {
		ERS.scan.nextLine(); // fixes scanner bug
		
		System.out.println();
		System.out.println("---------Log in---------");
		System.out.print("Enter username: ");
		String username = ERS.scan.nextLine();
		
		System.out.print("Enter password: ");
		String password = ERS.scan.nextLine();
		
		if(ERS.registeredAccounts.isEmpty()) {
			System.out.println("No existing account.");
		}else {
			for (userAccount account: ERS.registeredAccounts) {
				if(username.equals(account.username) && password.equals(account.password)) {
					return account;
				}
			}
			System.out.println("Wrong username or password");
		}
		return null;	
	}
	
	static void register() {
		ERS.scan.nextLine(); // fixes scanner bug
		
		System.out.println();
		System.out.println("---------Register an account---------");
		String username = "";
		
		boolean usernamePicked = false;
		while(!usernamePicked) {
			System.out.print("Enter username: ");
			username = ERS.scan.nextLine();
			
			if(ERS.registeredAccounts.isEmpty()) {
				usernamePicked = true;
			}else {
				for(userAccount account: ERS.registeredAccounts) {
					if(username.equals(account.username)) {
						System.out.println("Username already taken.");
						usernamePicked = false;
						break;
					} else {
						usernamePicked = true;
					}
				}
			}

		}
		
		System.out.print("Enter password: ");
		String password = ERS.scan.nextLine();
		
		userAccount newAccount = new userAccount(username, password);
		ERS.registeredAccounts.add(newAccount);
	}
	
	static void showAllEmployees() {

		System.out.println();
		System.out.println("---------Employees list---------");
		
		for(int i = 0; i <ERS.registeredAccounts.size();i++) {
			System.out.println((i+1) + ". " +
					ERS.registeredAccounts.get(i).username + " - " + 
					ERS.registeredAccounts.get(i).role);
		}
		System.out.println("--------------------------------");
		
	}

	public void showAccountBalance() {
		System.out.println("Account balance: $" + accountBalance);
	}

	public void makeNewTicket() {
		
		System.out.println();
		System.out.print("Enter amount: ");
		int amount = ERS.scan.nextInt();
		
		ERS.scan.nextLine(); // fixes scanner bug
		System.out.print("Enter description: ");
		String description = ERS.scan.nextLine();
		
		Ticket newTicket = new Ticket(amount, description, "Pending", ERS.currentAccount, null);
		ERS.ticketsList.add(newTicket);
	}
	
	public void showEmployeePendingRequests() {
		System.out.println();
		System.out.println("---------Pending requests---------");
		
		for(int i = 0; i <ERS.ticketsList.size();i++) {
			if(ERS.ticketsList.get(i).madeBy.equals(ERS.currentAccount) &&
					ERS.ticketsList.get(i).status == "Pending") {
				System.out.println((i+1) + ". $" +
						ERS.ticketsList.get(i).amount + " - " +
						ERS.ticketsList.get(i).description + " - " + 
						ERS.ticketsList.get(i).status);
			}
			
		}
		System.out.println("--------------------------------");
	}

	public void manageRequests() {
		System.out.println();
		System.out.println("---------Reimbursement requests---------");
		
		for(int i = 0; i <ERS.ticketsList.size();i++) {
			if(ERS.ticketsList.get(i).status == "Pending") {
				System.out.println((i+1) + ". $" +
						ERS.ticketsList.get(i).amount + " - " + 
						ERS.ticketsList.get(i).description + " - " + 
						ERS.ticketsList.get(i).madeBy.username);
				
				System.out.println("Accept(a)/ Deny(d): ");
				char managerInput = ERS.scan.next().charAt(0);
				if(managerInput == 'a') {
					ERS.currentAccount.accountBalance -= ERS.ticketsList.get(i).amount;
					ERS.ticketsList.get(i).madeBy.accountBalance += ERS.ticketsList.get(i).amount;
					ERS.ticketsList.get(i).status = "Approved";
					System.out.println("Request accepted.");
					System.out.println("You now have $" + ERS.currentAccount.accountBalance + " in your account.");
				}else if(managerInput == 'd') {
					System.out.println("Request denied.");
					ERS.ticketsList.get(i).status = "Denied";
				}
			}
			System.out.println();
		}		
		System.out.println("--------------------------------");
	}
}
