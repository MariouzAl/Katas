package com.katabankocr;

import java.util.ArrayList;

public class Digit {
	public static final String  CERO= 	 " _ " +"\n"+
			"| |" +"\n"+
			"|_|" +"\n"+
			"   ";

	public static final String  UNO= 	"   " +"\n"+
			"  |" +"\n"+
			"  |" +"\n"+
			"   "; 

	public static final String  DOS=  	" _ " +"\n"+
			" _|" +"\n"+
			"|_ " +"\n"+
			"   ";

	public static final String  TRES=  	" _ " +"\n"+
			" _|" +"\n"+
			" _|" +"\n"+
			"   ";
	public static final String  CUATRO=  "   " +"\n"+
			"|_|" +"\n"+
			"  |" +"\n"+
			"   ";

	public static final String  CINCO=  " _ " +"\n"+
			"|_ " +"\n"+
			" _|" +"\n"+
			"   ";
	public static final String  SEIS=   " _ " +"\n"+
			"|_ " +"\n"+
			"|_|" +"\n"+
			"   ";

	public static final String  SIETE=  " _ " +"\n"+
			"  |" +"\n"+
			"  |" +"\n"+
			"   ";
	public static final String  OCHO=  	" _ " +"\n"+
			"|_|" +"\n"+
			"|_|" +"\n"+
			"   ";
	public static final String  NUEVE=  " _ " +"\n"+
			"|_|" +"\n"+
			" _|" +"\n"+
			"   ";

	public static final int LINEAS_POR_DIGITO = 4;
	public static final int LINEAS_POR_DIGITO_SIN_ESPACIO = LINEAS_POR_DIGITO-1;

	public static final int COLUMNAS_POR_DIGITO = 3;

	private String LED;
	private char valor;

	public Digit(String cadenaLED) {
		this.setLED(cadenaLED);
		setValor(convertirAChar(cadenaLED));
	}

	public static char convertirAChar(String cadena) {
		if (UNO.equals(cadena)){
			return '1';
		}if (DOS.equals(cadena)){
			return '2';
		}if (TRES.equals(cadena)){
			return '3';
		}if (CUATRO.equals(cadena)){
			return '4';
		}if (CINCO.equals(cadena)){
			return '5';
		}if (SEIS.equals(cadena)){
			return '6';
		}if (SIETE.equals(cadena)){
			return '7';
		}if (OCHO.equals(cadena)){
			return '8';
		}if (NUEVE.equals(cadena)){
			return '9';
		}if (CERO.equals(cadena)){
			return '0';
		}else{
			return '?';
		}

	}




	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}

	public String getLED() {
		return LED;
	}
	char[][] matrizLED= new char[3][3];
	public void setLED(String lED) {
		LED = lED;
		convertirAMatrizLED(lED);
	}

	private void convertirAMatrizLED(String lED) {
		String[] lineas = lED.split("\n");
		for (int i = 0; i < LINEAS_POR_DIGITO-1; i++) {
			for (int j = 0; j < COLUMNAS_POR_DIGITO; j++) {
				matrizLED[i][j]=lineas[i].charAt(j);
			}
		}
	}

	public ArrayList<Digit> regeneraDigitoEnfermo() {
		
		ArrayList<Digit>digitosCandidatos = new ArrayList<Digit>();
		for (int i = 0; i < Digit.COLUMNAS_POR_DIGITO; i++) {
			for (int j = 0; j < Digit.LINEAS_POR_DIGITO_SIN_ESPACIO; j++) {
				Digit digito =intercambiaCaracter(i,j);
				if (digito.getValor()!='?') {
					digitosCandidatos.add(digito);
				}
			}
		}
		
		return digitosCandidatos;
	}

	private Digit intercambiaCaracter(int i, int j) {
		Digit digitoClon = null;
		digitoClon= clone(this);
		char caracterAIntercabiar =digitoClon.matrizLED[i][j];
		if(j%2==0){
			digitoClon.matrizLED[i][j]=caracterAIntercabiar==' '?'|':' ';
		}else{
			digitoClon.matrizLED[i][j]=caracterAIntercabiar==' '?'_':' ';
		}
		digitoClon.setLED(generaCadenaLED(digitoClon.matrizLED));
		digitoClon.setValor(convertirAChar(digitoClon.getLED()));
		return digitoClon;
	}

	private String generaCadenaLED(char[][] matrizLED) {
		String cadenaLED = new String();
		for (int i = 0; i < matrizLED.length; i++) {
			for (int j = 0; j < matrizLED[i].length; j++) {
				cadenaLED+=matrizLED[i][j];
			}
			cadenaLED+="\n";
		}
		cadenaLED+="   ";
		return cadenaLED;

	}
	public static Digit clone(Digit digit){

		return new Digit(digit.getLED());

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getLED();
	}
}

