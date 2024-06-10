package src;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KGen {
	private static String data = "";
	//Map <String, Integer>Kgen;
	
	
	public static Map<String,Integer> getKgenMap (int size){
		
		Map<String, Integer> mapa = new HashMap<>();
		int contador=0;
		
				for (int i =1; i<=data.length() - size ; i+=size) {
					String combinacion = data.substring(i, i+size);
					if(mapa.containsKey(combinacion)) {
						mapa.put(combinacion,mapa.get(combinacion)+1);
						
					}else {
						mapa.put(combinacion,1);
					}
			}
		return mapa;	
	}
		
	
	public static boolean remplazar(String fileName) {
			
			boolean resultado = false;
			Scanner sc = null;
			FileReader fi=null;
				try {
					boolean comenzar = false;
					fi= new FileReader(fileName);
					sc = new Scanner(fi);
					
					while(sc.hasNext()) {
						String linea = sc.nextLine();
			            if (comenzar) {
			                data+=linea;
			            } else if (!linea.trim().isEmpty()) {
			                comenzar = true;
			                }
			            }
					
					fi.close();
					resultado = true;
					System.out.println(data);
				
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} finally {
						try {
							fi.close();
						} catch (IOException ioe) {
							System.out.println(ioe.getMessage());
							}
						}
			return resultado;	
	}

}
