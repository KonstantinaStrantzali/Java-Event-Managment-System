import java.io.Serializable;

public class Attendee implements Serializable{

    private int attId;
    private String attName;
    private Event event;

        public Attendee(int attId, String attName, Event event){
            this.attId = attId;
            this.attName = attName;
            this.event = event;

    }

    public int getAttId() {
        return this.attId;
    }
    
    public void setAttId(int attId) {
        this.attId = attId;
    }
    public String getAttName() {
        return this.attName;
    }
    
    public void setAttName(String attName) {
        this.attName = attName;
    }

    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    public String toString() {
        return "Name " + this.attName + " Id " + this.attId + " Attends Event " + this.event;
    }
    
}
