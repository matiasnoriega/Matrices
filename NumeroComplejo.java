package ar.edu.uno.poo2.modulo;

public class NumeroComplejo {
	private double real;
	private double imaginario;
	
	public NumeroComplejo(double real, double imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}
	
	public void sumar(NumeroComplejo otroNumero){
		this.setReal(this.getReal()+otroNumero.getReal());
		this.setReal(this.getImaginario()+otroNumero.getImaginario());
	}
	
	public void sumar(Double otroNumero){
		NumeroComplejo numeroComplejo = new NumeroComplejo(otroNumero, 0);
		this.sumar(numeroComplejo);
	}
	
	public void restar(NumeroComplejo otroNumero){
		this.setReal(this.getReal()-otroNumero.getReal());
		this.setReal(this.getImaginario()-otroNumero.getImaginario());
	}
	public void multiplicar(NumeroComplejo otroNumero){
		this.setReal(this.getReal()*otroNumero.getReal()-this.getImaginario()*otroNumero.getImaginario());
		this.setImaginario(this.getReal()*otroNumero.getImaginario()+this.getImaginario()*this.getReal());
	}
	
	@Override
	public boolean equals(Object otroNumero) {
		if (otroNumero.getClass().getSimpleName()=="NumeroComplejo"){
			NumeroComplejo temporal=(NumeroComplejo)otroNumero;
			if (this.getReal()==temporal.getReal() && this.getImaginario()==temporal.getImaginario())
				return true;				
		}
		return false;
	}
	public double modulo(){
		return Math.sqrt(this.getReal()*this.getReal()+this.getImaginario()*this.getImaginario());
	}
	public double getReal() {
		return real;
	}
	public void setReal(double real) {
		this.real = real;
	}
	public double getImaginario() {
		return imaginario;
	}
	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}
	@Override
	public String toString() {
		return real + " + " + imaginario + "i";
	}
	
	
}
