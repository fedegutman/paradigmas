package tp4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {
	public List<List<Ficha>> tablero = new ArrayList() ;
	private int altura;
	public EstadoTurno turno;

	public Linea(int base, int altura, char c) {
		this.turno= new RedJuega(this);
		this.altura = altura;
		int i;
		int j;
		 for (i = 0; i < base; i++) {
	            tablero.add(new ArrayList<>(altura));
	          }
		
	}

	
	
	public void playBlueAt(int x) {
		if (x <= 0) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
		turno.juegaAzul(x);
			
					
	}

	public void playRedkAt(int x) {
		if (x <= 0 || tablero.get(x-1).size()== altura) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
		turno.juegaRojo(x);
		
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
	
	public boolean isGameDrawed() {
		 return tablero.stream().allMatch(lista -> lista.size() == altura);
		}
	
	public void drawGame() {
		if (isGameDrawed()) {
			throw new RuntimeException("Empataste bro");
		}
	}




	public void putBlueFicha(int x) {
		tablero.get(x-1).add(new BlueFicha());	
	}

	public void juegaRojo() {
		turno= new RedJuega(this);
	}



	public void putRedFicha(int x) {
		tablero.get(x-1).add(new RedFicha());
		
	}
	
	
	public void gameWon(int x) {
		if (isGameWonVertical(x)||isGameWonHorizontal(x) || isGameWonRightDiagonaly(x)) {
			throw new RuntimeException("Ganaste bro");
		}
	}


	public void juegaBlue() {
		turno = new BlueJuega(this);
	}
	
	public boolean isGameWonVertical(int x) {
	    int count = (int) IntStream.range(0, tablero.get(x - 1).size() - 1)
	            .filter(i -> tablero.get(x - 1).get(i).equals(tablero.get(x - 1).get(i + 1)))
	            .count();

	    return count == 3;
	}
	
	public boolean isGameWonHorizontal(int x) {
	    int yIndex = tablero.get(x - 1).size() - 1;

	    long count = IntStream.range(0, base() - 1)
	            .filter(i -> tablero.get(i).size() > yIndex && tablero.get(i + 1).size() > yIndex)
	            .filter(i -> tablero.get(i).get(yIndex).equals(tablero.get(i + 1).get(yIndex)))
	            .count();

	    return count == 3;}
	
	
	public boolean isGameWonRightDiagonaly (int x) {
		int yIndex = tablero.get(x - 1).size() - 1;
		int yIntercept= yIndex - x - 1;

	    long count = IntStream.range(0, base() - 1)
	    		.filter(i-> yIndex >= 4 )
	            .filter(i -> tablero.get(i).size() >= yIntercept && tablero.get(i + 1).size() > yIntercept + 1 )
	            .filter(i -> tablero.get(i).get(yIntercept).equals(tablero.get(i + 1).get(yIntercept + 1)))
	            .count();

	    return count == 3;
	}
	

	
}
	


