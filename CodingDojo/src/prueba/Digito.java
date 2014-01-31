package prueba;

public class Digito {
	
	public static final String UNO="   "+"\n"+
								   "  |"+"\n"+	
								   "  |"+"\n"+	
								   "   "	;
	
	public static final String DOS =" _ "+"\n"+
									" _|"+"\n"+	
									"|_ "+"\n"+	
									"   "	;
	
	public static final String TRES =" _ "+"\n"+
									 " _|"+"\n"+	
									 " _|"+"\n"+	
									 "   "	;
	
	public static final String CUATRO = "   "+"\n"+
		       "|_|"+"\n"+	
		       "  |"+"\n"+	
		       "   "	; 
	
	public static final String CINCO= " _ "+"\n"+
		       "|_ "+"\n"+	
		       " _|"+"\n"+	
		       "   "	;

	public static final String SEIS="  _"+"\n"+
			   						" |_"+"\n"+	
			   						" |_|"+"\n"+	
			   						"   "	;

public static final String SIETE =" _ "+"\n"+
								  " _|"+"\n"+	
								  "  | "+"\n"+	
							     "   "	;

public static final String OCHO=" _ "+"\n"+
				 				"|_|"+"\n"+	
				 				"|_|"+"\n"+	
				 				"   "	;

public static final String NUEVE =  " _ "+"\n"+
									"|_|"+"\n"+	
									"  |"+"\n"+	
									"   "	; 

public static final String CERO = " _ "+"\n"+
								  "| | "+"\n"+	
								  "|_|"+"\n"+	
								  "   "	;


public static String numeros[]= new String[]{CERO,UNO,DOS,TRES,CUATRO,CINCO,SEIS,SIETE,OCHO,NUEVE};
//	numeros[0]=CERO;
//	numeros[1]=UNO;
//	numeros[2]=DOS;
//	numeros[3]=TRES;
//	numeros[4]=CUATRO;
//	numeros[5]=CINCO;
//	numeros[6]=SEIS;
//	numeros[7]=SIETE;
//	numeros[8]=OCHO;
//	numeros[9]=NUEVE;
	
	public static char convierte3(String digito) {
		for(int c=0;c<10;c++){
			if(digito.compareTo(numeros[c])==0){
				return (char)(c+48);
			} 
		}
		return '?'; 
	} 

	public static String convierteCadena(String cadena) {
		// Separar en lineas
		String lineas[]=separarEnlineas(cadena);
		String num=""; 
		String resp="";
		for(int c=0;c<lineas[0].length();c+=3){
			num+=lineas[0].substring(c, c+3)+"\n";
			num+=lineas[1].substring(c, c+3)+"\n";
			num+=lineas[2].substring(c, c+3)+"\n";
			resp+=convierte3(num);
		}
		return resp;
	}

	private static String[] separarEnlineas(String cadena) {
		return cadena.split("\n");
	}
}
