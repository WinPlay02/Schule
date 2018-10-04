package buero;

import java.util.Random;

import datentype.Queue;

public class Buero {
	Queue<Person> warteschlange;

	public Buero() {
		warteschlange = new Queue<Person>();
	}

	public void hintenAnstellen(Person pPerson) {
		warteschlange.enqueue(pPerson);
		System.out.println(pPerson.getName() + " hat sich angestellt. Der Idiot");
	}

	public void einlassen() {
		Person pPerson = warteschlange.front();
		warteschlange.dequeue();
		System.out.println(pPerson.getName() + " wird eingelassen.");
	}

	public void sprechstundeBeenden() {
		while (!warteschlange.isEmpty()) {
			Person pPerson = warteschlange.front();
			warteschlange.dequeue();
			System.out.println(pPerson.getName() + " muss morgen wieder kommen.");
		}
		System.out.println("Alle rausgeworfen!!!");
	}

	public static void main(String... string) {
		Buero b = new Buero();
		Random r = new Random();
		int rand = 0;

		while ((rand = r.nextInt(64)) != 32) {
			b.hintenAnstellen(new Person(Integer.toString(rand)));
		}

		while ((rand = r.nextInt(64)) != 32 && !b.warteschlange.isEmpty()) {
			b.einlassen();
		}

		b.sprechstundeBeenden();
		// int i = 500;
		// while (i --> 0) { //limes operator
		// System.out.println( i + " -> " + "0");
		// }
	}
}
