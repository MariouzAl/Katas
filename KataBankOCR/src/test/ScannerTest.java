package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.katabankocr.Converter;
import com.katabankocr.Digit;
import com.katabankocr.SumChecker;

public class ScannerTest {

	String string_1_9 = 	"    _  _     _  _  _  _  _ "+"\n"+
			"  | _| _||_||_ |_   ||_||_|"+"\n"+
			"  ||_  _|  | _||_|  ||_| _|"+"\n"+
			"                           ";

	String string_0_8 = 	" _     _  _     _  _  _  _ "+"\n"+
			"| |  | _| _||_||_ |_   ||_|"+"\n"+
			"|_|  ||_  _|  | _||_|  ||_|"+"\n"+
			"                           ";

	String entradaValida_457508000=	"    _  _  _  _  _  _  _  _ "+"\n"+
			"|_||_   ||_ | ||_|| || || |"+"\n"+
			"  | _|  | _||_||_||_||_||_|"+"\n"+
			"                           ";
	String entradaEnferma="    _  _  _  _  _  _  _  _ "+"\n"+
			"|_||_   ||_   | _|| || || |"+"\n"+
			"  | _|  | _||_||_||_||_||_|"+"\n"+
			"                           ";

	private Converter converter;
	private String archivoTexto ;

	private Digit digit;
	@Before
	public void setup() {
		converter= new Converter();
	}
	@Test
	public void test_readDigit_0_9() {
		String digitLED= Digit.UNO;
		int expectedDigit=Digit.convertirAChar(digitLED);
		digit= new Digit(digitLED);
//		System.out.println(digit.getLED());
//		System.out.println(digit.getValor());
		assertEquals('1', digit.getValor());
		digitLED=  Digit.DOS;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('2', expectedDigit);
		digitLED=  Digit.TRES;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('3', expectedDigit);
		digitLED=  Digit.CUATRO;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('4', expectedDigit);
		digitLED=  Digit.CINCO;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('5', expectedDigit);
		digitLED=  Digit.SEIS;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('6', expectedDigit);
		digitLED=  Digit.SIETE;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('7', expectedDigit);
		digitLED=  Digit.OCHO;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('8', expectedDigit);
		digitLED=  Digit.NUEVE;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('9', expectedDigit);
		digitLED=  Digit.CERO;
		expectedDigit=Digit.convertirAChar(digitLED);
		assertEquals('0', expectedDigit);
	}

	@Test
	public void convertir_entrada_sencilla(){
		archivoTexto = string_1_9;
		converter  = new Converter ();
		assertEquals("123456789", converter.convierte(archivoTexto));
	}


	@Test
	public void test_convertir_entrada_multiple(){
		archivoTexto = string_1_9+"\n"+entradaValida_457508000;
		assertEquals("123456789\n" +
				"457508000", converter.convierte(archivoTexto));
	}


	

	@Test
	public void test_convertir_entrada_valida(){
		archivoTexto =entradaValida_457508000;
		converter  = new Converter ();
		assertEquals("457508000", converter.convierte(archivoTexto));
	}

	@Test
	public void test_convertir_entrada_erronea(){
		archivoTexto =" _  _     _  _        _  _ "+"\n"+
				"|_ |_ |_| _|  |  ||_||_||_ "+"\n"+
				"|_||_|  | _|  |  |  | _| _|"+"\n"+
				"                           ";
		converter  = new Converter ();
		assertEquals("664371495 ERR", converter.convierte(archivoTexto));
	}
	@Test
	public void test_un_digitoCorrompido(){
		archivoTexto ="    _  _     _  _  _  _  _ "+"\n"+
					  "  | _| _||_||_ |_   ||_||_|"+"\n"+
					  "  ||_ |_|  | _||_|  ||_| _|"+"\n"+
					  "                           ";
//		assertEquals("123456789", converter.convierte(archivoTexto));
		assertEquals("12?456789 ILL", converter.convierte(archivoTexto));
	}



	@Test
	public void test_dos_digitosCorrompido(){
		archivoTexto ="    _  _     _  _  _  _  _ "+"\n"+
					  "  | _| _||_||_ |_   ||_||_|"+"\n"+
					  "  ||_ |_|| | _||_|  ||_| _|"+"\n"+
					  "                           ";
//		assertEquals("123456789", converter.convierte(archivoTexto));
		assertEquals("12??56789 ILL", converter.convierte(archivoTexto));
	}


	@Test
	public void test_3_digitosCorrompido(){
		archivoTexto ="    _  _     _  _  _  _  _ "+"\n"+
					  "  | _| _||_||_ |_   ||_||_|"+"\n"+
					  "  ||_ |_|| | _ |_|  ||_| _|"+"\n"+
					  "                           ";
//		assertEquals("123456789", converter.convierte(archivoTexto));
		assertEquals("12???6789 ILL", converter.convierte(archivoTexto));
	}


	@Test
	public void test_1_digitoCorrompido_490867715(){
		archivoTexto ="    _  _  _  _  _  _     _ "+"\n"+
				"|_||_|| ||_||_   |  |  | _ "+"\n"+
				"  | _||_||_||_|  |  |  | _|"+"\n"+
				"                           ";
//		assertEquals("490867715", converter.convierte(archivoTexto));
		assertEquals("49086771? ILL", converter.convierte(archivoTexto));
	}

}

