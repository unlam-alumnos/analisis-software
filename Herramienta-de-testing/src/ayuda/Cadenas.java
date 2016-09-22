package ayuda;

public class Cadenas {

	public static String normalizar(String linea){
		String lineaNormalizada = linea;
		
		//borrar comentarios
		if(linea.contains("//")){
			lineaNormalizada = lineaNormalizada.substring( 0, lineaNormalizada.indexOf("//") );
		}
		
		return lineaNormalizada
			.trim()
			.toLowerCase()
			.replaceAll("\\t", "")
			.replaceAll("\\n", "")
			//borrar todo entre comillas
			.replaceAll("\".*?\"", "\"\"")
			//aseguramos al menos un espacio antes y después de los siguientes caracteres
			.replaceAll("\\(", " ( ")
			.replaceAll("\\)", " ) ")
			.replaceAll("\\{", " { ")
			.replaceAll("\\}", " } ")
			.replaceAll("\\,", " , ")
			.replaceAll("\\;", " ; ")
			.replaceAll("\\&\\&", " && ")
			.replaceAll("\\|\\|", " || ")
			.replaceAll("\\?", " ? ")
			//unificar multiples espacios
			.replaceAll("( )+", " ");
	}
	
}
