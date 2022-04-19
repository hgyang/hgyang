package en.london.uebung;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileKnacker {
	
	public static void main(String[] args) {
		
		String inputFileNameMitPfad = "";

		if (args.length<1) {
			// Scan eine Eingabe
			Scanner scanInput = new Scanner(System.in);

			System.out.println("Bitte, die Eingabe-Datei mit Pfad angeben:");

			inputFileNameMitPfad = scanInput.nextLine();			

		} else {
			inputFileNameMitPfad = args[0];
		}
		
		System.out.println("Eingabe-Datei ist: " + inputFileNameMitPfad);
		Path inputFile = Paths.get(inputFileNameMitPfad);

		int nof_candidateFiles = 0;
		
		for (int i=0; i<26; i++) {
			
			int nofVerschiebung = i + 1;
			
			System.out.println("Probierte Zeichen-Verschiebung ist: " + nofVerschiebung);
					
			Path outputFile = Paths.get(nofVerschiebung + "_" + nofVerschiebung + ".txt");
			
			EncodeUndDecodeAlgorithm.dateiLesenUndAendern(inputFile, outputFile, nofVerschiebung);
			
			// int nof_treffer = checkCoincidence(outputFile);
			String keyWordTreffer = checkCoincidence(outputFile);
			/*
			 * Wenn kein Treffer existiert, wird die Ausgabe-Datei geloescht, so dass nur die potenziellen
			 * Kandidaten-Dateien erhalten bleiben. 
			 */
			// if (nof_treffer<=0) {
			if (keyWordTreffer.isEmpty()) {
		       try {
		            Files.delete(outputFile);
		            
		        } catch (IOException ioException) {
		            System.out.println("Fehler: Datei kann nicht gelöscht werden: " + outputFile.getFileName());
		            ioException.printStackTrace();
		        }
		       
			} else {
				Path newOutputFile = Paths.get(args[0] + "_" + nofVerschiebung + keyWordTreffer + ".txt");
				
				try {
					Files.move(outputFile, newOutputFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				nof_candidateFiles ++;
			}
			
		}
		
		System.out.println("Anzahl der gefundenen Kandidaten-Dateien: " + nof_candidateFiles);
	}
	
	
	static List<String> keyWords = Arrays.asList(
			"edith", "hongguang", "celine", "lana", "anna", "sofie", "yang", "papa", "mama", "kinder", "kind",
			"erna", "guether", "günther", "oma", "opa", "axt",
			"andreas", "sybille", "paul", "magda", "magdalena", "marie", "schulz",
			"onkel", "tante", "bruder", "schwester", "tochter", "sohn",
			"enkel", "enkelin", 
			"katze", "lucy", "luzie",
			"herbert", "irene", "lisa", "frank", "maga", 
			"klaus", "gertrud", "elena", "eva", "maximilian", "maximillian", "sebastian", "jeki",
			"lani", "celi"
			);

	private static String checkCoincidence(Path candidatFile) {
		
		int nof_treffer = 0;
		String keyWordTreffer = "";
		
		System.out.println("Check Key Words");
		
	    try {
		    List<String> alleZeilen = Files.readAllLines(candidatFile, StandardCharsets.UTF_8);
		    
		    int n = alleZeilen.size();
		    System.out.println("Kandidat Datei hat eine Laenge von (" + n + ") Zeilen.");
		    
		    for(int i=0; i<n; i++) {
		    	String eineZeile = alleZeilen.get(i);
		    	
		    	for (int j=0; j<keyWords.size(); j++) {
		    		String einKeyWord = keyWords.get(j);
		    		//String einReducedKeyWord = einKeyWord.substring(1);
		    		if (eineZeile.toLowerCase().contains(" " + einKeyWord + " ")
		    			|| eineZeile.toLowerCase().contains(" " + einKeyWord + ",")	
		    			|| eineZeile.toLowerCase().contains(" " + einKeyWord + ".")	
		    				) 
		    		{
		    			keyWordTreffer += "-" + einKeyWord;	// keyWordTreffer = keyWordTreffer + "-" + einKeyWord;
		    			nof_treffer ++;
		    		}		    		
		    	}  	
		    }

			System.out.println("Datei fertig gecheckt. Key Wort list: " + keyWordTreffer);

		} catch (IOException e1) {
			System.out.println("Das Programm ist auf einen Fehler (Exception) gestossen");

			e1.printStackTrace();
		}
	    
		return keyWordTreffer;
	}

		
}


