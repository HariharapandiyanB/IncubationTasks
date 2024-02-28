package com.incubationtasks.regex;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.incubationtasks.threadrun.ThreadRun;
import utilities.InvalidInputException;

public class RegexRun {
	private static Scanner scan=new Scanner(System.in);
	private static RegexTasks regexTasks=new RegexTasks();
 	public static void main(String...args) {
 		Logger logger=Logger.getLogger(ThreadRun.class.getName());
		int x=1;
		do {
			try {
				System.out.println("Enter the number to choose the operation to be done(1-8):");
				int choice=scan.nextInt();
				scan.nextLine();
			switch(choice) {
				
				case 0:
					try {
					 logger.log(Level.INFO,"\n"+regexTasks.validPassWord("Hr#przh72a"));
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					 break;
				case 1:
					try {
						logger.log(Level.INFO,"Validation of the given mobile number");
						logger.log(Level.INFO,"\n The Mobile Number is: ");
						String number=scan.nextLine();
						logger.log(Level.INFO,"\n"+regexTasks.validMobileNumber(number));
					} catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+ e.getStackTrace());
					}break;
					
				case 2:
					try {
						logger.log(Level.INFO,"is the given string is AlphaNumeric");
						logger.log(Level.INFO,"\n The string is: ");
						String string=scan.nextLine();
						logger.log(Level.INFO,"\n"+regexTasks.isAlphaNumString(string));
					} catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+ e.getStackTrace());
					}break;
				
				case 3:
					try {
						logger.log(Level.INFO,"is the given string startwith(s)/ end with(e)/ contains(c)/match(m) with the matching String");
						String option=scan.nextLine();
						logger.log(Level.INFO,"\n The  string to be checked is: ");
						String inputString =scan.nextLine();
						logger.log(Level.INFO,"\n The string to be patterned is: ");
						String matchString =scan.nextLine();
						switch(option) {
						case "s":
							logger.log(Level.INFO,"\n"+regexTasks.isStartWith(inputString,matchString));
							break;
						case "e": 
							logger.log(Level.INFO,"\n"+regexTasks.isEndWith(inputString,matchString));
							break;
						case "c":
							logger.log(Level.INFO,"\n"+regexTasks.stringContains(inputString,matchString));
							break;
						case "m":
							logger.log(Level.INFO,"\n"+regexTasks.stringMatch(inputString,matchString));
							break;
						default:
							logger.log(Level.INFO,"Kindly enter the correct option...(s/e/c)");
						}
						
					}catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+ e.getStackTrace());
					}break;
					
				case 4:
					try {
						logger.log(Level.INFO,"\n Match the string irrespective of case");
						logger.log(Level.INFO,"\n The string to be checked is: ");
						String inputString =scan.nextLine();
						logger.log(Level.INFO,"\n The string to be matched is: ");
						String matchString =scan.nextLine();
						logger.log(Level.INFO,"\n"+regexTasks.stringMatchCaseInsensitive(inputString,matchString));
					}catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+ e.getStackTrace());
					}break;
					
				case 5:
					try {
						logger.log(Level.INFO,"\n Validation of email Id");
						logger.log(Level.INFO,"\n Enter the mail Id to validate:");
						String mailId=scan.nextLine();
						logger.log(Level.INFO,"\n"+regexTasks.validateEmail(mailId));
					}catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+e.getStackTrace());
					}
				
				case 6:
					 try {
						logger.log(Level.INFO,"\n check whether the string is within the range");
						ArrayList<String> arrayList=new ArrayList<String>();
						String option;
						do {
							logger.log(Level.INFO,"\n Enter the string to be checked:");
							arrayList.add(scan.nextLine()) ;
							logger.log(Level.INFO,"\n Press y to add one more String");
							option=scan.nextLine();
						}while(option.equals("y"));
						logger.log(Level.INFO,"\n"+regexTasks.ofSize(arrayList));
					}catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+e.getStackTrace());
					}break;
					
				case 7:
					try {
						logger.log(Level.INFO,"\n check whether the string is within the range");
						ArrayList<String> domainArrayList=new ArrayList<String>();
						String option;
						do {
							logger.log(Level.INFO,"\n Domain ArrayList \n Enter the string to be checked:");
							domainArrayList.add(scan.nextLine()) ;
							logger.log(Level.INFO,"\n Press y to add one more String");
							option=scan.nextLine();
						}while(option.equals("y"));
						ArrayList<String> coDomainArrayList=new ArrayList<String>();
						do {
							logger.log(Level.INFO,"\n CoDomain ArrayList \n Enter the string to be checked:");
							coDomainArrayList.add(scan.nextLine()) ;
							logger.log(Level.INFO,"\n Press y to add one more String");
							option=scan.nextLine();
						}while(option.equals("y"));
						logger.log(Level.INFO,"\n"+regexTasks.mapTheStrings(domainArrayList, coDomainArrayList));
					} catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+e.getStackTrace());
					}
					
				case 8:
					try {
						logger.log(Level.INFO,"Extract the codes from the html string");
						logger.log(Level.INFO,"\n The string is : ");
						String string=scan.nextLine();
						logger.log(Level.INFO,"\n"+regexTasks.getHTMLCodes(string));
					} catch (InvalidInputException e) {
						logger.log(Level.SEVERE,"\n"+ e.getStackTrace());
					}break;
				default:
					logger.log(Level.INFO,"Enter only the integers between 1-8");
			}
			logger.log(Level.INFO,"press 1 to continue operations...");
			x=scan.nextInt();scan.nextLine();
			}catch(InputMismatchException e) {
				logger.log(Level.SEVERE,"\n"+e.getStackTrace());
			}
		}while(x==1);
		scan.close();
 	}
}
