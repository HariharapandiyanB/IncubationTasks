package stringrun;
import utilities.InvalidInputException;
import utilities.UtilityStringTasks;
public class StringRun{

public int length(String str) throws InvalidInputException{
	return  UtilityStringTasks.length(str);
}


public char[] toArray(String str) throws InvalidInputException{
 UtilityStringTasks.checkNull(str);
return str.toCharArray();
}

public char penultimate(String str) throws InvalidInputException{
int len= UtilityStringTasks.length(str);
return  UtilityStringTasks.getCharAt(str,len-2);
}





public int occurences(String str,char character) throws InvalidInputException{

int occurences=0;
int j= UtilityStringTasks.length(str);
for(int i=0;i<j;i++){
	
	if (character==str.charAt(i)){
		occurences++;	}
	   }
	return occurences;
}

public int greatestPosition(String str,char character) throws InvalidInputException{
 UtilityStringTasks.checkNull(str);
return str.lastIndexOf(character);
}

public String lastChars(String str,int num) throws InvalidInputException {
	
	int len= UtilityStringTasks.length(str);
	return  UtilityStringTasks.substring(str,len-num,len);
 }

public String firstChars(String str,int num) throws InvalidInputException{
	return  UtilityStringTasks.substring(str,0,num);
	}
	

	

public String replaceString(String str,String str2) throws InvalidInputException{
	
	String str1= UtilityStringTasks.substring(str,0,length(str2));
	return str.replaceFirst(str1,str2);
	 }

public boolean startWith(String str,String str1) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	 UtilityStringTasks.checkNull(str1);
	return str.startsWith(str1);
	}

public boolean endWith(String str,String str1) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	 UtilityStringTasks.checkNull(str1);
	return str.endsWith(str1);
	}

public String toUpper(String str) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	return str.toUpperCase();
	}

public String toLower(String str) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	return str.toLowerCase();
	}

public String reverse(String str) throws InvalidInputException{
	
	String str1="";
	int x= UtilityStringTasks.length(str);
	int j=x;
		for(int i=0;i<x;i++){
			char y=str.charAt(j-1);
			 str1+=y;
			j--;
			}
	
	return str1;
	}

public String multipleStrings(String[] str,String deli1) throws InvalidInputException{
	
	 UtilityStringTasks.checkNull(str);
	 UtilityStringTasks.checkNull(deli1,"The delimiter required for the given operation is not given! ");
	return String.join(deli1,str);
	}

public String concat(String str,String deli1,String deli2) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	return str.replaceAll(deli1,deli2);
	}


public String[] stringArray(String str,String ch1) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	return str.split(ch1);
	}

public String inBetween(String[] str1,String ch) throws InvalidInputException{

	 UtilityStringTasks.checkNull(str1);
	 return str1[0].join(ch,str1);}
public boolean caseSensitive(String str,String str1) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	
	return str.equals(str1); 
	}
public boolean caseInSensitive(String str,String str1) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	
	return str.equalsIgnoreCase(str1);
	}

public String trim(String str) throws InvalidInputException{
	 UtilityStringTasks.checkNull(str);
	return str.trim();
	}

}