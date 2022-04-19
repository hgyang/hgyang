package en.london.uebung;

import java.nio.file.Path;
import java.nio.file.Paths;


public class FileEncodeUndDecode {
	
	public static void main(String[] args) {
		
		System.out.println("Übergebene Argumente:");
		
		for (int u=0; u<args.length; u++) {
			System.out.println("Das Argument " + (u) + ":" + args[u]);
		}
		
		// int nofVerschiebung = 5;
		// Path inputFile = Paths.get("c://Temp//file-orig.txt");
		// Path outputFile = Paths.get("c://Temp//file-encode.txt");		
		//Path inputFile = Paths.get("c://Temp//file-encode.txt");
		//Path outputFile = Paths.get("c://Temp//file-decode.txt");
		
		int nofVerschiebung = new Integer(args[1]);
		
		if ("encode".equals(args[0])) {
			System.out.println("Soll encode");
			
		} else if ("decode".equals(args[0])) {
			System.out.println("Soll decode");
			// Verschiebung fuers Decoding
			nofVerschiebung = 26 - nofVerschiebung;
			
		} else {
			System.err.println("Falsche Eingabe zur Steuerung des Codierens!");
			System.exit(1);
		}

		System.out.println("Gegebene Zeichen-Verschiebung ist: " + nofVerschiebung);
		
		
		Path inputFile = Paths.get(args[2]);
		Path outputFile = Paths.get(args[3]);
		
		// HashMap<String, String> regeln = byteShiftingRegeln();
		// dateiLesenUndAendern(inputFile, outputFile, regeln, nofVerschiebung);
		
		EncodeUndDecodeAlgorithm.dateiLesenUndAendern(inputFile, outputFile, nofVerschiebung);
		
	}

		
}


