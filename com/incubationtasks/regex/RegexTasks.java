package com.incubationtasks.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import utilities.InvalidInputException;
import utilities.UtilityTasks;

public class RegexTasks {
		public boolean validMobileNumber(String number) throws InvalidInputException{
			UtilityTasks.checkNull(number);
			return Pattern.matches("^[^0-5]\\d{9}$", number); 
		}
		public boolean isAlphaNumString(String string)throws InvalidInputException{
			UtilityTasks.checkNull(string);
			return Pattern.matches("^[a-zA-Z0-9]+", string);
		}
		public boolean isStartWith(String inputString,String matchingString) throws InvalidInputException{
			UtilityTasks.checkNull(matchingString);
			UtilityTasks.checkNull(inputString);
			return Pattern.matches("^["+matchingString+"].+",inputString);
		}
		
		public boolean isEndWith(String inputString,String matchingString) throws InvalidInputException{
			UtilityTasks.checkNull(matchingString);
			UtilityTasks.checkNull(inputString);
			return Pattern.matches("^.+["+matchingString+"]$",inputString);
		}
		
		public boolean stringContains(String inputString,String matchingString) throws InvalidInputException{
			UtilityTasks.checkNull(matchingString);
			UtilityTasks.checkNull(inputString);
			return Pattern.matches("^.+["+matchingString+"].+$",inputString);
		}
		
		public boolean stringMatch(String inputString,String matchingString) throws InvalidInputException{
			UtilityTasks.checkNull(matchingString);
			UtilityTasks.checkNull(inputString);
			return Pattern.matches(matchingString,inputString);
		}
		
		public boolean stringMatchCaseInsensitive(String inputString,String matchingString) throws InvalidInputException{
			UtilityTasks.checkNull(matchingString);
			UtilityTasks.checkNull(inputString);
			return Pattern.compile(matchingString,Pattern.CASE_INSENSITIVE).matcher(inputString).matches(); 
		}
		
		public boolean validateEmail(String mailId) throws InvalidInputException{
			UtilityTasks.checkNull(mailId);
			return Pattern.matches("^.+[@].+[.].+$", mailId);
		}
		
		public boolean ofSize(ArrayList<String> arrayList) throws InvalidInputException{
			UtilityTasks.checkNull(arrayList);
			boolean result=true;
			for(String string:arrayList) {
				result=Pattern.matches("^\\w{1,6}$", string);
				if(result==false) {
					break;
				}
			}
			return result;
		}
		
		public Map<String,Integer> mapTheStrings(ArrayList<String> domainArrayList,ArrayList<String> coDomainArrayList) throws InvalidInputException{
			UtilityTasks.checkNull(domainArrayList);
			UtilityTasks.checkNull(coDomainArrayList);
			Map<String, Integer> resultMap=new HashMap<String, Integer>();
			int sizeOfDomainList=domainArrayList.size();
			int sizeOfCoDomainList=coDomainArrayList.size();
			for(int i=0;i<sizeOfCoDomainList;i++) {
				for(int j=0;j<sizeOfDomainList;j++) {
					if(coDomainArrayList.get(i).equals(domainArrayList.get(j))) {
					resultMap.put(coDomainArrayList.get(i), j);
					}
				}
			}
			return resultMap;
		}
		
		public ArrayList<String> getHTMLCodes(String htmlString) throws InvalidInputException{
			UtilityTasks.checkNull(htmlString);
			ArrayList<String> arrayList=new ArrayList<String>();
			
				Matcher matcher =  Pattern.compile("<[^>]+>").matcher(htmlString);
				while(matcher.find()) {
					arrayList.add(matcher.group());
				}
			
			return arrayList;
		}
		
		public boolean validPassWord(String string) throws InvalidInputException{
			UtilityTasks.checkNull(string);
			return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\p{Punct}).{8,}$", string);
		}
}
