package de.hgy.physik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teplov {

	public static void main(String[] args) {
		initMap();
		calc();
	}
	
	static Map<Integer, String> map = new HashMap(); 
	static Map<Integer, String> mapSign = new HashMap(); 
	static void initMap() {
		map.put(1, "28.815");
		map.put(2, "105.456");
		map.put(3, "385.95");
		map.put(4, "1412.5");
		map.put(5, "5169.4");
		map.put(6, "18919.0");
		map.put(7, "69239.0");
		//---------------------------
		map.put( 0, "7.87");
		map.put(-1, "2.151");
		map.put(-2, "0.588");
		map.put(-3, "0.161");
		map.put(-4, "0.0439");
		map.put(-5, "0.0120");
		map.put(-6, "0.00328");
		map.put(-7, "0.000895");
		map.put(-8, "0.000264");
	
	// 28.815	105.456	385.95	1412.5	5169.4	18919	69239
	/*
	 	1 D		2 U		3 D’	4 U’	5 D’’	6 U’’	7 D’’’
		down	up		strange	charm	bottom	top	b'
		28.815	105.456	385.95	1412.5	5169.4	18919	69239

		-8			-7			-6		-5		-4		-3		-2		-1		0
		u'''''		d''''		u''''	d'''	u'''	d''		u''		d'		u'
		0.000264	0.000895	0.00328	0.0120	0.0439	0.161	0.588	2.151	7.87
	 */
		mapSign.put(1, "D");
		mapSign.put(2, "U");
		mapSign.put(3, "D'");
		mapSign.put(4, "U'");
		mapSign.put(5, "D''");
		mapSign.put(6, "U''");
		mapSign.put(7, "D'''");
		//---------------------------
		mapSign.put( 0, "u'");
		mapSign.put(-1, "d'");
		mapSign.put(-2, "u''");
		mapSign.put(-3, "d''");
		mapSign.put(-4, "u'''");
		mapSign.put(-5, "d'''");
		mapSign.put(-6, "u''''");
		mapSign.put(-7, "d''''");
		mapSign.put(-8, "u'''''");

	}
	
	static void calc() {
		
		double massSum = 0.0d;
		String massComposes = "";
		String quarkComposes = "";
		
		Scanner scanInput = new Scanner(System.in);

		System.out.println("" 
				+ " 1/D/" + map.get(1)
				+ " 2/U/" + map.get(2)
				+ " 3/D’/" + map.get(3)
				+ " 4/U’/" + map.get(4)
				+ " 5/D’’/" + map.get(5)
				+ " 6/U’’/" + map.get(6)
				+ " 7/D’’’/" + map.get(7) );
		System.out.println(""
				+ " -8/u'''''/" + map.get(-8) 
				+ " -7/d''''/" + map.get(-7) 
				+ " -6/u''''/" + map.get(-6) 
				+ " -5/d'''/" + map.get(-5) 
				+ " -4/u'''/" + map.get(-4) 
				+ " -3/d''/" + map.get(-3) 
				+ " -2/u''/" + map.get(-2) 
				+ " -1/d'/" + map.get(-1) 
				+ " 0/u'/" + map.get(0) );

		System.out.println("next (ixj):");
		
		while(true) {
			String str = scanInput.nextLine();
			System.out.println("given: " + str);
			if(str.equals("SD")) {
				break;
			}
			if(str.equals("NEW")) {
				massSum = 0.0d;
				massComposes = "";
				quarkComposes = "";
				System.out.println("NEW Calc -----------------------------------");
				
			} else {

				String[] strs = str.split("x");
				if (strs.length != 2) {
					System.out.println("format wrong!");
					
				} else {
				
					Integer i = Integer.parseInt(strs[0]);
					Integer j = Integer.parseInt(strs[1]);
					
					if (j>7 || j<-8) {
						System.out.println("Excitation is out of range: " + j);
					}
					
					quarkComposes += (quarkComposes.isEmpty()? " ":" - ") + i + " " + mapSign.get(j);
					massComposes += (massComposes.isEmpty()? " ":" + ") + i + " x " + map.get(j);
					massSum += i * Double.parseDouble(map.get(j));
										
					System.out.println("quarkComposes: " + quarkComposes);
					System.out.println("massComposes: " + massComposes);
					System.out.println("massSum: " + massSum);
				}
			}
		}
		

		System.out.println("OK, finished");
		scanInput.close();        		
	}
}
