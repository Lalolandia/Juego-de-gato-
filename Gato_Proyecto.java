package com.mycompany.eso;

import java.util.Scanner;
/**
 *
 * @author LuisHdez
 */
public class Gato_Proyecto {
    
    
    public static void Menu(){
        System.out.println("     ____.                                     .___        .__      ________           __           \n" +
"    |    | __ __   ____     ____    ____     __| _/  ____  |  |    /  _____/ _____   _/  |_   ____  \n" +
"    |    ||  |  \\_/ __ \\   / ___\\  /  _ \\   / __ | _/ __ \\ |  |   /   \\  ___ \\__  \\  \\   __\\ /  _ \\ \n" +
"/\\__|    ||  |  /\\  ___/  / /_/  >(  <_> ) / /_/ | \\  ___/ |  |__ \\    \\_\\  \\ / __ \\_ |  |  (  <_> )\n" +
"\\________||____/  \\___  > \\___  /  \\____/  \\____ |  \\___  >|____/  \\______  /(____  / |__|   \\____/ \n" +
"                      \\/ /_____/                \\/      \\/                \\/      \\/                ");
        System.out.println("");
        System.out.println("");
        System.out.println("[1.] Comenzar a Jugar!!!");
        System.out.println("[2.] Salir");
        
        System.out.print("Digite su Opcion Aqui: ");
    }
    
    
    public static void main(String args[]) { 
	Scanner obj = new Scanner(System.in);
	String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}}; // Acomodo de la pantalla del gato 
	int turnos = 0;
                    int op;
                    boolean salir=false;
                    Menu(); 
                    
                    op = obj.nextInt();
                    if (op == 1){
        
                                   System.out.println("...................................................................");
                                   System.out.println("!!!!!JUEGO DEL GATO!!!!!");
                                   System.out.println("...................................................................");
                                   System.out.println("****Jugador  vs Jugador****");
                                   System.out.println("---Jugador # 1(X)---Jugador #2 (O)");
                                   System.out.println(" ");
                                System.out.println(" ");
                                
                                printBoard(board); // Se llama al metodo de la pantalla del Gato
	while(true) {
		Scanner entrada1 = new Scanner(PedirEntrada(obj, board, 1)); // Se llama al metodo de Pedir entrada para el jugador 1, y se elije la X para el primer jugador 
		board[entrada1.nextInt() - 1][entrada1.nextInt() - 1] = "X"; // El valor esta en -1 para que a la hora que se escriba en las cordenadas empiece en 0
		entrada1.close();
		turnos++; // Contador de Turnos 
		
		printBoard(board);
		// Metodo de verificacion de Ganadores
		if(turnos == 9 && !VerGanador(board)) {// Para verificar los intentos y si hay o no empate y continuar con el Ganador
			System.out.println("Se Declara un Empate!!!");
			break;
		}
		if(VerGanador(board)) {
			System.out.println("El Jugador 1 gana!!!!");
			break;
		}
								
		Scanner entrada2 = new Scanner(PedirEntrada(obj, board, 2));
		board[entrada2.nextInt() - 1][entrada2.nextInt() - 1] = "O";
		entrada2.close();
		turnos++;
		
		printBoard(board);
				
		
		if(VerGanador(board)) {
			System.out.println("Jugador 2 gana!!!!");
			break;
		}
		
	}
	obj.close();
}else if (op == 2){
                        System.out.println("!!!!Chao chao pescao!!!");
    salir=true;

}
    }
    
    
public static void printBoard(String[][] board) { // Orden de la Pantalla del gato 
           System.out.println(" ");
System.out.println("            1   2   3\n");
System.out.println("        1   "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
System.out.println("           -----------");
System.out.println("        2   "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
System.out.println("           -----------");
System.out.println("        3   "+board[2][0]+" | "+board[2][1]+" | "+board[2][2] + "\n");

}

public static String PedirEntrada(Scanner in, String[][] board, int player) { //Metodo para pedir Entrada del los Jugadores
	boolean bool = true;
	int pline = 0, pcolumn = 0;
	while(bool) {
                                          
		System.out.print("Le toca al Jugardor #" + player + " digite la linea y columna con espacio: ");
		pline = in.nextInt();
                
		while(true) {
			if(pline > 3 || pline < 1) { // Verificacion de Ingreso fuera de rango (| | or inclusivo)  
				System.out.println("INGRESO INVALIDO, INTENTE DE NUEVO");
				in.nextLine();
				pline = in.nextInt();
			} else 
				break;			
		}
		pcolumn = in.nextInt();
		while(true) {
			if(pcolumn > 3 || pcolumn < 1) {
				System.out.println("INGRESO INVALIDO, INTENTE DE NUEVO");
				in.nextLine();
				pcolumn = in.nextInt();
			} else 
				break;			
		}
		if(board[pline - 1][pcolumn - 1] == " ")
			bool = false;
	}
	
	return pline + " " + pcolumn;
}

public static boolean VerGanador(String[][] board) { // Metodo de verificacion de Ganador
	for(int n = 0; n < board.length; n++) { 
		if((board[n][0] == "X" && board[n][1] == "X" && board[n][2] == "X") || 
		(board[n][0] == "O" && board[n][1] == "O" && board[n][2] == "O"))
			return true;				
	}// Se recorre en cada una de las posiciones de la pantalla de juego y verifica las cordenadas ingresadas 
                      // llamando a este metodo verificamos si hay empate o ganado.
	for(int n = 0; n < board.length; n++) {
		if((board[0][n] == "X" && board[1][n] == "X" && board[2][n] == "X") || 
		(board[0][n] == "O" && board[1][n] == "O" && board[2][n] == "O"))
			return true		;		
	}
	if((board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") || 
	(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O"))
		return true;
	if((board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") || 
	(board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O"))
		return true;
	return false;
}
}