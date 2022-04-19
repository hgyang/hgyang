package en.london.uebung;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EncodeUndDecodeAlgorithm {
	
	// static void dateiLesenUndAendern(Path inputFile, Path outputFile, HashMap<String, String> regeln, int nofV) {
	public static void dateiLesenUndAendern(Path inputFile, Path outputFile, int nofV) {
			
		HashMap<String, String> regeln = byteShiftingRegeln();
		
		System.out.println("Ich moechte eine Datei lesen und umcodieren");
				
	    try {
		    List<String> alleZeilen = Files.readAllLines(inputFile, StandardCharsets.UTF_8);
		    
		    List<String> alleUmcodiertenZeilen = new ArrayList();		
		    
		    int n = alleZeilen.size();
		    System.out.println("Input Datei hat eine Laenge von (" + n + ") Zeilen.");
		    
		    for(int i=0; i<n; i++) {
		    	String nurEineZeile = alleZeilen.get(i);
		    	
		    	String umcodierteZeile = "";
		    	
		    	for (int j=0; j<nurEineZeile.length(); j++) {
		    		String zeichen = nurEineZeile.substring(j, j+1);
		    		
		    		
		    		if(regeln.containsKey(zeichen)) {
		    			
		    			
		    			for (int k=0; k<nofV; k++) {
		    				zeichen = regeln.get(zeichen);
		    			}
		    			
			    		umcodierteZeile += zeichen ;	
			    		
		    		} else {
		    			umcodierteZeile += zeichen;
		    		}
		    	}
		    	
		    	alleUmcodiertenZeilen.add(umcodierteZeile);
		    	
		    }

		    Files.write(outputFile, alleUmcodiertenZeilen, StandardCharsets.UTF_8);

			System.out.println("Datei erfolgeich geschrieben");

		} catch (IOException e1) {
			System.out.println("Das Programm ist auf einen Fehler (Exception) gestossen");

			e1.printStackTrace();
			
			System.exit(0);
		}

	}
	

static HashMap<String, String> byteShiftingRegeln() {
		
		HashMap<String, String> hgVariable = new HashMap<String, String>();
		
		hgVariable.put("a", "b");		// a -> b
		hgVariable.put("b", "c");		// b -> c
		hgVariable.put("c", "d");		// c -> d
		hgVariable.put("d", "e");		//
		hgVariable.put("e", "f");		// 
		hgVariable.put("f", "g");		// 
		hgVariable.put("g", "h");		// 
		hgVariable.put("h", "i");		// 
		hgVariable.put("i", "j");		// i -> j
		
		hgVariable.put("j", "k");		// 
		hgVariable.put("k", "l");		// 
		hgVariable.put("l", "m");		// 
		hgVariable.put("m", "n");		//
		hgVariable.put("n", "o");		// 
		hgVariable.put("o", "p");		// 
		hgVariable.put("p", "q");		// 
		hgVariable.put("q", "r");		// 
		hgVariable.put("r", "s");		// 
		
		hgVariable.put("s", "t");		//
		hgVariable.put("t", "u");		// 
		hgVariable.put("u", "v");		// 
		hgVariable.put("v", "w");		//
		hgVariable.put("w", "x");		//
		hgVariable.put("x", "y");		// 
		hgVariable.put("y", "z");		// 
		hgVariable.put("z", "a");		// 
		
		return hgVariable;
		
	}

	
}


