package PO;

public class LCItem {
	private Item[] listaCont;
	private int nElem;

	public LCItem(int tamanho) {
		this.listaCont = new Item[tamanho];
		this.nElem = 0;
	}

	public Item getItem(int pos) {
		if (pos >= 0 && pos < this.nElem) {
			return this.listaCont[pos];
		} else {
			return null;
		}
	}

	public int getNElem() {
		return this.nElem;
	}

	public boolean eVazio() {
		if (this.nElem == 0) {
			return true;
		}
		return false;
	}

	public boolean eCheio() {
		if (this.nElem == this.listaCont.length) {
			return true;
		}
		return false;
	}

	public int pesquisa(int num) {
		for (int i = 0; i < this.nElem; i++) {
			if (this.listaCont[i].getChave() == num) {
				return i;
			}
		}
		return -1;
	}

	public int insereFim(Item item) {
		if (this.eCheio()) {
			// esse retorno significa que o vetor esta cheio
			return -1;
		} else if (this.pesquisa(item.getChave()) != -1) {
			// esse retorno significa que o elemento ja se
			// encontra no vetor
			return -2;
		} else {
			this.listaCont[this.nElem] = item;
			this.nElem++;
			// esse retorno significa que a insercao ocorre
			// com sucesso
			return 0;
		}
	}

	public int remove(int num) {
		if (this.eVazio()) {
			// esse retorno significa que o vetor esta vazio
			return -1;
		} else {
			int pos = this.pesquisa(num);
			if (pos == -1) {
				// esse retorno significa que o elemento nao se
				// encontra no vetor
				return -2;
			} else {
				this.listaCont[pos] = this.listaCont[this.nElem - 1];
				this.nElem--;
				// esse retorno significa que a remocao ocorre
				// com sucesso
				return 0;
			}
		}
	}

	public String toString() {
		String aux = "";
		for (int i = 0; i < this.nElem; i++) {
			aux += " | " + this.listaCont[i].getChave();
		}
		if (this.nElem > 0) {
			aux += " |";
		}
		return aux;
	}
	
	public void shakersort() {
		int esq, dir, i, j;
		Item temp;
		esq = 1;
		dir = this.nElem - 1;
		j = dir;
		int interacao = 0;
		do { // leva as menores chaves para o início
			for (i = dir; i >= esq; i--)
				if (this.listaCont[i - 1].getChave() > this.listaCont[i].getChave()) {
					temp = this.listaCont[i];
					this.listaCont[i] = this.listaCont[i - 1];
					this.listaCont[i - 1] = temp;
					j = i;
				}
			esq = j + 1;
			interacao++;
			// leva as maiores chaves para o final
			for (i = esq; i <= dir; i++)
				if (this.listaCont[i - 1].getChave() > this.listaCont[i].getChave()) {
					temp = this.listaCont[i];
					this.listaCont[i] = this.listaCont[i - 1];
					this.listaCont[i - 1] = temp;
					j = i;
				}
			interacao++;
			System.out.println("Iteração: " + interacao);
			dir = j - 1;
		} while (esq <= dir);
	}

	public void inserçãoDireta() {
		int i, j, interacao = 0;
		Item temp;

		for (i = 1; i < this.nElem; i++) {
			temp = this.listaCont[i];
			j = i - 1;
			while ((j >= 0) && (this.listaCont[j].getChave() > temp.getChave())) {
				this.listaCont[j + 1] = this.listaCont[j];
				j--;
			}
			this.listaCont[j + 1] = temp;
			interacao++;
			System.out.println("Iteração: " + interacao);
		}
	}

	public void selecaoDireta() {
		int i, j, min;
		Item temp;
		for (i = 0; i < this.nElem - 1; i++) {
			min = i;
			for (j = i + 1; j < this.nElem; j++) {
				if (this.listaCont[j].getChave() < this.listaCont[min].getChave()) {
					min = j;
				}
				temp = this.listaCont[min];
				this.listaCont[min] = this.listaCont[i];
				this.listaCont[i] = temp;
			}
		}
	}
	
