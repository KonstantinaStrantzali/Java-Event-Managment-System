import java.io.Serializable;

abstract public class Event implements Serializable{

	private String name;
    private int id;
	private int capacity;
	private String location;
	private double ticketPrice;


	public Event(String name, int id,int capacity, String location, double ticketPrice) {
		this.name = name;
        this.id = id;
		this.capacity = capacity;
		this.location = location;
		this.ticketPrice = ticketPrice;
		
	}
	

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}
public int getEventId() {
	return this.id;
}

public void setEventId (int id) {
	this.id = id;
}


public int getCapacity() {
	return this.capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public String getLocation() {
	return this.location;
}

public void setLocation(String location) {
	this.location = location;
}

public double getTicketPrice() {
	return this.ticketPrice;
}

public void setTicketPrice(double ticketPrice) {
	this.ticketPrice = ticketPrice;
}

public abstract double studentDiscount();

public String fileRepresentation(){
	return this.name + "," + this.id  + "," + this.capacity  + "," + this.location  + "," + this.ticketPrice;

}
public String toString() {
	return "Event " + this.name + " Id " + this.id + "Capacity: " + this.capacity + ", Place: " + this.location +  " Price: " +  this.ticketPrice;
}


}