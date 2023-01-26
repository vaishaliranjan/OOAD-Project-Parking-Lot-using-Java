import java.util.ArrayList;

public class ParkingLot {
    private String name;
    private int capacity;
    private String Location;

    public double getParkingCharges() {
        return parkingCharges;
    }

    private double parkingCharges;



    private Admin admin;

    private AutomatedSystem automatedSystem;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<ParkingSpot> availableSpots;
    private DisplayBoard displayBoard;



    public ParkingLot(String name, int capacity, String location, double parkingCharges, AutomatedSystem automatedSystem, DisplayBoard displayBoard) {
        this.name = name;
        this.capacity = capacity;
        Location = location;
        this.parkingCharges = parkingCharges;
        this.automatedSystem = automatedSystem;
        this.automatedSystem.setParkingLot(this);
        this.displayBoard = displayBoard;
        this.parkingSpots = createParkingSpots(capacity);
        availableSpots = (ArrayList<ParkingSpot>) parkingSpots.clone();
    }
    private ArrayList<ParkingSpot> createParkingSpots(int capacity){
        ArrayList<ParkingSpot> tempList = new ArrayList<>();
        for (int i = 0; i <capacity ; i++) {
            ParkingSpot temp = new ParkingSpot("MPL "+i);
            tempList.add(temp);
        }
        return tempList;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public ParkingSpot getAvailableSpot() {
        return availableSpots.remove(0);
    }

    public int getAvailability(){
        return availableSpots.size();
    }

    public void updateParkingCharges(double newCharges){
        this.parkingCharges = newCharges;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public static void main(String[] args) {
        DisplayBoard displayBoard = new DisplayBoard();
        AutomatedSystem automatedSystem = new AutomatedSystem(1);
        ParkingLot myParkingLot = new ParkingLot("MyParkingLot",4, "Sec-135,Noida",50,automatedSystem,displayBoard);

        System.out.println("\n");
        System.out.println("******************************************************************************************");
        System.out.println("*                                                                                        *");
        System.out.println("*                                                                                        *");
        System.out.println("*                                                                                        *");
        System.out.println("*                           WELCOME TO JIIT PARKING LOT                                  *");
        System.out.println("*                                                                                        *");
        System.out.println("*                          (Your Vehicle is Safe with Us)                                *");
        System.out.println("*                                                                                        *");
        System.out.println("*                                                                                        *");
        System.out.println("******************************************************************************************\n\n\n\n");
       
        System.out.println("Capacity: ");
        // Checking the availability of this parking Lot

        int availavility = myParkingLot.getAvailability();
        System.out.println(availavility);

        System.out.println("\n");

        // Creating Customer
        Customer vaishali = new Customer("Vaishali","UP85 AX 5454");

        // Automated System Generating Ticket
        Ticket vaishaliTicket = myParkingLot.automatedSystem.generateTicket(vaishali);

        // Printing Ticket Info
        System.out.println(vaishaliTicket);

        System.out.println("\n");

        // Creating Customer
        Customer asmi = new Customer("Asmi","UP86 AB 9999");

        // Automated System Generating Ticket
        Ticket asmiTicket = myParkingLot.automatedSystem.generateTicket(asmi);

        // Printing Ticket Info
        System.out.println(asmiTicket);

        System.out.println("\n");

         // Creating Customer
         Customer tanmay = new Customer("Tanmay","UP86 DK 6810");

         // Automated System Generating Ticket
         Ticket tanmayTicket = myParkingLot.automatedSystem.generateTicket(tanmay);
 
         // Printing Ticket Info
         System.out.println(tanmayTicket);

         System.out.println("\n");

         // Creating Customer
         Customer pulkit = new Customer("Pulkit","UP86 ACC 5473");

         // Automated System Generating Ticket
         Ticket pulkitTicket = myParkingLot.automatedSystem.generateTicket(pulkit);
 
         // Printing Ticket Info
         System.out.println(pulkitTicket);

         System.out.println("\n");

         // Creating Customer
         Customer shantanu = new Customer("Shantanu","UP86 AB 4567");

         // Automated System Generating Ticket
         Ticket shantanuTicket = myParkingLot.automatedSystem.generateTicket(shantanu);
 
         // Printing Ticket Info
         System.out.println(shantanuTicket);
         //Exceed Capacity

       

    }

}