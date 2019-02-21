
public class Morse {
	// Entry Point
	public static void main(String... cmd_args) {
		Morse morse = new Morse();
		System.out.print("In-Order: ");
		traverseInOrder(morse.morseBaum);
		System.out.println();
		System.out.print("Pre-Order: ");
		traversePreOrder(morse.morseBaum);
		System.out.println();
		System.out.print("Post-Order: ");
		traversePostOrder(morse.morseBaum);
		System.out.println();
		// Test mit Beispiel
//		String muster = "..-. . .... .-.. . .-. ..-. .-. . ..";
//		String resultat = morse.morseDecodieren(muster);
//		System.out.println("Muster:\t\t" + muster + System.lineSeparator() + "Resultat:\t" + resultat);
		//
	}

	public static void traverseInOrder(BinaryTree<Character> tree_node) {
		if (tree_node == null) {
			return;
		}
		traverseInOrder(tree_node.getLeftTree());
		if (tree_node.getContent() != null) {
			System.out.print(String.format("%s", tree_node.getContent()));
		}
		traverseInOrder(tree_node.getRightTree());
	}

	public static void traversePreOrder(BinaryTree<Character> tree_node) {
		if (tree_node == null) {
			return;
		}
		if (tree_node.getContent() != null) {
			System.out.print(String.format("%s", tree_node.getContent()));
		}
		traversePreOrder(tree_node.getLeftTree());
		traversePreOrder(tree_node.getRightTree());
	}

	public static void traversePostOrder(BinaryTree<Character> tree_node) {
		if (tree_node == null) {
			return;
		}
		traversePostOrder(tree_node.getLeftTree());
		traversePostOrder(tree_node.getRightTree());
		if (tree_node.getContent() != null) {
			System.out.print(String.format("%s", tree_node.getContent()));
		}
	}

	// Enthält alle wichtigen Zeichen
	BinaryTree<Character> morseBaum;

	//
	public Morse() {
		morseBaum = new BinaryTree<Character>();
		erstelleMorsecodebaum();
	}

	// Aufgabe c
	public void erstelleMorsecodebaum() {
		// [3] + [4] (Lowest)
		BinaryTree<Character> c_s = new BinaryTree<Character>('S', new BinaryTree<Character>('H'),
				new BinaryTree<Character>('V'));
		BinaryTree<Character> c_u = new BinaryTree<Character>('U', new BinaryTree<Character>('F'),
				new BinaryTree<Character>('Ü'));
		BinaryTree<Character> c_r = new BinaryTree<Character>('R', new BinaryTree<Character>('L'),
				new BinaryTree<Character>('Ä'));
		BinaryTree<Character> c_w = new BinaryTree<Character>('W', new BinaryTree<Character>('P'),
				new BinaryTree<Character>('J'));
		BinaryTree<Character> c_d = new BinaryTree<Character>('D', new BinaryTree<Character>('B'),
				new BinaryTree<Character>('X'));
		BinaryTree<Character> c_k = new BinaryTree<Character>('K', new BinaryTree<Character>('C'),
				new BinaryTree<Character>('Y'));
		BinaryTree<Character> c_g = new BinaryTree<Character>('G', new BinaryTree<Character>('Z'),
				new BinaryTree<Character>('Q'));
		BinaryTree<Character> c_o = new BinaryTree<Character>('O', new BinaryTree<Character>('Ö'),
				new BinaryTree<Character>('Č'));

		// [2]
		BinaryTree<Character> c_i = new BinaryTree<Character>('I', c_s, c_u);
		BinaryTree<Character> c_a = new BinaryTree<Character>('A', c_r, c_w);
		BinaryTree<Character> c_n = new BinaryTree<Character>('N', c_d, c_k);
		BinaryTree<Character> c_m = new BinaryTree<Character>('M', c_g, c_o);
		// [1]
		BinaryTree<Character> c_e = new BinaryTree<Character>('E', c_i, c_a);
		BinaryTree<Character> c_t = new BinaryTree<Character>('T', c_n, c_m);
		// [0] Root
		morseBaum = new BinaryTree<Character>(' ', c_e, c_t);
	}

	// Hilfsmethode, um zu entscheiden, ob der linke Teilbaum, oder der rechte
	// relevant ist
	public BinaryTree<Character> baumTeil(BinaryTree<Character> anfang, char morse_zeichen) {
		switch (morse_zeichen) {
		case '.':
			return anfang.getLeftTree();
		case '-':
			return anfang.getRightTree();
		default:
			return null;
		}
	}

	public String morseDecodieren(String code) {
		String output = "";
		for (String part : code.split(" ")) {
			BinaryTree<Character> resultierendes_zeichen = morseBaum;
			for (int i = 0; i < part.length(); i++) {
				resultierendes_zeichen = baumTeil(resultierendes_zeichen, part.charAt(i));
			}
			output = output + resultierendes_zeichen.getContent();
		}
		return output;
	}

	public String morseCodieren(String text) {
		return text;
	}
}