	public void shellsort() {
		int i, j, h;
		Item temp;
		h = 1;
		do {
			h = 3 * h + 1;
			System.out.println("H encontrados: " + h);
		} while (h < this.nElem);
		do {
			h = h / 3 - 2; // Visualizar os valores de H para depois acertar.
			System.out.println("\nValor da matriz quando o H for: " + h);
			for (i = h; i < this.nElem; i++) {
				temp = this.listaCont[i];
				j = i;
				while (this.listaCont[j - h].getChave() > temp.getChave()) {
					this.listaCont[j] = this.listaCont[j - h];
					j -= h;
					if (j < h)
						break;
				}
				this.listaCont[j] = temp;
			}
			for (Item item : listaCont) {
				System.out.print(item.toString() + " ");
			}
		} while (h != 1);
	}
	
	public void quicksort() {
		ordena(0, this.nElem - 1);
	}

	public void bubblesort() {
		int LSup, i, j, iteracao = 0;
		Item temp;
		LSup = this.nElem - 1;
		do {
			j = 0;
			for (i = 0; i < LSup; i++) {
				if (this.listaCont[i].getChave() > this.listaCont[i + 1].getChave()) {
					temp = this.listaCont[i];
					this.listaCont[i] = this.listaCont[i + 1];
					this.listaCont[i + 1] = temp;
					j = i;
				}
			}
			LSup = j;
			iteracao++;
			System.out.println("\nIteração: " + iteracao);
			for (Item item : listaCont) {
				System.out.print(item.toString() + " ");
			}
		} while (LSup >= 1);
	}



	public void insercaoDireta() {
		int i, j, iteracao = 0;
		Item temp;
		for (i = 1; i < this.nElem; i++) {
			temp = this.listaCont[i];
			System.out.println("\nIteração: " + iteracao);
			for (Item item : listaCont) {
				System.out.print(item.toString() + " ");
			}
			j = i - 1;
			while ((j >= 0) && (this.listaCont[j].getChave() > temp.getChave())) {
				this.listaCont[j + 1] = this.listaCont[j];
				j--;
			}
			this.listaCont[j + 1] = temp;
			iteracao++;
		}
	}

	private void ordena(int esq, int dir) {
		int pivo, i = esq, j = dir;
		Item temp;
		pivo = this.listaCont[(i + j) / 2].getChave();
		do {
			while (this.listaCont[i].getChave() < pivo)
				i++;
			while (this.listaCont[j].getChave() > pivo)
				j--;
			if (i <= j) {
				temp = this.listaCont[i];
				this.listaCont[i] = this.listaCont[j];
				this.listaCont[j] = temp;
				i++;
				j--;
			}
			int tentativas = 0;
			tentativas++;
			System.out.println("Já foi: " + tentativas);
		} while (i <= j);
		if (esq < j)
			ordena(esq, j);
		if (dir > i)
			ordena(i, dir);
	}

	public void heapSort() {
		int dir = this.nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		while (esq >= 0) {
			refazHeap(esq, this.nElem - 1);
			esq--;
		}
		while (dir > 0) {
			temp = this.listaCont[0];
			this.listaCont[0] = this.listaCont[dir];
			this.listaCont[dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
		System.out.println("iteração");
	}

	private void refazHeap(int esq, int dir) {
		int i = esq, mF = 2 * i + 1; // maior filho
		Item raiz = this.listaCont[i];
		boolean heap = false;
		while ((mF <= dir) && (!heap)) {
			if (mF < dir)
				if (this.listaCont[mF].getChave() < this.listaCont[mF + 1].getChave())
					mF++;
			if (raiz.getChave() < this.listaCont[mF].getChave()) {
				this.listaCont[i] = this.listaCont[mF];
				i = mF;
				mF = 2 * i + 1;
			} else
				heap = true;
		}
		this.listaCont[i] = raiz;
	}

}
