package utilities;

public class UtilityTasks {
	public static void checkNull(Object obj) throws InvalidInputException{
		
		String reason="Null is passed as input";
		checkNull(obj,reason);
}
	public static void checkNull(Object obj,String reason) throws InvalidInputException{
	if (obj==null){
		throw new InvalidInputException(reason);
	}
}
	public static void checkInteger(int len,int num) throws InvalidInputException{
		if(num>len ){
			throw new InvalidInputException("Enter an integer less than the number of letters in the word");
		}else if(num<0){
			throw new InvalidInputException("Enter a positive integer");
		}}
	
	public static void checkIntegers(int num,int num1) throws InvalidInputException{
		if (num>num1) {
			throw new InvalidInputException("The 1st number is greater than 2nd number");
		}
	}


}
