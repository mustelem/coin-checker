package com.hasdemir.coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.lang.Math;

public class Coin {
    private enum Type {NICKEL, QUARTER}

    private final Type fType;
    private final int fYear;
    
    public Coin (Type type, int year) {
        fType = type;
        fYear = year;
    }

    public static List<Coin> reduce(List<Coin> l) {
    	List<Coin> reducedList = new ArrayList<Coin>();
    	
    	Iterator<Coin> it = l.iterator();
    	
    	while (it.hasNext()) {
    		Coin c = it.next();
    		if (c.fType.equals(Type.QUARTER)) {
    			reducedList.add(c);
    		}
    	}
    	
    	return reducedList;
    }
    
    public static boolean areQuartersEquivalent(List<Coin> aList, List<Coin> bList) {
    	
    	List<Coin> reducedAList = reduce(aList);
    	List<Coin> reducedBList = reduce(bList);

    	if (reducedAList.size() == reducedBList.size()) {
    		Iterator<Coin> aIt = reducedAList.iterator();
    		Iterator<Coin> bIt = reducedBList.iterator();
    		while (aIt.hasNext()) {
    			Coin a = aIt.next();
    			Coin b = bIt.next();
    			
    			if (a.fYear == b.fYear) {
    				continue;
    			} else {
    				return false;
    			}
    		}
    		
    		return true;
    	}

    	return false;
    }

    public static List<Coin> getBigArray(int size) {
    	List<Coin> list = new ArrayList<Coin>();
    	
    	for (int i = 0; i < size; i++) {
    		int flip = ((int) (Math.random() * 10)) % 2;
    		int year = 1900 + ((int) (Math.random() * 100));
    		Type newType = flip == 0 ? Type.NICKEL : Type.QUARTER;
    		list.add(new Coin(newType, year));
    	}
    	
		return list;    	
    }
    
    public static void main(String[] args) {
         System.out.println("Test 1, Expecting true: " + areQuartersEquivalent(
                 Arrays.asList(
                     new Coin(Type.NICKEL, 1970),
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1940),
                     new Coin(Type.QUARTER, 1900)),

                 Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.QUARTER, 1900))
                 ));

        System.out.println("Test 2, Expecting false: "  +areQuartersEquivalent(
                 Arrays.asList(
                     new Coin(Type.NICKEL, 1970),
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1940),
                     new Coin(Type.QUARTER, 1900)),

                 Arrays.asList(
                     new Coin(Type.QUARTER, 1900),
                     new Coin(Type.QUARTER, 1971))
                 ));

        System.out.println("Test 3, Expecting true: " +areQuartersEquivalent(
                 Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.QUARTER, 1900)),

                 Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.QUARTER, 1900),
                     new Coin(Type.NICKEL, 1940))
                 ));

        System.out.println("Test 4, Expecting true: " +areQuartersEquivalent(new ArrayList<Coin>(),
                Arrays.asList(
                     new Coin(Type.NICKEL, 1971),
                     new Coin(Type.NICKEL, 1900))));

        System.out.println("Test 5, Expecting false: " +areQuartersEquivalent(new ArrayList<Coin>(),
                Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1900))));

        System.out.println("Test 6, Expecting false: " +areQuartersEquivalent(
                Arrays.asList(new Coin(Type.QUARTER, 1971),
                        new Coin(Type.QUARTER, 1971)),
                Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1900))));
        
        System.out.println("Test 7, Expecting false: " + areQuartersEquivalent(
                Arrays.asList(
                    new Coin(Type.NICKEL, 1970),
                    new Coin(Type.QUARTER, 1971),
                    new Coin(Type.NICKEL, 1940),
                    new Coin(Type.QUARTER, 1971),
                    new Coin(Type.QUARTER, 1900)),

                Arrays.asList(
                    new Coin(Type.QUARTER, 1971),
                    new Coin(Type.QUARTER, 1900))
                ));

        int largeNum = 1000000;
        List<Coin> a1 = getBigArray(largeNum);
        List<Coin> a2 = getBigArray(largeNum);
        System.out.println("Test 8, Expecting false: " + areQuartersEquivalent(a1, a2));
        System.out.println("Test 9, Expecting true: " + areQuartersEquivalent(a1, a1));

    }
}
