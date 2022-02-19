package zad3;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class XList<T> extends ArrayList<T> {

	
	
	private  int sizeOfXList = 0;
	private static final int DEFAULT_CAPACITY_XLIST = 10;
	private  Object elementsXList[];
	
	public XList() {
		elementsXList = new Object[DEFAULT_CAPACITY_XLIST];
	}
	
	public XList(Integer... whatever){
		elementsXList = new Object[whatever.length];
		sizeOfXList = elementsXList.length;
		for (int i=0;i<whatever.length;i++) {
			elementsXList[i] = whatever[i] ;
		}
	}
	
	
	public XList(Set<Integer> setIn) {
		elementsXList = new Object[setIn.size()];
		sizeOfXList = elementsXList.length;
		Object[] setArray = setIn.toArray();
		for (int i=0;i<setArray.length;i++) 
			elementsXList[i] = setArray[i];
		
	}

	
	
	private void remakeXList() {
		int extendedSize = (elementsXList.length*2);
		elementsXList = Arrays.copyOf(elementsXList, extendedSize);
	}

	
	public boolean add(T t) {
		if(sizeOfXList == elementsXList.length)
			remakeXList();
		elementsXList[sizeOfXList++] = t;
		return false;
	}
	
	public T get(int i) {
		if (i >= sizeOfXList || i < 0 )
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		return (T) elementsXList[i];
	}

	public T remove(int i) {
		if (i >= sizeOfXList || i < 0 )
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		Object removing = elementsXList[i];
		int numRemovedList = elementsXList.length-(i+1);
		System.arraycopy(elementsXList,i+1,elementsXList,i, numRemovedList);
		sizeOfXList--;
		return (T) removing;
		
	}

	public int sizeOfXList() {
		return sizeOfXList;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<sizeOfXList;i++) {
			sb.append(elementsXList[i].toString());
			if(i<sizeOfXList-1)
			sb.append(", ");
		}
			String exit = sb.toString();
		return "["+exit+"]";
		
		
	}
		// Static
	
	public static XList<Integer> of(Set<Integer> setIn) {
		XList<Integer> returning = new XList<Integer>();
		
		returning.elementsXList = new Object[setIn.size()];
		returning.sizeOfXList = returning.elementsXList.length;
		Object[] setArray = setIn.toArray();
		for (int i=0;i<setArray.length;i++) 
			returning.elementsXList[i] = setArray[i];
		return returning;
	}

	public static XList<Integer> of(Integer... ints) {
		XList<Integer> returning = new XList<Integer>();
		returning.elementsXList = new Object[ints.length];
		returning.sizeOfXList = returning.elementsXList.length;
		for (int i=0;i<ints.length;i++) 
			returning.elementsXList[i] = ints[i] ;
		return returning;	
	}
	
	public static XList<String> charsOf(String stringIn) {
		char[] inArrat = stringIn.toCharArray();
		XList<String> returning = new XList<String>();
		
		returning.elementsXList = new Object[inArrat.length];
		returning.sizeOfXList = returning.elementsXList.length;
		for (int i=0;i<inArrat.length;i++) 
			returning.elementsXList[i] = inArrat[i];
		return returning;
	}

	public static XList<String> tokensOf(String stringIn) {
		StringTokenizer myTokenizer = new StringTokenizer(stringIn);
		XList<String> returning = new XList<String>();
		int counter = myTokenizer.countTokens();
		returning.elementsXList = new Object[counter];
		returning.sizeOfXList = returning.elementsXList.length;
		for (int i = 1;myTokenizer.hasMoreTokens();i++)
			returning.elementsXList[i-1] = myTokenizer.nextElement();
		return returning;
	}

	public static XList<String> tokensOf(String stringIn, String stringIn2) {
		StringTokenizer myTokenizer = new StringTokenizer(stringIn,stringIn2);
		XList<String> returning = new XList<String>();
		int counter = myTokenizer.countTokens();
		returning.elementsXList = new Object[counter];
		returning.sizeOfXList = returning.elementsXList.length;
		for (int i = 1;myTokenizer.hasMoreTokens();i++)
			returning.elementsXList[i-1] = myTokenizer.nextElement();
		return returning;
	}

	public static XList<XList<String>> of(Collection<String>... whatever) {
		XList<XList<String>> returning = new XList<XList<String>>();
		returning.elementsXList = new Object[whatever.length];
		returning.sizeOfXList = returning.elementsXList.length;
		for (int i=0;i<whatever.length;i++) 
			returning.elementsXList[i] = whatever[i] ;
		
		return returning;
	}
	

	public XList<T> combine() {		
		XList<T> returning = new XList<>();		
		int stringArraySize = this.sizeOfXList();
		String[] arrayString = new String[stringArraySize];
		for (int i = 0; i <sizeOfXList; i++)
			arrayString[i]= this.get(i).toString();
		//for (int i = 0; i <arrayString.length; i++)
		//	System.out.println(arrayString[i]);
		T combination;		
		for (int i = 1; i <arrayString[arrayString.length-1].length() ; i= i+3) {
			for (int j = 1; j < arrayString[arrayString.length-2].length(); j=j+3) {
				for (int k = 1; k < arrayString[arrayString.length-3].length(); k=k+3) {
				
					char a = arrayString[arrayString.length-3].charAt(k);
					char b = arrayString[arrayString.length-2].charAt(j);
					char c = arrayString[arrayString.length-1].charAt(i);
				combination = (T) Arrays.asList( Character.toString(a), Character.toString(b), Character.toString(c));
				
				returning.add(combination);
			}}}
		return returning;
	}
	
	public <R> XList<R> collect(Function<T, R> f) {
		XList<R> returnList = new XList<R>();
		String combination;
		for (R r : returnList) {
			combination = (String) f.apply((T) r);
			returnList.add((R) combination);	
		}
		return returnList;
	}

	public String join() {
		int stringArraySize = this.sizeOfXList();
		String[] arrayString = new String[stringArraySize];
		for (int i = 0; i <sizeOfXList; i++)
			arrayString[i]= this.get(i).toString();
		
		String combination= arrayString[0];
		for (int i = 1; i <arrayString.length; i++)
			combination = combination+arrayString[1];
				return combination;
	}

	public String join(String sep) {
		int stringArraySize = this.sizeOfXList();
		String[] arrayString = new String[stringArraySize];
		for (int i = 0; i <sizeOfXList; i++)
			arrayString[i]= this.get(i).toString();
		
		String combination= arrayString[0]+ sep;
		for (int i = 1; i <arrayString.length; i++)
			combination = combination+arrayString[1]+sep;
				return combination;
	}
	
	
	
	
	

	public XList<T> union(Collection<T>list2) {
		
		XList<T> returning = new XList<T>();
		for(int i = 0; i<this.sizeOfXList();i++)
			returning.add(this.get(i));
		for(int i = 0; i<((XList<T>) list2).sizeOfXList();i++)
		returning.add(((XList<T>) list2).get(i));
		return returning;
	}


	public XList<T> union(T... whatever) {
		
		XList<T> returning = new XList<T>();
		for(int i = 0; i<this.sizeOfXList();i++)
			returning.add(this.get(i));
		for(int i = 0; i<whatever.length;i++)
		returning.add(whatever[i]);
		return returning;
	}
	

