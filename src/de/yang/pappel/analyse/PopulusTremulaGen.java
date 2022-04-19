package de.yang.pappel.analyse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PopulusTremulaGen {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		// 1. Datei angeben/definieren (Path!)
		
		Path inputFile = Paths.get("/Users/celine/Desktop/Programmieren/PopulusTremula.gen");
	
	
	// 2. Datei lesen
		
		List<String> originalZeilen = new ArrayList() ;
		
		try {
			originalZeilen = Files.readAllLines(inputFile, StandardCharsets.UTF_8);
			System.out.println ("Anzahl der Zeilen ist:" + originalZeilen.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	// 3. Aufruf Methode: Datei analysieren (Triplet-Kombinationen in einer Array-Liste sammeln)
		
		List<String> tripletKombis = tripletListeErstellen(originalZeilen.get(0)) ;
		
		System.out.println ("Anzahl der Buchstaben ist:" + originalZeilen.get(0).length());
		
		System.out.println ("Anzahl der Tripletts ist:" + originalZeilen.get(0).length()/3);

		System.out.println ("Anzahl der einzigartigen Triplett-Kombis ist:" + tripletKombis.size());
		
		
	
	// 4. Aufruf Methode: Zeilen nur mit einer Triplet-Kombination, der Rest "-"
	
		List<String> alleTripletZeilen = new ArrayList();
		
		alleTripletZeilen.add(originalZeilen.get(0));
		
				for (int j=0; j<tripletKombis.size(); j++) {
					
				
				
				String zuHinzufuegendeZeile = genZeileUmschreiben(originalZeilen.get(0), tripletKombis.get(j));
				
				alleTripletZeilen.add(zuHinzufuegendeZeile);
				
				
				}
				
		
		
	
	// 5. Neue Datei erstellen

		Path outputFile = Paths.get("/Users/celine/Desktop/Programmieren/PopulusTremulaSequenz.txt");
		try {
			Files.write(outputFile, alleTripletZeilen, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}


 // Methode 3 & 4 definieren

/**
 * Diese Methode 3 bekommt eine Zeile und liefert eine Liste mit Dreier-Kombinationen zurück
 * Eingabe: Genzeile
 * Rückgabe: Liste mit möglichen Triplet-Kombis
 */
		static List<String> tripletListeErstellen(String genSequenzZeile) {
			
			List<String> tripletListe = new ArrayList();
			
			int anzahlDerDreier = genSequenzZeile.length()/3;
			
			for(int i=0; i<anzahlDerDreier; i+=3){ 
				
					String triplett = genSequenzZeile.substring(i, i+3);
				
			
					if(i==0){ 
					tripletListe.add(triplett);
					
					}
					else{
					
						boolean esGibtEineUebereinstimmung = false;
					
						for(int u=0; u<tripletListe.size(); u++) {
						if (triplett.equals(tripletListe.get(u))) {
			
							esGibtEineUebereinstimmung = true;
						
						}
						
					}
					
					if(!esGibtEineUebereinstimmung) {
						tripletListe.add(triplett);
					}
					
				}
				
			}
	
			return tripletListe;
			
		}
		
	

		

 
// Methode 4: Schreibt die Originalzeile mit einer beliebigen Triplet-Kombi um
		
		static String genZeileUmschreiben(String genSequenzZeile, String eineTripletKombi) {
			
					String umgeschriebeneZeile = "";
			
					int anzahlDerDreier = genSequenzZeile.length()/3;
			
			for(int i=0; i<anzahlDerDreier; i+=3){ 
				
					String triplett = genSequenzZeile.substring(i, i+3);
				
			
					if(triplett.equals(eineTripletKombi)){ 
						umgeschriebeneZeile+=triplett;
					
					}
					else{
					
						umgeschriebeneZeile+="---";
						
						}
						
					}
			return umgeschriebeneZeile;
			
					}
		
		
}
		




	