package ar.edu.uno.poo2.modulo;
import java.util.*;
import java.io.*;

public class Main {


	public static void main (String[] args) throws MissMatchDimensionException, NoInversibleException{
		Vector vector= new Vector(3);
		Vector vector1= new Vector(3);
		Vector vector2=new Vector(3);
		vector.agregar(1.2);
		vector.agregar(5.7);
		vector.agregar(9.0);
		vector1.agregar(7.3);
		vector1.agregar(4.6);
		vector1.agregar(13.8);
		if (!vector.agregar(1.2))
			System.out.println("Error");
		System.out.println(vector.toString());
		System.out.println(vector1.toString());
		vector.sumar(vector1);
		System.out.println(vector.toString());
		vector.restar(vector1);
		System.out.println(vector.toString());


		Matriz matriz = new Matriz(3, 3);
		Matriz matriz2 = new Matriz(3,3);
		Matriz matriz3 = new Matriz(3,3);
		Matriz matriz4 = new Matriz(2,2);
		Matriz matriz5 = new Matriz(2,2);
		Matriz matriz6 = new Matriz(2,2);

		Matriz matriz7 = new Matriz(3,2);
		Matriz matriz8 = new Matriz(2,3);

matriz.agregar(0, 0, 1.0);
		matriz.agregar(0, 1, 2.0);
		matriz.agregar(0, 2, 2.0);
		matriz.agregar(1, 0, 3.0);
		matriz.agregar(1, 1, 1.0);
		matriz.agregar(1, 2, 1.0);
		matriz.agregar(2, 0, 3.0);
		matriz.agregar(2, 1, 1.0);
		matriz.agregar(2, 2, 1.0);

		matriz2.agregar(0, 0, 1.0);
		matriz2.agregar(0, 1, 2.0);
		matriz2.agregar(0, 2, 3.0);
		matriz2.agregar(1, 0, -4.0);
		matriz2.agregar(1, 1, 5.0);
		matriz2.agregar(1, 2, 6.0);
		matriz2.agregar(2, 0, 7.0);
		matriz2.agregar(2, 1, -8.0);
    	matriz2.agregar(2, 2, 9.0);

		matriz4.agregar(0, 0, 1.0);
		matriz4.agregar(0, 1, 1.0);
		matriz4.agregar(1, 0, 2.0);
		matriz4.agregar(1, 1, 3.0);

		matriz5.agregar(0, 0, 1.0);
		matriz5.agregar(0, 1, 1.0);
		matriz5.agregar(1, 0, 2.0);
		matriz5.agregar(1, 1, 3.0);

		matriz7.agregar(0, 0, 1.0);
		matriz7.agregar(0, 1, 2.0);
		matriz7.agregar(1, 0, 3.0);
		matriz7.agregar(1, 1, 1.0);
		matriz7.agregar(2, 0, 3.0);
		matriz7.agregar(2, 1, 1.0);

		matriz8.agregar(0, 0, 1.0);
		matriz8.agregar(0, 1, 1.0);
		matriz8.agregar(0, 2, 1.0);
		matriz8.agregar(1, 0, 2.0);
		matriz8.agregar(1, 1, 3.0);
		matriz8.agregar(1, 2, 1.0);
		


		System.out.println(matriz.toString());

		System.out.println(matriz2.toString());

	matriz3 = matriz.producto(matriz2);	
		System.out.println(matriz3.toString());

		matriz6 = matriz4.producto(matriz5);
	//	System.out.println(matriz6.matrizInversa().toString());

		matriz6 = matriz2.producto(matriz5);
		System.out.println(vector.productoEscalar(vector1));
		Matriz matriz9 = matriz7.producto(matriz8);
		System.out.println(matriz9.toString());

		System.out.println(matriz9.normaUno());
		System.out.println(matriz9.normaDos());

		System.out.println(matriz9.producto(2.0).toString());

        SEL sel = null;
		File file= new File("input.in");
		FileReader fr = null;
		BufferedReader br;

		try{
			fr= new FileReader(file);
			br= new BufferedReader(fr);
			StringTokenizer linea= new StringTokenizer(br.readLine());
			int fila= Integer.parseInt(linea.nextToken());
			sel= new SEL(fila);
			//matriz11= new Matriz(fila,columna);
			double valor;
			for (int i=0; i<sel.getI(); i++){
				linea= new StringTokenizer(br.readLine());
				for (int j=0; j<sel.getI(); j++){
					valor=Double.parseDouble(linea.nextToken());
					sel.agregar(i, j, valor);
				}
			}
			//System.out.println(matriz11.toString());
			linea= new StringTokenizer(br.readLine());
			for (int j=0; j<sel.getI(); j++){
				valor=Double.parseDouble(linea.nextToken());
				sel.agregar(valor); //Aca se carga el vector. Hay que adaptarlo
			}
		}catch (Exception e){
			System.out.println(e.getStackTrace());
		}finally{try{                    
			if( null != fr ){   
				fr.close();     
			}                  
		}catch (Exception e2){ 
			e2.printStackTrace();
		}
		}
		try{
			System.out.println("Matriz inversa");
			System.out.println(sel.matrizInversa().toString());
		}catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println(sel.toString());
		System.out.println(sel.determinante());
		
		System.out.println(sel.matrizInversa().toString());
	}
	

}