public XList<T> union(Set<T> whatever) {
	 XList<T> listToAdd = new XList(whatever);
	 
	 XList<T> returning = new XList<T>();
		for(int i = 0; i<this.sizeOfXList();i++)
			returning.add(this.get(i));
		for(int i = 0; i<((XList<T>) listToAdd).sizeOfXList();i++)
		returning.add(((XList<T>) listToAdd).get(i));
		return returning;
	}

public XList<T> diff(Set<T> whatever) {
	 XList<T> listToAdd = new XList(whatever);
	 
	 XList<T> returning = new XList<T>();
	 int testing = 0;
		for(int i = 0; i<this.sizeOfXList();i++) {
			for (int j = 0; j<listToAdd.sizeOfXList();j++) {
				if (this.get(i) == listToAdd.get(j))
						testing++;
			}
		if (testing == 0)
			returning.add(this.get(i));
		else
			testing = 0;	
	}
		return returning;
}

public XList<T> diff(Collection<T>  whatever) {
	 
	 XList<T> returning = new XList<T>();
	 int testing = 0;
		for(int i = 0; i<this.sizeOfXList();i++) {
			for (int j = 0; j<((XList<Integer>) whatever).sizeOfXList();j++) {
				if (this.get(i) == ((ArrayList<T>) whatever).get(j))
						testing++;
			}
		if (testing == 0)
			returning.add(this.get(i));
		else
			testing = 0;	
	}
		return returning;
}

public XList<T> unique() {
	 XList<T> returningOne = this;
		for(int i = 0; i<this.sizeOfXList();i++) {
			for (int j = i+1; j<this.sizeOfXList();j++)
				if (this.get(i)==this.get(j)) {
					returningOne.remove(j);
				}			
	}			
		XList<T> returningExit = returningOne;
		
		for(int i = 0; i<returningOne.sizeOfXList();i++) {
			for (int j = i+1; j<returningOne.sizeOfXList();j++)
				if (this.get(i)==returningOne.get(j)) {
					returningExit.remove(j);
				}
				
	}	
		return returningExit;	
		
	}





}		
			
			
			




