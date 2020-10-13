package simulador;

public class Paginacao {

	int[] vetorA = { 1, 2, 4, 4, 4, 7, 8, 9, 10, 10, 1, 2, 3, 4 };
	int[] vetorB = { 0, 0, 0, 0, 0 };
	int perda = 0;
	int limite = 0;
	int cont = 0;
	int posicao = 0;
	boolean p = true;

	public static void main(String[] args) {

		Paginacao pag = new Paginacao();

		pag.paginacao();
	}

	public void paginacao() {
		System.out.println("Valores contidos no vetor A: ");
		imprimeVetor();
		System.out.println(" ");

		efetuaPaginação();

		System.out.println("---------------------------------------");

		System.out.println("Valores Finais contidos no vetor B: ");
		imprimeVetorB();
		System.out.println(" ");

		System.out.println("Total de paginações perdidas: " + perda);

		System.exit(0);
	}

	private void efetuaPaginação() {
		for (int i = 0; i < vetorA.length; i++) {
			verificaVetor(vetorA[i]);

		}
	}

	// verifica se o valor do vetor A está contido no B
	public void verificaVetor(int valor) {
		p = true;
		System.out.println("Valor a ser inserido: " + valor);
		System.out.println("Valores do Vetor B:");
		imprimeVetorB();
		System.out.println(" ");
		// verifica o limite do segundo vetor
		if (limite < 5) {

			for (int i = 0; i < vetorB.length; i++) {

				if (cont == 0) {
					vetorB[i] = valor;
					perda++;
					cont = 1;
					limite++;
					posicao++;
					System.out.println("Páginação perdida!");
					System.out.println(" ");
					break;

				} else {
					if (verificaPerda(valor)) {
						System.out.println("O valor ja esta contido no vetor B!");
						System.out.println(" ");
						break;
					} else {
						if (vetorB[i] == 0) {
							vetorB[i] = valor;
							limite++;
							perda++;
							System.out.println("Páginação perdida!");
							System.out.println(" ");
							break;
						} else {
							vetorB[posicao] = valor;
							posicao++;
							limite++;
							perda++;
							System.out.println("Páginação perdida!");
							System.out.println(" ");
							break;
						}

					}

				}

			}

		}
		// Se o limite for excedido então ele substitui o ultimo numero
		else {
			if (verificaPerda(valor)) {
				System.out.println("O valor ja esta contido no vetor B!");
				System.out.println(" ");
				p = false;
			} else {
				liberaVetor();
				vetorB[4] = valor;
				perda++;
				System.out.println("Páginação perdida!");
				System.out.println(" ");
			}
			if (p == true) {
				System.out.println("Vetor B após a substituição: ");
				imprimeVetorB();
				System.out.println(" ");
				p = false;
			}

		}
	}

	public boolean verificaPerda(int valor) {
		boolean val = false;
		for (int j = 0; j < vetorB.length; j++) {
			if (vetorB[j] == valor) {
				val = true;
				break;
			}
		}
		if (val) {
			return true;
		} else {
			return false;
		}

	}

	// método para imprimir valores no Vetor A
	public void imprimeVetor() {
		int aux = 0;
		System.out.print("[");
		for (int i = 0; i < vetorA.length; i++) {
			System.out.print(vetorA[i]);
			aux++;
			if (aux != vetorA.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	// método para imprimir valores do Vetor B
	public void imprimeVetorB() {
		int aux = 0;
		System.out.print("[");
		for (int j = 0; j < vetorB.length; j++) {
			System.out.print(vetorB[j]);
			aux++;
			if (aux != vetorB.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	// método para liberar espaço na fila do Vetor B
	public void liberaVetor() {
		vetorB[0] = vetorB[1];
		vetorB[1] = vetorB[2];
		vetorB[2] = vetorB[3];
		vetorB[3] = vetorB[4];
		vetorB[4] = 0;
	}

	// getters e setters
	public int[] getVetorA() {
		return vetorA;
	}

	public void setVetorA(int[] vetorA) {
		this.vetorA = vetorA;
	}

	public int[] getVetorB() {
		return vetorB;
	}

	public void setVetorB(int[] vetorB) {
		this.vetorB = vetorB;
	}

}
