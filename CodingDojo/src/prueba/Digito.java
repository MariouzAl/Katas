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
								  "| |"+"\n"+	
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
	
	public static char convierteDigito(String digito) {
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
		int i;
		String resp=""; 
		int numEntrada=lineas.length/4;
		for(i=0;i<9;i++){
			
			resp+=digitoEnIndice(lineas, i, 0);
		}
		
		for(int j=1;j<numEntrada;j++){
			resp+='\n';
			for(i=0;i<9;i++){
				
				resp+=digitoEnIndice(lineas, i, j);
			}
			
		}
		return resp;
	} 
	
	private static char digitoEnIndice(String[] lineas, int i, int j) {
		String num="";
		int inicio = i*3;
		int tope = i*3+3;
		j*=4;
		num+=lineas[j+0].substring(inicio, tope)+"\n";
		num+=lineas[j+1].substring(inicio, tope)+"\n";
		num+=lineas[j+2].substring(inicio, tope)+"\n";
		num+=lineas[j+3].substring(inicio, tope);
		return convierteDigito(num);
	}

	private static String[] separarEnlineas(String cadena) {
		return cadena.split("\n");
	}
}
