package tp4;

import java.util.ArrayList;
import java.util.List;

public class Linea {
	private List<List<Ficha>> tablero = new ArrayList() ;
	private int altura;
	public EstadoTurno turno;
	public EstadoJuego estado ;

	public Linea(int base, int altura, char c) {
		this.turno= new RedJuega();
		this.altura = altura;
		this.estado = new NotFinished(); 
		int i;
		for (i = 0; i < base; i ++) {
			
			tablero.add(new ArrayList()) ;
		}
		
	}

	
	
	public void playBlueAt(int x) {
		if (x <= 0) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
			
			turno=turno.juegaAzul();
			tablero.get(x-1).add(new BlueFicha());
		
	}

	public void playRedkAt(int x) {
		if (x <= 0 || tablero.get(x-1).size()== altura) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
		turno=turno.juegaRojo();	
		tablero.get(x-1).add(new RedFicha());
		
			
		}
		
	public Ficha getItem(int x, int y) {
		if (x <= 0 || y<= 0 || x>base()|| y>altura) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);

		}
		return tablero.get(x-1).get (y-1);
	}


	public Integer base() {
		return tablero.size();
	}
	
	public boolean draw() {
		 return tablero.stream().allMatch(lista -> lista.size() == altura);
		}
	}
	
	


