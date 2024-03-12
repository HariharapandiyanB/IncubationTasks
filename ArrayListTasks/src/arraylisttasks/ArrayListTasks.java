package arraylisttasks;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import utilities.InvalidInputException;
import utilities.UtilityTasks;
public class ArrayListTasks{
	
	public <T> List<T> createList(){
		List<T> list= new ArrayList<>();
		return list;
	}
	public <T> List<T> addElement(List<T> list, T obj) throws InvalidInputException{
		UtilityTasks.checkNull(list);
		list.add(obj);
		return list;
	}
	
	public <T> int sizeOfList(List<T> list) throws InvalidInputException {
		UtilityTasks.checkNull(list);
		return list.size();
	}
	
	public <T> int positionOfElement(List<T> list,T obj) throws InvalidInputException{
		UtilityTasks.checkNull(list);
		return list.indexOf(obj);
	}
	
	
	public <T> Iterator<T> createIterate(List<T> list)throws InvalidInputException{
		UtilityTasks.checkNull(list);
		Iterator<T> iterate =list.iterator();
		return iterate;
	}

	public <T> void iteratePrint(List<T> list, Iterator<T> iterate)throws InvalidInputException {
		
		int length=sizeOfList(list);
		for (int i=0; i<length;i++) {
			System.out.println(iterate.next());
		}
	}
	public <T> T elementAt(List<T> list, int num) throws InvalidInputException{
		
		int length=sizeOfList(list);
		UtilityTasks.checkInteger(length, num);
			return list.get(num);
	}
	
	public <T> int lastPositionOfElement(List<T> list,T obj) throws InvalidInputException{
		
		UtilityTasks.checkNull(list);
		return list.lastIndexOf(obj);
	}
	public <T> List<T> addInBetween(List<T> list,T obj,int num) throws InvalidInputException {
		
		int length=sizeOfList(list);
		UtilityTasks.checkInteger(length, num);
		list.set(num, obj);
		return list;
	}
	
	public <T> List<T> modifiedList(List<T> list,int num,int num1) throws InvalidInputException{
		
		int length=sizeOfList(list);
		UtilityTasks.checkInteger(length, num);
		UtilityTasks.checkInteger(length, num1);
		UtilityTasks.checkIntegers(num, num1);
		return list.subList(num, num1);}
		
	
	public <T> List <T> derivedList(List<T> baseList,List<T> addedList) throws InvalidInputException{
		UtilityTasks.checkNull(baseList);
		UtilityTasks.checkNull(addedList);
		baseList.addAll(addedList);
		return baseList;
	}
	
	public <T> List<T> removeElement(List<T> list,T obj) throws InvalidInputException{
		UtilityTasks.checkNull(list);
		list.remove(obj);
		return list;
	}

	public <T> List<T> removeElement(List<T> list,int num) throws InvalidInputException{
		
		int length=sizeOfList(list);
		UtilityTasks.checkInteger(length, num);
		list.remove(num);
		return list;
	}
	
	public <T> List<T> removeAllElements(List<T> baseList,List<T> removableList) throws InvalidInputException{
		UtilityTasks.checkNull(baseList);
		UtilityTasks.checkNull(removableList);
		baseList.removeAll(removableList);
		return baseList;
	}
	
	public <T> List<T> retainElementsIf(List<T> baseList,List<T> retainableList) throws InvalidInputException{
		UtilityTasks.checkNull(baseList);
		UtilityTasks.checkNull(retainableList);
		baseList.retainAll(retainableList);
		return baseList;
	}
	
	public <T> List<T> clearElements(List<T> list) throws InvalidInputException{
		UtilityTasks.checkNull(list);
		list.clear();
		return list;
	}
	
	public <T> boolean containsElement(List<T> list,T obj) throws InvalidInputException {
		UtilityTasks.checkNull(list);
		return list.contains(obj);
	}
	
}