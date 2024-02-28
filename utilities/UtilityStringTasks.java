package utilities;
public class UtilityStringTasks{
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

public static int length(String args) throws InvalidInputException{
checkNull(args);
return args.length();
}

public static char getCharAt(String str,int num) throws InvalidInputException {
int len=length(str);
checkInteger(len,num);
return str.charAt(num);
}
public static String substring(String str,int num1,int num2) throws InvalidInputException{
	int len=length(str);
	checkInteger(len,num1);
	checkInteger(len,num2);
	return str.substring(num1,num2);
}
public static void checkIntegers(int num,int num1) throws InvalidInputException{
		if (num>num1) {
			throw new InvalidInputException("The 1st number is greater than 2nd number");
		}
	}
}