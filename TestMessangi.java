package messangi;

import java.util.ArrayList;

public class TestMessangi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla culpa qui officia deserunt mollit anim id est laborum.";
		try {
			ArrayList<String> textoASegmentar= TestMessangi.segment(texto, 160);
			for(String textoSegmentado: textoASegmentar) {
				System.out.println(textoSegmentado.length()+": "+textoSegmentado);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> segment(String texto, int maxLength) throws Exception{
		if(maxLength <= 50 || maxLength >=5000 ) throw new ArithmeticException("Debe de estar entre 50 o 5000 caracteres");
		if(texto == null) throw new Exception("El texto no puede ser nulo");
		ArrayList<String> resultado = new ArrayList<>();
		StringBuilder segmentoActual = new StringBuilder();
		String [] palabras = texto.split(" ");
		
		for(String palabra:palabras) {
			if(segmentoActual.length() + palabra.length() <= maxLength) {
				segmentoActual.append(palabra).append(" ");
			}else {
				if(!segmentoActual.isEmpty()) resultado.add(segmentoActual.toString().trim());
				segmentoActual = new StringBuilder(palabra).append(" ");
			}
		}
		if(!segmentoActual.isEmpty()) resultado.add(segmentoActual.toString().trim());
		return resultado;
	}

}
