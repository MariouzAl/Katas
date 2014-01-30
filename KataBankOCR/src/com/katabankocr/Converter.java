package com.katabankocr;

import java.util.ArrayList;

public class Converter {
	private static final String ILL = " ILL";
	private static final String ERR = " ERR";


	public Converter() {}

	private enum StatusEntrada{
		ILL, ERR, OK
	}


	public String obtenValorEntrada(Entrada entrada){
		StatusEntrada status=obtenStatusDeLaEntrada(entrada);
		String solucion = new String();
		switch (status) {
		case ILL:
			solucion=ILL;
			break;
			//			solucion=intentaCurarEnfermedad(entrada);
			//			return solucion;
		case ERR:
			solucion=ERR;
			break;
			//			solucion=intentaCuadrarCheckSum(entrada);
			//			return solucion;
		default:
		}
		return entrada.getValorOriginal()+solucion;
	}

	private String intentaCuadrarCheckSum(Entrada entrada) {
		if(verificaCheckSum(entrada)){
			return entrada.getValor();	
		}
		return "ERR";
	}

	private String entradaEnIndice(int indiceEntrada, String[] lineas) {
		StringBuilder builder= new StringBuilder(); 
		String entradaLED=new String() ;
		int inicio = indiceEntrada*Digit.LINEAS_POR_DIGITO;
		int  tope=inicio+Digit.LINEAS_POR_DIGITO; 
		for (int i = inicio; i < tope; i++) {
			builder.append(lineas[i]+"\n");
		}
		builder.deleteCharAt(builder.length()-1);
		entradaLED=builder.toString();
		return entradaLED;
	}

	private String[] separaEnLineas(String archivoTexto) {
		String[]  lineas  = archivoTexto.split("\n");
		return lineas ;
	}
	public String convierte(String archivoTexto) {
		Entrada [] entradas = separaEnEntradas(archivoTexto);
		StringBuilder resultado=new StringBuilder();
		for (int i = 0; i < entradas.length; i++) {
			resultado.append(obtenValorEntrada(entradas[i])+"\n");
		}
		resultado.deleteCharAt(resultado.length()-1);
		return resultado.toString();
	}




	private Entrada[] separaEnEntradas(String archivoTexto) {
		String[] lineas = separaEnLineas(archivoTexto);
		int numeroEntradas = cuentaNumeroEntradas(lineas.length);
		Entrada [] entradas = new Entrada[numeroEntradas];
		for (int i=0; i < numeroEntradas; i++) {
			String string =entradaEnIndice(i, lineas);
			entradas[i]=new Entrada(string);
		}
		return entradas;
	}
	private int cuentaNumeroEntradas(int cantidadLineas) {
		return cantidadLineas/Digit.LINEAS_POR_DIGITO;
	}



	private StatusEntrada obtenStatusDeLaEntrada(Entrada entrada) {
		StatusEntrada status;
		int indiceDeDigitosCorrompidos=entrada.dameIndiceSiTieneDigitosCorrompidos().size();
		if (indiceDeDigitosCorrompidos>0){
			status= StatusEntrada.ILL;
		}else if(!verificaCheckSum(entrada)){
			status=StatusEntrada.ERR;
		}else{
			status=StatusEntrada.OK;
		}
		return status;
	}


	private String intentaCurarEnfermedad(Entrada entrada) {
		Entrada entradaClone= entrada;
		ArrayList<String> posiblesSoluciones = new ArrayList<>();
		StringBuilder diagnostico=new StringBuilder();
		ArrayList<Integer> indiceDigitoEnfermo=entrada.dameIndiceSiTieneDigitosCorrompidos();
		for (int i = 0; i < indiceDigitoEnfermo.size(); i++) {
			Digit digitoEnfermo=entradaClone.dameDigitoEn(indiceDigitoEnfermo.get(i));		
			ArrayList<Digit>posiblesDigitosCurados=digitoEnfermo.regeneraDigitoEnfermo();
			for (int j = 0; j < posiblesDigitosCurados.size(); j++) {
				Entrada nuevaEntrada= reemplazaDigitoEnIndice(posiblesDigitosCurados.get(j),indiceDigitoEnfermo.get(i),entradaClone);
				StatusEntrada status =obtenStatusDeLaEntrada(nuevaEntrada);

			}

		}

		if (posiblesSoluciones.size()>0){
			for (int i = 0; i < posiblesSoluciones.size(); i++) {
				diagnostico.append(posiblesSoluciones.get(i)+",");
			}
			diagnostico.deleteCharAt(diagnostico.length()-1);
		}else{
			diagnostico.append(entrada.getValorOriginal()+" ILL");
		}
		return diagnostico.toString();
	}







	private Entrada reemplazaDigitoEnIndice(Digit digit, int indice,Entrada registroClon) {
		registroClon.asignaDigitoEn(digit, indice);
		return registroClon;
	}









	private int checkSum ; 
	private boolean verificaCheckSum(Entrada entrada) {
		int suma=0;
		for (int j=Entrada.DIGITOS_POR_ENTRADA,i = 0 ; i < Entrada.DIGITOS_POR_ENTRADA; i++,j--) {
			suma+=Integer.valueOf(entrada.dameDigitoEn(i).getValor()+"")*(j);
		}
		checkSum =suma%11;
		return checkSum==0;
	}


}
