package carrun;
import cars.Car;
import swift.Swift;
import xuv.XUV;
import scross.Scross;
import java.util.Scanner;
import utilities.InvalidInputException;
public class CarRun{
	
public static void main(String[] args){
	    try{
	    Scanner scan=new Scanner(System.in);
		CarRun car=new CarRun();
		Car cars= new Car(" ");
		Swift swift=new Swift();
		XUV xuv=new XUV();
		System.out.println(xuv);
		Scross scross=new Scross();
		car.carObj(swift);
		
		scross.maintenance();
		
		cars.maintenance();
		swift.maintenance();
		
		int x=0;
		do{
		System.out.println("___________________________________________");
		System.out.println("\nChoose your car: \n 1.Swift\n 2.Scross\n 3.XUV");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice){
		
		case 1:
		System.out.println("No. of seats in Swift:");
		swift.setSeats(scan.nextInt());
		scan.nextLine();
		System.out.println("No. of airbags in swift:");
		swift.setAirbags(scan.nextInt());
		scan.nextLine();
		System.out.println("Your preferred model for swift:");
		swift.setModel(scan.nextLine());
		System.out.println("Your preferred Color for swift:");
		swift.setColor(scan.nextLine());
		System.out.println("The swift manufactured in:");
		cars.setYearOfMake(scan.nextInt());
		scan.nextLine();
		System.out.println("The type of swift:");
		cars.setType(car.carType(swift));
		System.out.println("The Engine Number of the swift:");
		cars.setEngineNumber(scan.nextLine());
		System.out.println("Details of swift:\n Model: "+swift.getModel()+"\n Color: "+swift.getColor()+"\n No. of seats: "+swift.getSeats()+"\n No.of Airbags: "+swift.getAirbags()+"\n Manufactured Year: "+cars.getYearOfMake()+"\n Type: "+cars.getType()+"\nEngine Number: "+cars.getEngineNumber());
		break;
		
		case 2:
		System.out.println("No. of seats in Scross:");
		scross.setSeats(scan.nextInt());
		scan.nextLine();
		System.out.println("No. of airbags in Scross:");
		scross.setAirbags(scan.nextInt());
		scan.nextLine();
		System.out.println("Your preferred model for Scross:");
		scross.setModel(scan.nextLine());
		System.out.println("Your preferred Color for scross:");
		scross.setColor(scan.nextLine());
		System.out.println("The Scross manufactured in:");
		cars.setYearOfMake(scan.nextInt());
		scan.nextLine();
		System.out.println("The type of Scross:");
		cars.setType(car.carType(scross));
		System.out.println("The Engine Number of the Scross:");
		cars.setEngineNumber(scan.nextLine());
		System.out.println("Details of Scross:\n Model: "+scross.getModel()+"\n Color: "+scross.getColor()+"\n No. of seats: "+scross.getSeats()+"\n No.of Airbags: "+scross.getAirbags()+"\n Manufactured Year: "+cars.getYearOfMake()+"\n Type: "+cars.getType()+"\nEngine Number: "+cars.getEngineNumber());
		break;
		case 3:
		System.out.println("No. of seats in XUV:");
		xuv.setSeats(scan.nextInt());
		scan.nextLine();
		System.out.println("No. of airbags in XUV:");
		xuv.setAirbags(scan.nextInt());
		scan.nextLine();
		System.out.println("Your preferred model for XUV:");
		xuv.setModel(scan.nextLine());
		System.out.println("Your preferred Color for XUV:");
		xuv.setColor(scan.nextLine());
		System.out.println("The XUV manufactured in:");
		cars.setYearOfMake(scan.nextInt());
		scan.nextLine();
		System.out.println("The type of XUV:");
		cars.setType(car.carType(xuv));
		System.out.println("The Engine Number of the XUV:");
		cars.setEngineNumber(scan.nextLine());
		System.out.println("Details of XUV:\n Model: "+xuv.getModel()+"\n Color: "+xuv.getColor()+"\n No. of seats: "+xuv.getSeats()+"\n No.of Airbags: "+xuv.getAirbags()+"\n Manufactured Year: "+cars.getYearOfMake()+"\n Type: "+cars.getType()+"\nEngine Number: "+cars.getEngineNumber());
		break;
		default:
		System.out.println("Enter a proper integer, either 1 or 2 or 3.");
		break;
		}
		System.out.println("___________________________________________");
		System.out.println("Still you want do the same thing again!\n If yes press 1");
		x=scan.nextInt();	
		scan.nextLine();	
	
	}while(x==1);}catch(InvalidInputException e){
			e.printStackTrace();
	}
	}
	private String carType(Car car){
		if (car instanceof Swift){
			return ("Hatch type");}
		else if (car instanceof XUV){
			return ("SUV type");}
		else if (car instanceof Scross){
			return ("sedan type");}
		else{
			return ("NO PROPER INPUT HAS GIVEN");}
	}
	private void carObj(Swift car){
		System.out.println("car");}
		
	}