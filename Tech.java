import java.io.Serializable;

import java.io.Serializable;

public class Tech extends Event implements Serializable {

	int duration;

	public Tech(String name,int id, int capacity, String location, double ticketPrice, int duration) {
		super(name, id, capacity, location, ticketPrice);
		this.duration = duration;
	}
	


	@Override
	public double studentDiscount() {
	double discount = getTicketPrice() / 100 * 15;
    double totalDiscount = getTicketPrice() - discount;
    return totalDiscount;
	}

	@Override
    public String toString() {
		return super.toString() + " Duration " + this.duration + " days";
	}
}
