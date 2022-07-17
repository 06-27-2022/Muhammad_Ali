package Utility;

import Main.ERS;
import Models.Ticket;

public class TicketUtil {
	static DAO dao = new DAO();
	
	public static void makeNewTicket() {

		System.out.println();
		int amount = InputValidation.enterPositiveInt("Enter amount: $");
		String description = InputValidation.enterString("Enter description: ");
		
		Ticket newTicket = new Ticket(0,amount, description, "Pending", ERS.currentAccount.getId(), 0);
		//dao.makeNewTicket(newTicket);
	}
	
	public static void showEmployeePendingRequests() {
		System.out.println();
		System.out.println("---------Pending requests---------");

		for (Ticket ticket: ERS.ticketsList) {
			if (ticket.getMadeByID() == ERS.currentAccount.getId() && ticket.getStatus().equals("Pending"))
				System.out.println(ticket);
		}
		System.out.println("--------------------------------");
	}
	
	public static void manageRequests() {
		System.out.println();
		System.out.println("---------Reimbursement requests---------");

		for (Ticket ticket: ERS.ticketsList) {
			if (ticket.getStatus().equals("Pending")) {
				System.out.println(ticket);

				char managerInput = InputValidation.enterChar("adAD","Accept(a)/ Decline(d): ");
				if (managerInput == 'a') {
					int managerNewBalance = ERS.currentAccount.getAccountBalance() - ticket.getAmount();
					dao.updateEmployeeBalance(ERS.currentAccount.getId(), managerNewBalance);
					
					int requesterNewBalance = AccountUtil.getAccountBalanceByID(ticket.getMadeByID()) + ticket.getAmount();
					dao.updateEmployeeBalance(ticket.getMadeByID(), requesterNewBalance);
					
					dao.updateTicketStatus(ticket.getTicketID(), "Approved", ERS.currentAccount.getId());
					
					System.out.println("Request approved.");
					//System.out.println("You now have $" + ERS.currentAccount.getAccountBalance() + " in your account.");
					
				} else if (managerInput == 'd') {
					System.out.println("Request declined.");
					dao.updateTicketStatus(ticket.getTicketID(), "Declined", ERS.currentAccount.getId());
					
				}
				
				System.out.println();
			}
			ERS.employeesList = dao.retrieveEmployeesList();
			//ERS.ticketsList = dao.retrieveTicketsList();
		}
		System.out.println("--------------------------------");
	}
}
