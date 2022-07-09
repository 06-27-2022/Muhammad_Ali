public class Ticket {
	int amount;
	String description;
	String status;
	userAccount madeBy;
	userAccount reviewedBy;
	
	public Ticket() {
		
	}
	
	public Ticket(int amount, String description, String status, userAccount madeBy, userAccount reviewedBy) {
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.madeBy = madeBy;
		this.reviewedBy = reviewedBy;
	}
	
	
}
