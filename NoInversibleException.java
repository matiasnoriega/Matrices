package ar.edu.uno.poo2.modulo;

public class NoInversibleException extends Exception {
	
	private static final long serialVersionUID = 1L;
	String cadena= new String();
	
	public NoInversibleException(){
		cadena="La matriz no es inversible.";
	}

	@Override
	public String toString() {
		return "NoInversibleException [" + cadena + "]";
	}
}
