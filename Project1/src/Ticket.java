public class Ticket {
	protected int amount;
	protected String description;
	protected String status;
	protected UserAccount madeBy;
	protected UserAccount reviewedBy;
	
	public Ticket() {
		
	}
	
	public Ticket(int amount, String description, String status, UserAccount madeBy, UserAccount reviewedBy) {
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.madeBy = madeBy;
		this.reviewedBy = reviewedBy;
	}
	
	
}
