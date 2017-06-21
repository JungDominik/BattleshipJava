import java.util.Random;
import java.util.Scanner;

public class SpeicherObjekt {
	int SPIELFELD_X = 10;
	int SPIELFELD_Y = 10;
	final static String SCHIFF = " O";
	
	String[][] posSpeicher = new String [SPIELFELD_X][SPIELFELD_Y]; 
	
	public SpeicherObjekt() {
	for (int iZeile = 0; iZeile<SPIELFELD_X; iZeile++) {
			for (int iSpalte = 0; iSpalte<SPIELFELD_Y; iSpalte++) {
				posSpeicher[iZeile][iSpalte] = " ~";
		}
	}
}

	
	public void printFelder(){
		System.out.println("Schiffe Versenken! \n");
		
		for (int i = 0; i<10; i++) {
			String zeilenString = "";
			for (int j = 0; j<10; j++) {
				zeilenString += posSpeicher[i][j];
			}
			System.out.println(zeilenString);
		}
	}
	
	public void schiffAufsetzen() {
		Scanner myScan = new Scanner(System.in);
		System.out.println("Bitte Schifflaenge eingeben : ");
		int schiffLaenge = (int) myScan.nextInt();
		boolean laengs = (new Random()).nextBoolean();
		int xPlatz;
		int yPlatz;
		
		if (laengs){
			xPlatz = SPIELFELD_X;
			yPlatz = SPIELFELD_Y-schiffLaenge;
		}
		else {
			xPlatz = SPIELFELD_X-schiffLaenge;
			yPlatz = SPIELFELD_Y;
		}
		
		
		int setzX = (int) (Math.random() * (xPlatz));	//Startpunkt festlegen, wird dann evtl erhöht
		int setzY = (int) (Math.random() * (yPlatz));
		
		for (int i = 0; i<schiffLaenge; i++ ){
			posSpeicher[setzX][setzY] = SCHIFF;
			if (laengs) {setzY++;}
			else		{setzX++;}
		}
	}
	
	public boolean schussTesten(int in_x, int in_y) {
		if (posSpeicher[in_x][in_y] == SCHIFF) {
			posSpeicher[in_x][in_y] = " X";
			System.out.println("Treffer!");
			printFelder();
			return true;}
		
		else {
			posSpeicher[in_x][in_y] = " Y";
			System.out.println("Platsch!");
			printFelder();
			return false;
		}
	}
	
}


