package PO;

import java.util.Scanner;

public class PesquisaOrdenacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tamanho do vetor: ");
		int tamanho = sc.nextInt();
		
		LCItem lcItem = new LCItem(tamanho);
		for(int i = 0; i < tamanho; i++) {
			int chave = sc.nextInt();
			lcItem.insereFim(new Item(chave));
		}
		
//		lcItem.shellsort();
		lcItem.bubblesort();
	}

}
