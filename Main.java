import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ListIterator;
import java.util.Collection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

// Create ArrayList and HashMap for Event class so you manipulate the objects by indexes or key-pair values respectively

    ArrayList<Event> eventList = new ArrayList<Event>();
    Event tech1 = new Tech("Java for Beginners",1,100,"London",50.00, 2);
    Event tech2 = new Tech("Python for Beginners",2,60,"London",25.00, 1);
    Event tech3 = new Tech("Advanced Java",3,50,"Wales",130.00, 3);
    Event tech4 = new Tech("Cloud computing",4,30,"Wales",20.00, 1);
    Event con1 = new Concert("The return",5, 4000, "London", 50.00, "Bon Jovi",true);
    Event con2 = new Concert("The great tour", 6, 8000, "Wales", 60.00, "Rianna", true);
    Event con3 = new Concert("The grand finale", 7, 4000, "Wales", 20.00, "Stereophonics", false);	
    eventList.add(tech1);
    eventList.add(tech2);
    eventList.add(tech3);
    eventList.add(tech4);
    eventList.add(con1);
    eventList.add(con2);
    eventList.add(con3);


    HashMap <Integer, Event> eventMap = new HashMap<Integer, Event>();
    
    eventMap.put(tech2.getEventId(), tech2);
    eventMap.put(tech3.getEventId(), tech3);
    eventMap.put(tech4.getEventId(), tech4);
    eventMap.put(con1.getEventId(), con1);
    eventMap.put(con2.getEventId(), con2);
    eventMap.put(con3.getEventId(), con3);
    Set<Integer> eventIds = eventMap.keySet();

// Create a list of attendee
    List<Attendee> attendeeList = new ArrayList<Attendee>();  
    Attendee att1 = new Attendee(1, "Nick", con3);
    attendeeList.add(att1);
   
    HashMap <Integer, Attendee> attendeeMap = new HashMap<Integer, Attendee>();
    attendeeMap.put(att1.getAttId(), att1);
    Set<Integer> attendeeIds = attendeeMap.keySet(); 

//File handling Create and Store and Read the event objects

try{
    OutputStream os = new FileOutputStream("file_data/EventData.dat");
    ObjectOutputStream oos = new ObjectOutputStream(os);	
    oos.writeObject(eventMap);
    oos.close();
    os.close();	
}
catch(FileNotFoundException e){
    System.out.println(e);	
}
catch(IOException e){
    System.out.println(e);
}
    try{
        InputStream is = new FileInputStream("file_data/EventData.dat");
        ObjectInputStream ois = new ObjectInputStream(is); 
        Object o = ois.readObject();             
        HashMap <Integer, Event> e = (HashMap <Integer, Event>) o;
        System.out.println(e);
        ois.close();
        is.close();	
    }
    catch(ClassNotFoundException e){
        
        System.out.println(e);	
    }
    catch(FileNotFoundException e){
        
        System.out.println(e);	
    }
    catch(IOException e){
        
        System.out.println(e);
    }
 
System.out.println("Welcome to event Managment System");

Scanner intScanner = new Scanner(System.in);  
Scanner stringScanner = new Scanner(System.in);
int userChoice;

try{
do{
    System.out.println("-----------------MENU-------------------");
    System.out.println("(1)Insert 1 to see the Events happening\n(2)Insert event's id to view it\n(3) Insert 3 to Edit a new Event\n(4)Insert 4 to delete an event\n*********************************\n(5)Insert 5 to list the Attendees attending an event\n(6)Insert 6 to Add an attendee\n(7)Insert 7 to Delete an Attendee\n(0)Exit");

    userChoice = intScanner.nextInt();  
    switch(userChoice){
        // List the Events
        case 1: 
            for(Event e: eventList){
                System.out.println(e);
            } 
        break;

        // List events individually by id
        case 2 :
        int givenId = -1;
        while(!eventIds.contains(givenId)){
            System.out.println("Insert the id of the Event you want to view");
            givenId = intScanner.nextInt();
            System.out.println("Invalid Event id");
        }
        System.out.print(eventMap.get(givenId));
        break;

        // Update an event by id
        case 3:
            System.out.println("Enter Event Id to update");
            int eventId = intScanner.nextInt();
            ListIterator<Event>  li = eventList.listIterator();
            while (li.hasNext()){
                Event e = li.next();
                    if(e.getEventId() == eventId){   
                        System.out.println("Enter new Event name");
                        String newName = stringScanner.nextLine();    
                        System.out.println("Enter new id");
                        int newId = intScanner.nextInt();
                        System.out.println("Enter new capacity");
                        int newCapacity = intScanner.nextInt();
                        System.out.println("Enter location : London or Wales");
                        String newLocation = stringScanner.nextLine();
                        System.out.println("Enter new new Ticket Price");
                        double newTicPrice = intScanner.nextDouble();
                        System.out.println("Enter new duration");
                        int newDuration = intScanner.nextInt();
                        if(e instanceof Tech){
                            li.set(new Tech(newName,newId,newCapacity,newLocation,newTicPrice,newDuration));
                         } else if(e instanceof Concert){
                        System.out.println("Enter a singer");
                        String singer = stringScanner.nextLine();
                        li.set(new Concert(newName, newId, newCapacity,newLocation, newTicPrice, singer, false));
            }       } else{
                System.out.println("Invalid id");
                break;
            }
        } 
        break;

        //Delete an event by Id
        case 4:
        int idToDelete = -1;
        while(!eventIds.contains(idToDelete)){
            System.out.println("Insert the id of the event you want to delete");
            idToDelete = intScanner.nextInt();
            if(eventIds.contains(idToDelete)){
                eventMap.remove(idToDelete);
            } System.out.println("Invalid input number");
        }
        break;

        //List Attendees by their Events
        case 5:
        System.out.println("Insert the Events id to get the attendees ");
        Iterator<Attendee> al = attendeeList.iterator();
        int userId = intScanner.nextInt();
        al = attendeeList.iterator();
        while(al.hasNext()){
            Attendee a = al.next();
            if(a.getEvent().getEventId() == userId){
                System.out.println(a);
            } else {
                System.out.println("Insert a valid number");
            }
        }
        break;
        // Add an attendee in an Event and then display them to the user
        case 6:
            System.out.println("Insert Attendee Id"); 
            int attId = intScanner.nextInt();
            System.out.println("Insert Attendee Name");
            String attName = stringScanner.nextLine();
            System.out.println("Insert Event's Id"); 
            int eventAttId = intScanner.nextInt();
            for(Event e : eventList){ 
                if(eventAttId == e.getEventId()){
                    attendeeList.add(new Attendee(attId, attName, e));
                }
            } 


            Iterator <Attendee> itr = attendeeList.iterator();
            while (itr.hasNext()){
                Attendee i = itr.next();
                System.out.println(i);

            }
        break;
        //Delete an attendee and Display
        case 7:
        Iterator<Attendee> i = attendeeList.iterator();
        System.out.println("Insert the id of the Attendee you want to delete");
        int attIdToDelete = intScanner.nextInt();
        i = attendeeList.iterator();
        while (i.hasNext()){
            Attendee e = i.next();
            if (e.getAttId() == attIdToDelete){
                i.remove();
                break;
           }else{
            System.out.println("Invalid Id");
           }
            System.out.println(i);

        }
        
        System.out.println(attendeeList);
        
       
                          // Display the remained attendees list
      
        break;
        }	 
} 

while(userChoice!=0);
} catch(InputMismatchException e) {
 System.out.println(" Input a valid number");
}

 }


    
 

}