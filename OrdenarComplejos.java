package ar.edu.uno.poo2.modulo;

import java.util.ArrayList;
import java.util.Arrays;



public class OrdenarComplejos {
	
	private ArrayList<Complejo> elementos = null;
	
	public OrdenarComplejos() {
		elementos = new ArrayList<Complejo>();
	}
	
	public OrdenarComplejos(int cantidad) {
		elementos = new ArrayList<Complejo>(cantidad);
	}
	
	public void agregarElemento(Complejo numero) {
		elementos.add(numero);
	}
	
	public void limpiar() {
		elementos.removeAll(elementos);
	}
	
	public ArrayList<Complejo> ordenarPorModulo(boolean asc) {
		if (elementos.size() > 0) {
			int i = 0;
			Complejo[] temp = new Complejo[elementos.size()];
			for (Complejo c : elementos) {
				temp[i] = c;
				i++;
			}
			
			Complejo valorTemp;
			
			for(i = 0; i < temp.length - 1; i++) {
				for(int j = i + 1; j < temp.length; j++) {
					if (temp[j].modulo() < temp[i].modulo()) {
						valorTemp = temp[i];
						temp[i] = temp[j];
						temp[j] = valorTemp;
					}
				}
			}
			return new ArrayList<Complejo>(Arrays.asList(temp));
		}
		return null;
	}
	
	public ArrayList<Complejo> ordenarPorReal(boolean asc) {
		if (elementos.size() > 0) {
			int i = 0;
			Complejo[] temp = new Complejo[elementos.size()];
			for (Complejo c : elementos) {
				temp[i] = c;
				i++;
			}
			
			Complejo valorTemp;
			
			for(i = 0; i < temp.length - 1; i++) {
				for(int j = i + 1; j < temp.length; j++) {
					if (temp[j].getParteReal() < temp[i].getParteReal()) {
						valorTemp = temp[i];
						temp[i] = temp[j];
						temp[j] = valorTemp;
					}
				}
			}
			return new ArrayList<Complejo>(Arrays.asList(temp));
		}
		return null;
	}
	
	public ArrayList<Complejo> ordenarPorImaginario(boolean asc) {
		if (elementos.size() > 0) {
			int i = 0;
			Complejo[] temp = new Complejo[elementos.size()];
			for (Complejo c : elementos) {
				temp[i] = c;
				i++;
			}
			
			Complejo valorTemp;
			
			for(i = 0; i < temp.length - 1; i++) {
				for(int j = i + 1; j < temp.length; j++) {
					if (temp[j].getParteImaginaria() < temp[i].getParteImaginaria()) {
						valorTemp = temp[i];
						temp[i] = temp[j];
						temp[j] = valorTemp;
					}
				}
			}
			return new ArrayList<Complejo>(Arrays.asList(temp));
		}
		return null;
	}
	

}
