package test;

import static org.junit.Assert.*;

import org.junit.Test;

import prueba.Digito;

public class DigitoTest {

	@Test
	public void test_convierte_un_Digito1() {
		String digito ="   "+"\n"+
				       "  |"+"\n"+	
				       "  |"+"\n"+	
				       "   "	;
		
		assertEquals('1', Digito.convierte3(digito));

	}
	
	@Test
	public void test_convierte_un_Digito2() {
		String digito =" _ "+"\n"+
				       " _|"+"\n"+	
				       "|_ "+"\n"+	
				       "   "	;
		
		assertEquals('2', Digito.convierte3(digito));

	}
	
	@Test
	public void test_convierte_un_Digito3() {
		String digito =" _ "+"\n"+
						" _|"+"\n"+	
						" _|"+"\n"+	
						"   "	;
		
		assertEquals('3', Digito.convierte3(digito));

	}
	
	@Test
	public void test_convierte_un_Digito4() {
		String digito ="   "+"\n"+
				       "|_|"+"\n"+	
				       "  |"+"\n"+	
				       "   "	;
		
		assertEquals('4', Digito.convierte3(digito));

	}
	
	@Test
	public void test_convierte_un_Digito5() {
		String digito =" _ "+"\n"+
				       "|_ "+"\n"+	
				       " _|"+"\n"+	
				       "   "	;
		
		assertEquals('5', Digito.convierte3(digito));

	}
	
	@Test
	public void test_Convierte_Entrada_000000000(){
		String cadena = " _ "+" _ "+" _ "+" _ "+" _ "+" _ "+" _ "+" _ "+" _ "+"\n"+
						"| |"+"| |"+"| |"+"| |"+"| |"+"| |"+"| |"+"| |"+"| |"+"\n"+	
						"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"\n"+	
						"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   ";
		
		String cadena1 = " _ "+" _ "+" _ "+" _ "+" _ "+" _ "+" _ "+" _ "+"   "+"\n"+
						 "| |"+"| |"+"| |"+"|_|"+"| |"+"| |"+"| |"+"| |"+"  |"+"\n"+	
						 "|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"|_|"+"  |"+"\n"+	
						 "   "+"   "+"   "+"   "+"   "+"   "+"   "+"   "+"   ";
		
		assertEquals("000000000", Digito.convierteCadena(cadena) );
		assertEquals("000800001", Digito.convierteCadena(cadena1) );
	}
	
	
	

}
