import java.util.Scanner;

public class HauptFile {
	Scanner myScan = new Scanner(System.in);
	static int zahlVersuche = 0;
	
	public static void main (String[] args) {
		HauptFile myHaupt = new HauptFile(); 
		SpeicherObjekt myObjekt = new SpeicherObjekt();
		myObjekt.schiffAufsetzen();
		myObjekt.printFelder();
		System.out.println("Wieviele Versuche?");
		zahlVersuche = myHaupt.myScan.nextInt();
		myHaupt.spielMethode(myObjekt);

	}
	
	public  void spielMethode(SpeicherObjekt in_objekt) {
		for (int i=0; i<zahlVersuche; i++) {
			System.out.println("Bitte x koordinate eingeben");
			int x = myScan.nextInt();			
			System.out.println("Bitte y koordinate eingeben");
			int y = myScan.nextInt();
			in_objekt.schussTesten(x,y);
		}
		
	}
	
}
