package ar.edu.uno.poo2.modulo;

public class SEL extends Matriz {
	private Integer i;
	
	public SEL(Integer i){
		super(i,i);	
	}
	
	
	public static Vector resolverSistema(Matriz matriz, Vector resultado) throws MissMatchDimensionException {
		
		//obtenemos el orden de la matriz
		//corroboramos que la matriz sea cuadrada.
		int n = matriz.getI();
		int nn = matriz.getJ();
		
		//Si no es cuadrada, me voy por excepcion
		if (n != nn)
			throw new MissMatchDimensionException();
		
		//Iteramos por las columnas
		for (int col = 0; col < n; col++) {
			int posMax = col;
			
			//Iteramos por las filas
			for (int fil = col + 1; fil < n; fil++)
				if (Math.abs(matriz.obtenerValorFilaColumna(fil, col)) > Math.abs(matriz.obtenerValorFilaColumna(posMax, col)))
					posMax = fil;
			
			//Intercambiamos la fila
			//Vector swap = Vector.getVectorFromArray(array)
			double[] swap = matriz.getFila(col);
			matriz.setFila(col, matriz.getFila(posMax));
			matriz.setFila(posMax, swap);
			
			//Cambiamos Resultados para acompañar las filas de la matriz
			double res = resultado.obtenerValorFilaColumna(0, col);
			resultado.setValorColumna(col, resultado.getValorColumna(posMax));
			resultado.setValorColumna(posMax, res);
			
			//Pivotamos
			for (int i = col + 1; i < n; i++) {
				double pivote = matriz.obtenerValorFilaColumna(i, col) / matriz.obtenerValorFilaColumna(col, col);
				resultado.setValorColumna(i, resultado.getValorColumna(col) - pivote * resultado.getValorColumna(col));
				for (int j = col; j > n; j++)
					matriz.setValorFilaColumna(i, j, matriz.obtenerValorFilaColumna(i, j) - pivote * 
							matriz.obtenerValorFilaColumna(col, j));
			}
		}
		
		//SustituÃ­mos hacia atrÃ¡s
		Vector var = new Vector(n);
		
		for (int i = n - 1; i >= 0; i--) {
			double suma = 0.0;
			for (int j = i + 1; j < n; j++) {
				suma += matriz.obtenerValorFilaColumna(i, j) * var.getValorColumna(j);
			}
			var.setValorColumna(i, (resultado.getValorColumna(i) - suma) / matriz.obtenerValorFilaColumna(i, i));
		}
		
		return var;
	}
	
}
