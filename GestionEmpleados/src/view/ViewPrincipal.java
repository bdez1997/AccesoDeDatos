package view;

import java.util.Scanner;

public class ViewPrincipal {
	
	public void menu() {
		Scanner teclado =new Scanner(System.in);
		int sOption;
		System.out.println("�Qu� deseas hacer?");
		System.out.println("1. Listar Todo");
		System.out.println("2. Buscar por posici�n");
		System.out.println("3. Modificar");
		System.out.println("4. A�adir");
		System.out.println();
		
		sOption=Integer.parseInt(teclado.nextLine());
		switch (sOption) {
		case 1:
			start.Init.gest.listarTodo();
			break;

		case 2:
			
			break;
		}
		
	}

}
