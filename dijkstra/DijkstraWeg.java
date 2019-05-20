package dijkstra;

import java.util.ArrayList;

public class DijkstraWeg {
	// public static void gibKuerzesteWegeAus(GraphNode pStart, GraphNode pZiel) {
	// String weg = pZiel.getName();
	// GraphNode vorgaenger = pZiel;
	// do {
	// vorgaenger = vorgaenger.getVorgaenger();
	// weg = vorgaenger.getName();
	// } while (vorgaenger != pStart);
	// }

	public static int Knoten_mit_kleinster_Distanz() {
		int MinDistanz = Integer.MAX_VALUE;
		int MinKnoten = -1;
		ArrayList<Integer> Erledigt = new ArrayList<Integer>();
		ArrayList<Integer> Distanz = new ArrayList<Integer>();
		for (int Knoten = 1; Knoten < matrix.length; Knoten++) {
			if (!Erledigt.contains(Integer.valueOf(Knoten)) && Distanz.get(Knoten) < MinDistanz) {
				MinDistanz = Distanz.get(Knoten);
				MinKnoten = Knoten;
			}
		}
		return MinKnoten;
	}

	static int[][] matrix = null;

	public static int[][] dijkstra(int pStart) {
		boolean[] Erledigt = new boolean[matrix.length];
		int[] Distanz = new int[matrix.length];
		int[] Vorgaenger = new int[matrix.length];

		int MinKnoten = Integer.MAX_VALUE;
		for (int Knoten = 0; Knoten < matrix.length; Knoten++) {
			Distanz[Knoten] = Integer.MAX_VALUE;
			Vorgaenger[Knoten] = -1;
			Erledigt[Knoten] = false;
		}
		for (int Knoten = 0; Knoten < matrix.length; Knoten++) {
			MinKnoten = Knoten_mit_kleinster_Distanz();
			if (MinKnoten != -1) {
				Erledigt[Knoten] = true;
				for (int i = 0; i < matrix.length; i++) {
					if (!Erledigt[Knoten] && Distanz[MinKnoten] + matrix[MinKnoten][Knoten] < Distanz[Knoten]) {
						Distanz[Knoten] = Distanz[MinKnoten] + matrix[MinKnoten][Knoten];
						Vorgaenger[Knoten] = MinKnoten;
					}
				}
			}
		}
		return new int[][] { Distanz, Vorgaenger };
	}

	static {
		// matrix={{0,2,3,-1,-1,-1,-1,7,-1},{2,0,-1,1,-1,5,-1,1},{3,-1,0,-1,3,-1,-1,-1},{-1,1,-1,0,-1,-1,-1,-1},{-1,-1,3,-1,0,1,1,-1},{-1,5,-1,1,1,0,-1,-1},{7,-1,-1,-1,1,-1,0,2},{-1,1,-1,-1,-1,-1,0,1}};

	}

	public static void main(String... args) {
	}
}
