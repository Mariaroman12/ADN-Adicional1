package src;

import java.util.Map;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName;
		String respuesta= "";
		KGen miGen = new KGen();
		int size = 0;
		boolean continuar = true;
		//C:\Users\marii\OneDrive\Escritorio\copyFASTA.txt
		//C:\proyectos\nuevoCopyFasta.txt
		
		while(continuar) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Ingrese 1 para abrir fichero FASTA");
			System.out.println("Ingrese 2 para calcular y mostrar mapa de palabras de tamaño...");
			System.out.println("Igrese 0 para salir");
			System.out.println("Elija la opción");
			respuesta= sc.nextLine();
			
			if (respuesta.compareTo("1")== 0) {
				System.out.println("Ingrese el fichero en el que se encuentre la cadena de ADN");
				fileName = sc.nextLine();	
				miGen.remplazar(fileName);
			
			} else if (respuesta.compareTo("2")== 0) {
			
				System.out.println("Ingrese el tamaño de la combinación");
				size=Integer.valueOf(sc.nextLine());
				miGen.getKgenMap(size);
				Map <String, Integer>mapa = miGen.getKgenMap(size);
				
				for(String combi : mapa.keySet()) {
					System.out.println("La combinación " + combi + " esta: " + mapa.get(combi) + " veces");
				}
			
			} else {
				continuar = false;
			}
		}
		sc.close();		
	}
}