package tp4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {
	public List<List<Ficha>> tablero = new ArrayList() ;
	private int altura;
	public EstadoTurno turno;
	public int base;
	public ModoJuego modoJuego;

	public Linea(int base, int altura, char c) {
		this.turno= new RedJuega(this);
		this.altura = altura;
		this.base = base;
		this.modoJuego= ModoJuego.getModoJuego(c);
		int i;
		 for (i = 0; i < base; i++) {
	            tablero.add(new ArrayList<>(altura));
	          }
		
	}
	
	public void playBlueAt(int x) {
		if (x <= 0 || tablero.get(x-1).size()== altura|| x>base) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
		turno.juegaAzul(x);
			
					
	}

	public void playRedkAt(int x) {
		if (x <= 0 || tablero.get(x-1).size()== altura|| x>base) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);
		}
		turno.juegaRojo(x);
		
	}
		
	public Ficha getItem(int x, int y) {
		if (x <= 0 || y<= 0 || x>base|| y>altura) {
	        throw new IndexOutOfBoundsException("Invalid index: " + x);

		}
		return tablero.get(x-1).get (y-1);
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
		modoJuego.gameWon(x,this);
	}

	public void juegaRojo() {
		turno= new RedJuega(this);
		
	}

	public void putRedFicha(int x) {
		tablero.get(x-1).add(new RedFicha());
		modoJuego.gameWon(x,this);
		
	}
	
	
	public void gameWon(int x) {
		modoJuego.gameWon(x, this);

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

	    long count = IntStream.range(0, base - 1)
	            .filter(i -> tablero.get(i).size() > yIndex && tablero.get(i + 1).size() > yIndex)
	            .filter(i -> tablero.get(i).get(yIndex).equals(tablero.get(i + 1).get(yIndex)))
	            .count();

	    return count == 3;}
	
	
	public boolean isGameWonRightDiagonaly(int x) {
	    int count = 0;
	    int xIndex = x - 4;
	    int yIndex = tablero.get(x - 1).size() -4;

	    for (int i = 0; i < 8; i++) {
	        int currentX = xIndex + i;
	        int currentY = yIndex + i;

	        if (currentX >= 0 && currentY >= 0 && currentX<base-1) { 
	        		if (tablero.get(currentX).size() > currentY) {
	        				if(tablero.get(currentX+1).size() > currentY +1 ){
	        			if (tablero.get(currentX).get(currentY).equals(tablero.get(currentX+1).get(currentY+1))) {
	        				count++;

	        				if (count == 3) {
	                    return true;
	                }
	            } else {
	                count = 0;
	            }
	        } else {
	            count = 0;
	        }}}
	    }

	
		return false;
	}
	
	public boolean isGameWonLeftDiagonaly(int x) { // no funca
	    int count = 0;
	    int xIndex = x - 4; // 0
	    int yIndex = tablero.get(x - 1).size() +2 ; // 5

	    for (int i = 0; i < 8; i++) {
	        int currentX = xIndex + i;
	        int currentY = yIndex - i;

	        if (currentX >= 0 && currentY >= 1 && currentX < base-1) { 
	        		if (tablero.get(currentX).size() > currentY) {
	        				if(tablero.get(currentX+1).size() > currentY -1 ){
	        			if (tablero.get(currentX).get(currentY).equals(tablero.get(currentX+1).get(currentY-1))) {
	        				count++;
	        			    System.out.println( count);

	        				if (count == 3) {
	                    return true;
	                }
	            } else {
	                count = 0;
	            }
	        } else {
	            count = 0;
	        }}}
	    }

	
		return false;
	}
	public String show() {
	    StringBuilder diagram = new StringBuilder();

	    for (int i = altura - 1; i >= 0; i--) {
	        diagram.append("| ");

	        for (int j = 0; j < base; j++) {
	            List<Ficha> columna = tablero.get(j);

	            if (columna.size() > i) {
	                Ficha ficha = columna.get(i);
	                diagram.append(ficha instanceof RedFicha || ficha instanceof BlueFicha ? ficha.getRepresentation() + " " : " - ");
	            } else {
	                diagram.append("- ");
	            }
	        }
	        diagram.append(" |\n");
	    }

	    for (int j = 0; j < base; j++) {
	        diagram.append("  ^ ");
	    }

	    return diagram.toString();
	}


	public boolean gameWonTypeA(int x) {
		if (isGameWonVertical(x)||isGameWonHorizontal(x)){
			throw new RuntimeException("Ganaste bro");
			
	}
		return false;
}

	public boolean gameWonTypeB(int x) {
		if (isGameWonRightDiagonaly(x)||isGameWonLeftDiagonaly(x)){
			throw new RuntimeException("Ganaste bro");		
	}
		return false;}

	public boolean finished(int x) {
		return modoJuego.gameWon(x, this);
	}
	}


