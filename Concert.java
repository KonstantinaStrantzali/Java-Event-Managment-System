import java.io.Serializable;

public class Concert extends Event implements Serializable{

    String singer;
    boolean isIndoors;

	public Concert(String name, int id, int capacity, String location, double ticketPrice, String singer, boolean isIndoors) {
		super(name, id, capacity, location, ticketPrice);
		this.singer = singer;
        this.isIndoors = isIndoors;
	}
	


	@Override
	public double studentDiscount() {
	double discount = getTicketPrice() / 100 * 10;
    double totalDiscount = getTicketPrice() - discount;
    return totalDiscount;
	}

	@Override
    public String toString() {
		return super.toString() + " Singer " + this.singer + "Is indoors:" + this.isIndoors;
	}

    
}