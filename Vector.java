package ar.edu.uno.poo2.modulo;

public class Vector extends Matriz{
	private Integer ultimo=0;

	public Vector(Integer dimension){
		super(1, dimension);
	}
	
	public static Vector getVectorFromArray(double[] array) {
		Vector v = new Vector(array.length);
		for (int i = 0; i < array.length; i++)
			v.agregar(array[i]);
		return v;
	}
	
	public double getValorColumna(int col) {
		return this.obtenerValorFilaColumna(0, col);
	}
	
	public void setValorColumna(int col, double valor) {
		this.setValorFilaColumna(0, col, valor);
	}

	public boolean agregar(Double valor){
		if (ultimo < this.getJ()) {
			this.matriz[0][ultimo]=valor;
			ultimo++;
			return true;
		}else
			return false;
	}

	public void sumar(Vector otroVector) throws MissMatchDimensionException{
		try{
			if (this.getJ()==otroVector.getJ()){
				for (int i = 0; i < this.getJ(); i++)
					this.matriz[0][i]+=otroVector.matriz[0][i];
			}
			else
				throw new MissMatchDimensionException();
		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
	}

	public void restar(Vector otroVector) throws MissMatchDimensionException{
		for (int i = 0; i < otroVector.getJ(); i++)
			otroVector.matriz[0][i]*=-1;
		this.sumar(otroVector);
	}

	public Double productoEscalar(Vector otroVector) throws MissMatchDimensionException{

		Double producto=0.0;
		try{

			if (this.getJ()==otroVector.getJ()){
				for (int i = 0; i < this.getJ(); i++)
					producto+=this.matriz[0][i]*otroVector.matriz[0][i];
			}
			else
				throw new MissMatchDimensionException();
			
		}
		catch(MissMatchDimensionException e){

			System.out.println(e.getTextoError());

		}
		return producto; 


	}

	public void productoXEscalar(Double escalar){
		for (int i = 0; i < this.getJ(); i++)
			this.matriz[0][i]=this.matriz[0][i]*escalar;

	}
	
	public Double normaUno(){
		Double norma=0.0;
		for (int i=0; i<this.getJ();i++)
			if(this.matriz[0][i]>=0)
				norma+=this.matriz[0][i];
			else
				norma-=this.matriz[0][i];
		return norma;
	}

	public Double normaDos(){
		Double norma=0.0;
		for (int i=0; i<this.getJ();i++){

			norma+=this.matriz[0][i]*this.matriz[0][i];
		}
		return Math.sqrt(norma);
	}

	public Double normaInfinito(){
		Double norma=(this.matriz[0][0]>=0)?this.matriz[0][0]:-this.matriz[0][0];
		Double aux= null;
		for (int i=1; i<this.getJ();i++){
			aux = (this.matriz[0][i]>=0)?this.matriz[0][i]:-this.matriz[0][i];
			if (aux>=0 && aux>norma)
				norma=this.matriz[0][i];
			else
				if (aux<0 && aux>norma)
					norma=-this.matriz[0][i];
		}
		return norma;
	}	

	@Override
	public boolean equals(Object otroVector) {
		boolean bandera=true; 
		if (otroVector.getClass().getSimpleName()=="Vector"){
			Vector temporal=(Vector)otroVector;
			for (int i =0; i< this.getJ(); i++)
				if (this.matriz[0][i]!=temporal.matriz[0][i])
					bandera=false;
		}
		else
			bandera= false;
		return bandera;
	}

	@Override
	public String toString() {
		String cadena="(";
		for (int i = 0; i < this.getJ(); i++)
			cadena+=this.matriz[0][i]+" , ";

		cadena=cadena.substring(0, (cadena.length())-3);
		cadena+=")";
		return cadena;
	}

}
