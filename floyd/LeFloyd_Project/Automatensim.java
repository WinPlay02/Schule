package LeFloyd_Project;

public class Automatensim {

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub
		int [] eingabe = {1, 1, 1, 1};
		int laenge = 4;
		int zustandAktuell = 0;
		int [][] Zustandstabelle = new int [4][2];
		Zustandstabelle [0][0] = -1;
		Zustandstabelle [0][1] = 1;
		Zustandstabelle [1][0] = 2;
		Zustandstabelle [1][1] = 3;
		Zustandstabelle [2][0] = 2;
		Zustandstabelle [2][1] = -1;
		Zustandstabelle [3][0] = 2;
		Zustandstabelle [3][1] = 3;
		
		for (int i = 0; i < laenge; i++)
		{
			zustandAktuell = Zustandstabelle[zustandAktuell][eingabe[i]];
			if (zustandAktuell == -1) {
				System.out.print("Ungültige Eingabe. Beenden");
				return;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		if (zustandAktuell != 5)
		{
			System.out.print("q" + (zustandAktuell + 1) + " ist der Zustand nach Bearbeitung der Eingabe: [");
			for (int i = 0; i < laenge ; i++)
			{
				System.out.print(eingabe [i]);
				
			}
			
			System.out.print("]");
			
		}

	}

}
