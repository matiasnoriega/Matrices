package ar.edu.uno.poo2.modulo;

public class SEL extends Matriz {
	private Integer i;
	
	public SEL(Integer i){
		super(i,i);	
	}
	
	public static double[] resolverSistemaEcuacion(double matriz[][], double resultado[]) {
		/* Me paro arbitrariamente en la fila 1 columna 1. Tomo el 2 como pivote.
		 * Sobre esa misma columna busco la que tenga el valor absoluto más grande.
		 * Intercambio la fila 2 con la fila 1. El nuevo pivote pasa a ser el 3
		 * 
		 * Paso 1 (Intercambio Filas)
		 * 
		 * |3 9 2 1 |
		 * |2 9 9 0 |
		 * |1 0 1 2 |
		 * 
		 * Paso 2 Divido la fila del pivote por el pivote
		 * |1 3 2/3 1/3 |
		 * |2 9  9   0  |
		 * |1 0  1   2  |
		 * 
		 * Paso 3 Busco multiplos de la fila 1 para eliminar fila 2 y 3.
		 * -2F1 + F2 = F2
		 * -1F1 + F3 = F3
		 * 
		 * Paso 4 Sumar las lineas, eso producirá filas con la columna del pivote en 0
		 * 
		 * Paso 5 tomar otro pivote, Se tapa la F1. En este caso F2C2. Se repiten los pasos del 1 al 4
		 * 
		 * Por ultimo realizar la sustitución hacia atrás para obtener la solución
		 * 
		 */
		
		//1 Paso
		/*double mayor = 0.0;
		int fila = 0;
		for (int i = 0; i < matriz.length; i++) {
			//for (int j = 0; j < matriz[i].length; j++)
				//System.out.println(matriz[i][0] + " ");
			if (Math.abs(matriz[i][0]) > mayor) {
				mayor = Math.abs(matriz[i][0]);
				fila = i;
			}
		}*/
		
		//Encontré la fila que debería ser la primera
		//System.out.println("fila: " + fila + " pivot: " + mayor);
		
		//Como la matriz es cuadrada tenemos la cantidad de filas es igual a la cantidad de columnas
		int n = resultado.length;
		
		//Iteramos por las columnas
		for (int col = 0; col < n; col++) {
			
			int posMax = col;
			//iteramos por las filas
			for (int fil = col + 1; fil < n; fil++)
				if (Math.abs(matriz[fil][col]) > Math.abs(matriz[posMax][col]))
					posMax = fil;
				
			//Cambiamos la fila
			double[] swap  = matriz[col];
			matriz[col] = matriz[posMax];
			matriz[posMax] = swap;
			
			//Cambiamos el resultado (Matriz Extendida)
			double res = resultado[col];
			resultado[col] = resultado[posMax];
			resultado[posMax] = res;
			
			//Revisar si la matriz no es inversible
			
			//Pivotamos
			for (int i = col + 1; i < n; i++) {
				double pivote = matriz[i][col] / matriz[col][col];
				resultado[i] -= pivote * resultado[col];
				for (int j = col; j > n; j++)
					matriz[i][j] -= pivote * matriz[col][j];
			}
		
		}
		
		//Sustituímos hacia atrás
		double[] var = new double[n];
		
		for (int i = n - 1; i >= 0; i--) {
			double suma = 0.0;
			for (int j = i + 1; j < n; j++) {
				suma += matriz[i][j] * var[j];
			}
			var[i] = (resultado[i] - suma) / matriz[i][i];
		}
		return var;
	}
	
}
