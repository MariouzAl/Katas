package com.katabankocr;

import java.text.DecimalFormat;
import java.util.Arrays;

public class SumChecker {

	

	private int checkSum ;
	
	private int verificaCheckSum(String string) {
		int suma=0;
		for (int j=string.length(),i = 0 ; i < string.length(); i++,j--) {
			suma+=Integer.valueOf(string.charAt(i)+"")*(j);
		}
		checkSum =suma;
		return checkSum;
	}


	private static String intToString(long ultimoregistro, int digits) {
		char[] zeros = new char[digits];
		Arrays.fill(zeros, '0');
		DecimalFormat df = new DecimalFormat(String.valueOf(zeros));
		return df.format(ultimoregistro);
	}

}
