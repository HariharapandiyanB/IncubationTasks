package arraylisttasks;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

import java.util.InputMismatchException;
import utilities.InvalidInputException;
import utilities.UtilityTasks;
public class ArrayListRun {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayListTasks arr=new ArrayListTasks();
		
		int x=0;
		do {
			
		System.out.println("Enter the operation ID to do:");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice) {
		
		case 1:
			try{
				ArrayList<String> arrList= new ArrayList<>();
				System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements1=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements1,scan);
			System.out.println("The formed list is:"+arrList);
			arr.sizeOfList(arrList);
			}catch(InvalidInputException e1) {
				e1.printStackTrace();
			}
			break;
		
		case 2:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of Strings in the arraylist:");
			int numOfElements2=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements2,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The Size of the list is:"+arr.sizeOfList(arrList));
			}catch(InvalidInputException e2) {
				e2.printStackTrace();
			}break;
		
		case 3:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of Integer in the arraylist:");
			int numOfElements3=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements3,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The Size of the list is:"+arr.sizeOfList(arrList));
			}catch(InvalidInputException e3) {
				e3.printStackTrace();
			}break;
			
		case 4:
			try {
				ArrayList<Object> arrList= new ArrayList<>();
				System.out.println("The number of objects to be added in the list: ");
				int num4=scan.nextInt();
				scan.nextLine();
				 
				createCustomArrayList(arrList,num4,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The Size of the list is:"+arr.sizeOfList(arrList));
			}catch(InvalidInputException e4) {
				e4.printStackTrace();
			} break;
			
		case 5:
			try {
				ArrayList<Object> arrList= new ArrayList<>();
			System.out.println("Enter the number of Strings in the arraylist:");
			int numOfElements5=scan.nextInt();
			scan.nextLine();
			createMixedArrayList(arrList,numOfElements5,scan);
			System.out.println("The formed list is:"+arrList);
			 
			System.out.println("The number of objects to be added in the list: ");
			int num5_1=scan.nextInt();
			scan.nextLine();
			createCustomArrayList(arrList,num5_1,scan);
			System.out.println("The formed list is:"+arrList);
			
			} catch(InvalidInputException e5) {
				e5.printStackTrace();
			}break;
			
		case 6:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements6=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements6,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The element to be identified:");
			String str6=scan.next();
			System.out.println("The element's position is:  "+arr.positionOfElement(arrList,str6));
			System.out.println(arr.sizeOfList(arrList));
			}catch(InvalidInputException e6) {
				e6.printStackTrace();
			}break;
			
		case 7:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements7=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements7,scan);
			System.out.println("The formed list is:"+arrList);
			Iterator<String> iterate=arr.createIterate(arrList);
			arr.iteratePrint(arrList,iterate);
			}catch(InvalidInputException e7) {
				e7.printStackTrace();
			}break;
			
		case 8:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements8=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements8,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The position in the list: ");
			int	position8=scan.nextInt();
			scan.nextLine();
			System.out.println("The element at the desired position is: "+arr.elementAt(arrList, position8));
			}catch(InvalidInputException e8) {
				e8.printStackTrace();
			} 
			break;
			
		case 9:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements9=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements9,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("The duplicate element is : ");
			String str9=scan.nextLine();
			System.out.println("The 1st occurence of the duplicate: "+arr.positionOfElement(arrList, str9));
			System.out.println("The last occurence of the duplicate: "+arr.lastPositionOfElement(arrList, str9));
			}catch(InvalidInputException e9) {
				e9.printStackTrace();
			}break;
		
			
		case 10:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements10=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements10,scan);
			System.out.println("The formed list is:"+arrList);
			System.out.println("Enter the element to be added ");
			String str10=scan.nextLine();
			System.out.println("The position to be added: ");
			int num10=scan.nextInt();
			scan.nextLine();
			arr.addInBetween(arrList,str10,num10);
			}catch(InvalidInputException e10) {
				e10.printStackTrace();
			} break;
		
		case 11:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist:");
			int	numOfElements11=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements11,scan);
			System.out.println("The formed list is:"+arrList);
			ArrayList<String> arrList1= new ArrayList<>();
			
			System.out.println("Enter the First position and Last position from the 1st Arraylist: ");
			int num11=scan.nextInt();
			int num11_1=scan.nextInt();
			scan.nextLine();
			arrList1=(ArrayList<String>)arr.modifiedList(arrList,num11,num11_1);
			System.out.println("The new arraylist is "+arrList1);
			}catch(InvalidInputException e11) {
				e11.printStackTrace();
			}break;
			
		case 12:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements12=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements12,scan);
			System.out.println("The formed list is:"+arrList);
			ArrayList<String> arrList1= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 2:");
			int	numOfElements12_1=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList1,numOfElements12_1,scan);
			System.out.println("The formed list is:"+arrList1);
			ArrayList<String> arrList2= new ArrayList<>();
			arr.derivedList(arrList,arrList2);
			arr.derivedList(arrList1,arrList2);
			System.out.println(arrList2);
			}catch(InvalidInputException e12) {
				e12.printStackTrace();
			}break;
			
		case 13:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements13=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements13,scan);
			System.out.println("The formed list is:"+arrList);
			ArrayList<String> arrList1= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 2:");
			int	numOfElements13_1=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements13_1,scan);
			System.out.println("The formed list is:"+arrList1);
			ArrayList<String> arrList2= new ArrayList<>();
			arr.derivedList(arrList1,arrList2);
			arr.derivedList(arrList,arrList2);
			System.out.println(arrList2);
			}catch(InvalidInputException e13) {
				e13.printStackTrace();
			}break;
			
		case 14:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements14=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements14,scan);
			System.out.println("The formed list is:"+arrList);
		
			System.out.println("The size of the list is: "+arr.sizeOfList(arrList));
			System.out.println("The element to be removed in the list is: ");
			String str14=scan.nextLine();
			arr.removeElement(arrList,str14);
			System.out.println("The modified list is : "+arrList);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList));
			}catch(InvalidInputException e14) {
				e14.printStackTrace();
			}break;
			
		case 15:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements15=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements15,scan);
			System.out.println("The formed list is:"+arrList);
			
			System.out.println("The size of the list is: "+arr.sizeOfList(arrList));
			System.out.println("The position of the element to be removed in the list is: ");
			int num15=scan.nextInt();
			scan.nextLine();
			arr.removeElement(arrList,num15);
			System.out.println("The modified list is : "+arrList);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList));
			}catch(InvalidInputException e15) {
				e15.printStackTrace();
			}break;
		
		case 16:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements16=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements16,scan);
			System.out.println("The formed list is:"+arrList);
			ArrayList<String> arrList1= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 2:");
			int	numOfElements16_1=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList1,numOfElements16_1,scan);
			System.out.println("The formed list is:"+arrList1);

			arr.removeAllElements(arrList,arrList1);
			System.out.println("The new list is :"+arrList1);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList1));
			}catch(InvalidInputException e16) {
				e16.printStackTrace();
			}break;
		
		case 17:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 1:");
			int	numOfElements17=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements17,scan);
			System.out.println("The formed list is:"+arrList);
			ArrayList<String> arrList1= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist 2:");
			int	numOfElements17_1=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList1,numOfElements17_1,scan);
			System.out.println("The formed list is:"+arrList1);
			
			arr.retainElementsIf(arrList,arrList1);
			System.out.println("The new list is :"+arrList1);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList1));
			}catch(InvalidInputException e17) {
				e17.printStackTrace();
			}break;
			
		case 18:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist: ");
			int	numOfElements18=scan.nextInt();
			scan.nextLine();
			createArrayList(arrList,numOfElements18,scan);
			System.out.println("The formed list is:"+arrList);
			
			arr.clearElements((ArrayList<String>)arrList);
			System.out.println("The new list is :"+arrList);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList));
			}catch(InvalidInputException e18) {
				e18.printStackTrace();
			}break;
		case 19:
			try {
				ArrayList<String> arrList= new ArrayList<>();
			System.out.println("Enter the number of elements in the arraylist: ");
			int	numOfElements19=scan.nextInt();
			scan.nextLine();
			
			createArrayList(arrList,numOfElements19,scan);
			System.out.println("The formed list is:"+arrList);
			
			System.out.println("Enter the element to be checked:");
			String str19=scan.nextLine();
			arr.containsElement(arrList,str19);
			System.out.println("The new list is :"+arrList);
			System.out.println("The size of the new list is: "+ arr.sizeOfList(arrList));
			}catch(InvalidInputException e19) {
				e19.printStackTrace();
			}break;
		default:
			try {
			System.out.println("Enter the number between 1-19");
			}catch(InputMismatchException i1) {
				i1.printStackTrace();
			}
		}try{
			System.out.println("press 1 to continue..");
		
		x=scan.nextInt();
		scan.nextLine();
		}catch(InputMismatchException i2) {
			i2.printStackTrace();
		}
		}while(x==1);
}
	
	public static ArrayList<String> createArrayList(ArrayList<String> arrayList,int num,Scanner scan) throws InvalidInputException{
		UtilityTasks.checkNull(arrayList);
		ArrayListTasks arr=new ArrayListTasks();
		for (int i=0;i<num;i++) {
			arr.addElement(arrayList,scan.next());
		}
		return arrayList;
		
	}
	public static ArrayList<Integer> createIntArrayList(ArrayList<Integer> arrayList,int num,Scanner scan) throws InvalidInputException{
		UtilityTasks.checkNull(arrayList);
		ArrayListTasks arr=new ArrayListTasks();
		int numValue;
		for (int i=0;i<num;i++) {
			numValue=scan.nextInt();
			scan.nextLine();
			arr.addElement(arrayList,numValue);
		}
		return arrayList;
		
	}
	public static ArrayList<Object> createCustomArrayList(ArrayList<Object> arrayList,int num,Scanner scan) throws InvalidInputException{
		UtilityTasks.checkNull(arrayList);
		ArrayListTasks arr=new ArrayListTasks();
		for (int i=0;i<num;i++) {
			CustomClass customObj=new CustomClass(scan.nextLine());
			arr.addElement(arrayList,customObj);
		}
		return arrayList;
		
	}	
	public static ArrayList<Object> createMixedArrayList(ArrayList<Object> arrayList,int num,Scanner scan) throws InvalidInputException{
		UtilityTasks.checkNull(arrayList);
		ArrayListTasks arr=new ArrayListTasks();
		for (int i=0;i<num;i++) {
			
			arr.addElement(arrayList,scan.nextLine());
		}
		return arrayList;
		
	}	
	
	
}