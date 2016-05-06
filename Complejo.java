package ar.edu.uno.poo2.modulo;

public class Complejo {
	
	private double parteReal;
	private double parteImaginaria;
	
	public Complejo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}
	
	public void sumar(Complejo otroNumero){
		this.setParteReal(this.getParteReal()+otroNumero.getParteReal());
		this.setParteReal(this.getParteImaginaria()+otroNumero.getParteImaginaria());
	}
	
	public void sumar(Double otroNumero){
		Complejo numeroComplejo = new Complejo(otroNumero, 0);
		this.sumar(numeroComplejo);
	}
	
	public void restar(Complejo otroNumero){
		this.setParteReal(this.getParteReal() - otroNumero.getParteReal());
		this.setParteReal(this.getParteImaginaria() - otroNumero.getParteImaginaria());
	}
	
	public void multiplicar(Complejo otroNumero){
		this.setParteReal(this.getParteReal() * otroNumero.getParteReal() - this.getParteImaginaria() * otroNumero.getParteImaginaria());
		this.setParteImaginaria(this.getParteReal() * otroNumero.getParteImaginaria() + this.getParteImaginaria() * this.getParteReal());
	}
	
	@Override
	public boolean equals(Object otroNumero) {
		if (otroNumero.getClass().getSimpleName().toLowerCase().equals("complejo")){
			
			Complejo temporal = (Complejo)otroNumero;
			
			if (this.getParteReal() == temporal.getParteReal() && this.getParteImaginaria() == temporal.getParteImaginaria())
				return true;				
		}
		return false;
	}
	
	public double modulo(){
		return Math.sqrt(
				this.getParteReal() * 
				this.getParteReal() + 
				this.getParteImaginaria() * 
				this.getParteImaginaria()
				);
	}
	
	public double getParteReal() {
		return parteReal;
	}
	
	public void setParteReal(double real) {
		this.parteReal = real;
	}
	
	public double getParteImaginaria() {
		return parteImaginaria;
	}
	
	public void setParteImaginaria(double imaginario) {
		this.parteImaginaria = imaginario;
	}
	
	@Override
	public String toString() {
		return getParteReal() + " + " + getParteImaginaria() + "i" + ", módulo: " + this.modulo() ;
	}

	//Método main para Testing de métodos
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrdenarComplejos oc = new OrdenarComplejos();
		oc.agregarElemento(new Complejo(1.0, 2));
		oc.agregarElemento(new Complejo(5.0, 1));
		oc.agregarElemento(new Complejo(3, 2));
		oc.agregarElemento(new Complejo(2.0, 5));
		
		System.out.println("ordenando por modulo");
		for (Complejo c : oc.ordenarPorModulo(true))
			System.out.println(c);
		
		System.out.println("ordenando por parte Real");
		for (Complejo c : oc.ordenarPorReal(true))
			System.out.println(c);
		
		System.out.println("ordenando por parte Imaginaria");
		for (Complejo c : oc.ordenarPorImaginario(true))
			System.out.println(c);
	}
}
