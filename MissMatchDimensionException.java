package ar.edu.uno.poo2.modulo;

public class MissMatchDimensionException extends Exception{
	
	private String textoError= "Las dimensiones no coinciden";
	
	MissMatchDimensionException(){
	}

	//getters & setters
	public String getTextoError() {
		return textoError;
	}

	public void setTextoError(String textoError) {
		this.textoError = textoError;
	}
	
}
