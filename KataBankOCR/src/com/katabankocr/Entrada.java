package com.katabankocr;

import java.util.ArrayList;

public class Entrada 
{
	public Entrada() {
	}
	public static final int DIGITOS_POR_ENTRADA = 9;
	public  static final String ILL = " ILL";
	public static final String ERR = " ERR";
	private Digit[] digitos;
	private String valorOriginal;
	private String valor;
	private String cadenaLED;

	public Entrada(String string) {
		this.cadenaLED=string;
		this.digitos = separaEnDigitos(string);
		this.valorOriginal=entradaAString(digitos);
		this.valor=this.valorOriginal;
	}



	private String entradaAString(Digit[] entrada) {
		String entradaString = new String();
		for (int i = 0; i < entrada.length; i++) {
			entradaString+=entrada[i].getValor();
		}
		return entradaString;
	}


	public Digit[] separaEnDigitos(String entradaString){
		Digit[] digitos=new Digit[DIGITOS_POR_ENTRADA];
		for (int i = 0; i < DIGITOS_POR_ENTRADA; i++) {
			Digit digitoLED = new Digit(digitoLEDEnIndice(i,entradaString));
			digitos[i]=digitoLED;
		}
		return digitos;
	}

	private String digitoLEDEnIndice(int index, String entradaProcesada) {
		String[] lineas  =   entradaProcesada.split("\n");
		int inicio = index*3;
		int tope = inicio+3;
		StringBuilder builder = new StringBuilder();  
		for (int j = 0; j < lineas.length; j++) {
			for (int i = inicio ; i < tope ; i++) {
				char c = lineas[j].charAt(i);
				builder.append(c);
			}	
			builder.append("\n");
		}
		builder.deleteCharAt(builder.length()-1);
		return builder.toString();
	}



	public String getValorOriginal() {
		return valorOriginal;
	}



	public Digit dameDigitoEn(int indice){
		return this.digitos[indice];
	}

	public void asignaDigitoEn(Digit digito, int indice){
		this.digitos[indice]=digito;
		this.valor=entradaAString(digitos);
		
	}


	public ArrayList<Integer> dameIndiceSiTieneDigitosCorrompidos(){
		ArrayList<Integer> indices=new ArrayList<>();
		for (int i = 0; i < digitos.length; i++) {
			if (digitos[i].getValor()=='?'){
				indices.add( i);
			}
		}
		return indices;

	}



	public String getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}



	public Entrada clona() {
		return new Entrada(cadenaLED);
	}



}
