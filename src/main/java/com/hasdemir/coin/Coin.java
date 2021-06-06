package com.hasdemir.coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Coin {
    private enum Type {NICKEL, QUARTER}

    private final Type fType;
    private final int fYear;

    public Coin (Type type, int year) {
        fType = type;
        fYear = year;
    }

    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	
    	if (o == null) {
    		return false;
    	}
    	
    	if (!this.getClass().equals(o.getClass())) {
    		return false;
    	}
    	Coin temp = (Coin) o;
    	if (this.fType.equals(temp.fType) && this.fYear == temp.fYear) {
    		return true;
    	}
    	
    	return false;
    }
    
    public int hashCode() {
    	return this.fType.ordinal() * this.fYear;
    }
    
    public static boolean areQuartersEquivalent(List<Coin> aList, List<Coin> bList) {
    	HashSet<Coin> a = new HashSet<Coin>();    	
    	HashSet<Coin> b = new HashSet<Coin>();
    	
    	Iterator<Coin> it = aList.iterator();
    	
    	while (it.hasNext()) {
    		Coin temp = it.next();
    		if (temp.fType.equals(Type.QUARTER)) {
        		a.add(temp);    			
    		}
    	}

    	it = bList.iterator();
    	while (it.hasNext()) {
    		Coin temp = it.next();
    		if (temp.fType.equals(Type.QUARTER)) {
        		b.add(temp);    			
    		}
    	}
    	
    	return a.equals(b);
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

        System.out.println("Test 4, Expecting false: " +areQuartersEquivalent(new ArrayList<Coin>(),
                Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1900))));

        System.out.println("Test 4, Expecting false: " +areQuartersEquivalent(
                Arrays.asList(new Coin(Type.QUARTER, 1971),
                        new Coin(Type.QUARTER, 1971)),
                Arrays.asList(
                     new Coin(Type.QUARTER, 1971),
                     new Coin(Type.NICKEL, 1900))));
    }
}
