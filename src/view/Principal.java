package view;

import control.Pessoas;

public class Principal {

	public static void main(String[] args) {
		 for (int i = 1; i <= 4; i++) {
	            Pessoas pessoa = new Pessoas(i);
	            pessoa.start();
	        }
	}

}
