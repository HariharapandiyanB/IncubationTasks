package com.incubationtasks.hashmaprun;
import java.util.Scanner;

import java.util.Map;

import utilities.InvalidInputException;

import com.incubationtasks.customclass.CustomClass;
import com.incubationtasks.hashmaptasks.HashMapTasks;
public class HashMapRun {
	
	public static void main(String [] args) {
		Scanner scan =new Scanner(System.in);
		HashMapTasks hmt=new HashMapTasks();
		int x=0;
		do {
			System.out.println("Enter the operation ID to do:");
			int choice=scan.nextInt();
			scan.nextLine();
			switch(choice) {
			
			case 1:
				try {
				System.out.println("just create an empty map and find its size...");
				Map<String, Float> maps1=hmt.createHashMap();
				
				System.out.println(maps1);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps1));
				}catch(InvalidInputException e1) {
					e1.printStackTrace();
				}break;
			
			case 2:
				try {
				System.out.println("Add both key and values as strings");
				Map<String, String> maps2=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps2,key,value);
				}
				System.out.println(maps2);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps2));
				}catch(InvalidInputException e2) {
					e2.printStackTrace(); break;
				}
			
			case 3:
				try {
				System.out.println("Add both key and values as Integers");
				Map<Integer,Integer> maps3=hmt.createHashMap();
				
				System.out.println(maps3);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps3));
				}catch(InvalidInputException e3) {
					e3.printStackTrace();
				}
				break;
				
			case 4:
				try {
				System.out.println("Add key as String and values as Integers");
				Map<String, Integer> maps4=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				Integer value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextInt();
					hmt.addPair(maps4,key,value);
				}
				System.out.println(maps4);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps4));
				}catch(InvalidInputException e4) {
					e4.printStackTrace();
				}break;
				
			case 5:
				try {
				System.out.println("Add key as String and values as Custom Objects");
				Map<String, Object> maps5=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				Object value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					CustomClass obj=new CustomClass(" ");
				
					value=obj;
					hmt.addPair(maps5,key,value);
				}
				System.out.println(maps5);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps5));
				}catch(InvalidInputException e5) {
					e5.printStackTrace();
				}break;
				
			case 6:
				try {
				System.out.println("Add Key as String and Value as Null");
				Map<String,String> maps6=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key is either or Null or Anything");
					String choice1=scan.nextLine();
					if (choice1=="null") {
						key=null;
						}else {
							key=choice1;
						}
					System.out.println("The value either null or anything:");
					String choice2=scan.nextLine();
					if (choice2=="null") {
						value=null;
						}else {
							value=choice2;
						}
					
					hmt.addPair(maps6,key,value);
				}
				System.out.println(maps6);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps6));
				}catch(InvalidInputException e6) {
					e6.printStackTrace();
				}break;
				
			case 7:
				try {
				System.out.println("Add Key as NUll and Value as String");
				Map<String,String> maps7=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key is either or Null or Anything");
					String choice1=scan.nextLine();
					if (choice1=="null") {
						key=null;
						}else {
							key=choice1;
						}
					System.out.println("The value either null or anything:");
					String choice2=scan.nextLine();
					if (choice2=="null") {
						value=null;
						}else {
							value=choice2;
						}
					
					hmt.addPair(maps7,key,value);
				}
				System.out.println(maps7);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps7));
				}catch(InvalidInputException e7) {
					e7.printStackTrace();
				}break;
				
			case 8:
				try {
				System.out.println("To check the presence of a key");
				Map<String,String> maps8=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps8,key,value);
				}
				System.out.println("The key to be identified");
				String key8=scan.nextLine();
				System.out.println("Is the Specified element found in the HashMap "+ hmt.checkKey(maps8,key8));
				}catch(InvalidInputException e8) {
					e8.printStackTrace();
				}
				break;
				
			case 9:
				try {
				System.out.println("To check the presence of a Value");
				Map<String,String> maps9=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps9,key,value);
				}
				System.out.println("The value to be identified");
				String value9=scan.nextLine();
				System.out.println("Is the Specified element found in the HashMap "+ hmt.checkValue(maps9,value9));
				}catch(InvalidInputException e9) {
					e9.printStackTrace();
				}
				break;
				
			case 10:
				try {
				System.out.println("Modify the values in the HashMap");
				Map<String, String> maps10=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps10,key,value);
				}
				System.out.println(maps10);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps10));
				System.out.println("The number of values to be changed");
				int num10=scan.nextInt();
				scan.nextLine();
				for (int i=0;i<num10;i++) {
				System.out.println("The desired key position to be changed: ");
				String key10=scan.nextLine();
				System.out.println("The new value to be added: ");
				String newValue=scan.nextLine();
				hmt.replaceValue(maps10,key10,newValue);
				}
				System.out.println(maps10);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps10));
				}catch(InvalidInputException e10) {
					e10.printStackTrace();
				}
				break;
				
			case 11:
				try {
				System.out.println("To check the presence of a Value");
				Map<String,String> maps11=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps11,key,value);
				}
				System.out.println(maps11);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps11));
				System.out.println("The desired key position of the value to be identified: ");
				String key11=scan.nextLine();
				System.out.println("The value is: "+hmt.getValue(maps11,key11));
				}catch(InvalidInputException e11) {
					e11.printStackTrace();
				}
				break;
				
			case 12:
				try {
				System.out.println("To add an value for an ghost key");
				Map<String,String> maps12=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps12,key,value);
				}
				System.out.println(maps12);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps12));
				System.out.println("The ghosted key : ");
				String key12=scan.nextLine();
				
				hmt.getValue(maps12, key12);
				System.out.println("The modified HashMap: "+maps12);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps12));
				}catch(InvalidInputException e12) {
					e12.printStackTrace();
				}
				break;
				
			case 13:
				try {
				System.out.println("To add an value for an ghost key");
				Map<String,String> maps13=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps13,key,value);
				}
				System.out.println(maps13);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps13));
				System.out.println("The ghosted key : ");
				String key13=scan.nextLine();
				System.out.println("The value to be added is: ");
				String value13="ZOHO";
				System.out.println("The value of the given key is: "+hmt.nonExistingKey(maps13, key13, value13));
				System.out.println("The modified HashMap: "+maps13);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps13));
				}catch(InvalidInputException e13) {
					e13.printStackTrace();
				}
				break;
				
			case 14:
				try {
				System.out.println("To remove a key");
				Map<String,String> maps14=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps14,key,value);
				}
				System.out.println(maps14);
				System.out.println("The size of the HashMap before modification is: "+hmt.getSize(maps14));
				String key14;
				int y=1;
				do{
					System.out.println("The desired key of the value to be removed: ");
					key14=scan.nextLine();
				if (hmt.checkKey(maps14,key14)==false) {
					System.out.println("Enter the key which is present in the HashMap");
				}else {
					y++;
				}}while(y==1);
				System.out.println("The HashMap after removing the element is; "+hmt.removeKey(maps14,key14));
				System.out.println("The size of the HashMap after modification is: "+hmt.getSize(maps14));
				}catch(InvalidInputException e14) {
					e14.printStackTrace();
				}
				break;
				
			case 15:
				try {
				System.out.println("To remove a key and the specified value");
				Map<String,String> maps15=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps15,key,value);
				}
				System.out.println(maps15);
				System.out.println("The size of the HashMap before modification is: "+hmt.getSize(maps15));
				String key15;
				int z=1;
				do{
					System.out.println("The desired key of the value to be removed: ");
					key15=scan.nextLine();
				if (hmt.checkKey(maps15,key15)==false) {
					System.out.println("Enter the key which is present in the HashMap");
				}else {
					z++;
				}}while(z==1);
				System.out.println("Enter the value to be removed is: ");
				String value15=scan.nextLine();
				hmt.removePair(maps15, key15, value15);
				System.out.println("The HashMap after removing the element is; "+maps15);
				System.out.println("The size of the HashMap after modification is: "+hmt.getSize(maps15));
				}catch(InvalidInputException e15) {
					e15.printStackTrace();
				}
				break;
				
			case 16:
				try {
				System.out.println("To replace a key with the specified value");
				Map<String,String> maps16=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps16,key,value);
				}
				System.out.println(maps16);
				System.out.println("The size of the HashMap before modification is: "+hmt.getSize(maps16));
				System.out.println("The desired key of the value to be replaced: ");
				String key16=scan.nextLine();
				if (hmt.checkKey(maps16, key16)==true){
					System.out.println("Enter the value of the key to be replaced  is: ");
					String value16=scan.nextLine();
					hmt.replaceValue(maps16, key16, value16);
					System.out.println("The HashMap after removing the element is; "+maps16);
					System.out.println("The size of the HashMap after modification is: "+hmt.getSize(maps16));				
				}
				}catch(InvalidInputException e16) {
					e16.printStackTrace();
				}
				break;
				
			case 17:
				try {
				System.out.println("To replace a key with the specified value");
				Map<String,String> maps17=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps17,key,value);
				}
				System.out.println(maps17);
				System.out.println("The size of the HashMap before modification is: "+hmt.getSize(maps17));
				System.out.println("The desired key of the value to be replaced: ");
				String key17=scan.nextLine();
				if (hmt.checkKey(maps17, key17)==true){
					System.out.println("Enter the  old value of the key is: ");
					String oldValue=scan.nextLine();
					System.out.println("Enter the  new value of the key to be replaced  is: ");
					String newValue=scan.nextLine();
					hmt.replacePair(maps17, key17, oldValue, newValue);
					System.out.println("The HashMap after removing the element is; "+maps17);
					System.out.println("The size of the HashMap after modification is: "+hmt.getSize(maps17));				
				}
				}catch(InvalidInputException e17) {
					e17.printStackTrace();
				}
				break;
				
			case 18:
				try {
				System.out.println("To add all the elements of a HashMap to a new HashMap");
				Map<String,String> maps18=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps18,key,value);
				}
				System.out.println(maps18);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps18));
				
				Map<String,String> maps18_1=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap18_1=scan.nextInt();
				scan.nextLine();
				
				String key18_1;
				String value18_1;
				for (int i=0;i<lengthOfMap18_1;i++) {
					System.out.println("The key"+i);
					key18_1=scan.nextLine();
					System.out.println("The value:"+i);
					value18_1=scan.nextLine();
					hmt.addPair(maps18_1,key18_1,value18_1);
				}
				System.out.println(maps18_1);
				System.out.println("The size of the HashMap before modification is: "+hmt.getSize(maps18_1));
				maps18_1=hmt.addEveryElements(maps18_1, maps18);
				System.out.println(maps18_1);
				System.out.println("The size of the HashMap after modification is: "+hmt.getSize(maps18_1));
				}catch(InvalidInputException e18) {
					e18.printStackTrace();
				}
				
				break;
				
			case 19:
				try {
				System.out.println("To print all the pairs in the HashMap");
				Map<String,String> maps19=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps19,key,value);
				}
				System.out.println(maps19);
				int sizeOfMap=hmt.getSize(maps19);
				System.out.println("The size of the HashMap is: "+sizeOfMap);
				hmt.sequencePrint(maps19);
				}catch(InvalidInputException e19) {
					e19.printStackTrace();
				}
				
				break;
				
			case 20:
				try {
				System.out.println("To remove all the elements of a HashMap");
				Map<String,String> maps20=hmt.createHashMap();
				System.out.println("The number of pairs in the maps");
				int lengthOfMap=scan.nextInt();
				scan.nextLine();
				
				String key;
				String value;
				for (int i=0;i<lengthOfMap;i++) {
					System.out.println("The key"+i);
					key=scan.nextLine();
					System.out.println("The value:"+i);
					value=scan.nextLine();
					hmt.addPair(maps20,key,value);
				}
				System.out.println("Before modification: "+maps20);
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps20));
				System.out.println("After modification: "+hmt.clearAllPairs(maps20));
				System.out.println("The size of the HashMap is: "+hmt.getSize(maps20));
				}catch(InvalidInputException e20) {
					e20.printStackTrace();
				}
				break;

				
			default:
				System.out.println("Enter the number within the given limits");
				
			}
			System.out.println("Press 1 to continue the operations...");
			x=scan.nextInt();
			scan.nextLine();
		}while (x==1);
		scan.close();
	}
	

	}
	

