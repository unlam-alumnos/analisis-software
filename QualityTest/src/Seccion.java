import java.util.ArrayList;
import java.util.List;

public class Seccion {
	private List<SubSeccion> subSecciones;
	private String nombre;
	private double promedioSubSecciones;

	public Seccion(String nombre, List<SubSeccion> subSecciones) {
		super();
		this.subSecciones = subSecciones;
		this.nombre = nombre;
	}

	public List<SubSeccion> getSubSecciones() {
		return subSecciones;
	}

	public void setSubSecciones(List<SubSeccion> subSecciones) {
		this.subSecciones = subSecciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static Pair<List<Seccion>, Integer> cargarSecciones() {
		int posicion = 0;
		List<Seccion> result = new ArrayList<Seccion>();
		List<SubSeccion> subSecciones;
		List<String> respuestas;

		// carga de secciones de Funcionalidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con alguna caracter�stica.");
		respuestas.add("Cumple con 1 caracter�stica.");
		respuestas.add("Cumple con 2 caracter�sticas.");
		subSecciones
				.add(new SubSeccion(
						"Seguridad Acceso",
						"Capacidad del producto software para asegurar la integridad de los datos y la confidencialidad de estos.\nCaracter�sticas a medir:\n-Encriptaci�n de datos\n-Inicio de sesi�n de usuarios",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("Los resultados tienen un error del orden de 10^-3 o superior.");
		respuestas.add("Los resultados tienen un error del orden entre 10^-4y 10^-6");
		respuestas.add("Los resultados tienen un error del orden de10^-7 o inferior");
		subSecciones
				.add(new SubSeccion("Exactitud de resultados", "Es la capacidad del producto software para proporcionar los resultados con el grado necesario de precisi�n.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Funcionalidad", subSecciones));
		// fin de carga de secciones de funcionalidad

		// inicio de carga de secciones de Eficiencia
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("41% o m�s de uso de procesador.");
		respuestas.add("11% a 40% de uso de procesador.");
		respuestas.add("10% o menos de uso de procesador.");
		subSecciones.add(new SubSeccion("Utilizaci�n de Recursos", "Se evaluar� la eficiencia del producto software de acuerdo al porcentaje de uso de procesador que realice.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El producto est� 5 o m�s segundos sin informar al usuario del estado de la solicitud.");
		respuestas.add("El producto est� entre 2 y 4 segundos sin informar al usuario del estado de la solicitud.");
		respuestas.add("El producto est� menos de 1 segundo sin informar al usuario del estado de la solicitud.");
		subSecciones.add(new SubSeccion("Comportamiento en el tiempo",
				"Se evaluar� el tiempo que est� el producto software sin informarle al usuario del estado en que se encuentra la solicitud que realiz�.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Eficiencia", subSecciones));
		// fin de carga de eficiencia

		// inicio de carga de secciones de Fiabilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna caracter�stica.");
		respuestas.add("Cumple con 1 caracter�stica.");
		respuestas.add("Cumple con 2 caracter�sticas.");
		subSecciones
				.add(new SubSeccion(
						"Tolerencia a Fallos",
						"Es la capacidad del producto software de mantener la integridad de los datos cuando se producen fallas del sistema.\nCaracter�sticas a medir:\n -Cuando sucede un error se protegen los datos procesados.\n -Se realiza un log de actividades que el sistema estaba haciendo.",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna caracter�stica.");
		respuestas.add("Cumple con 1 caracter�stica.");
		respuestas.add("Cumple con 2 caracter�sticas.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de recuperaci�n de errores",
						"Es la capacidad del producto software de reanudar sus actividades cuando se producen errores cr�ticos.\nCaracter�sticas a medir:\n -El sistema reanuda las actividades si se produce una falla cr�tica.\n -Reanuda sus actividades y vuelve al estado en que estaba.",
						respuestas, posicion));
		posicion++;

		result.add(new Seccion("Fiabilidad", subSecciones));
		// fin de carga de secciones de Fiabilidad

		// inicio de carga de secciones de Mantenibilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("14% o menos dle codigo comentado.");
		respuestas.add("Entre 15% y 29% del codigo comentado.");
		respuestas.add("30% o m�s del c�digo comentado.");
		subSecciones.add(new SubSeccion("Capacidad del c�digo para ser analizado",
				"Para evaluar la capidad que tiene el c�digo para ser analizado se tiene en cuenta el porcentaje de comentarios que posee el c�digo por cada m�todo y en general.", respuestas,
				posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("La complejidad ciclom�tica es mayor o igual a 21.");
		respuestas.add("La complejidad ciclom�tica es entre 11 y 20.");
		respuestas.add("La complejidad ciclom�tica es menor o igual 10.");
		subSecciones.add(new SubSeccion("Capacidad del c�digo para ser cambiado",
				"Para evaluar la capacidad que tiene el c�digo para ser cambiado se tomar�n en cuenta la complejidad ciclom�tica del m�todo.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El software presenta un promedio de 5 o m�s errores por prueba.");
		respuestas.add("Ek software presenta un promedio entre 2 y 4 errores por prueba.");
		respuestas.add("El software presenta un promedio entre 0 y 1 error por prueba.");
		subSecciones.add(new SubSeccion("Estabilidad", "Para determinar la estabilidad del software se eval�a el promedio de fallas que presenta el producto por prueba.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Mantenibilidad", subSecciones));
		// fin de carga de secciones de Mantenibilidad

		// inicio de carga de secciones de Usabilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna caracter�stica.");
		respuestas.add("Cumple con 1 caracter�stica.");
		respuestas.add("Cumple con 2 caracter�sticas.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de ser entendido",
						"Capacidad del producto software, para ayudar a los usuarios ante una determinada situaci�n donde se necesite asistencia.\nCaracter�sticas a medir:\n-Posee ayuda contextual sobre men�s y botones de acci�n.\n-Manual de usuario incorporado al sistema como un men� dedicado",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El usuario requiere consultar a personal especializado para operar el producto software.");
		respuestas.add("El usuario requiere ayuda contextual y manual de uso para operar el producto software.");
		respuestas.add("El usuario opera el producto software sin asistencia.");
		subSecciones.add(new SubSeccion("Capacidad para ser operado",
				"Es la capacidad del producto software de ser utilizado sin asistencia adicional. Se val�a qu� requiere el usuario para operar correctamente el producto.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("6 o m�s pasos promedio sin organizaci�n de categor�a.");
		respuestas.add("Entre 3 y 5 pasos promedio y distribu�dos en categor�as.");
		respuestas.add("1 o 2 pasos promedio y distribu�dos en categor�as.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de ser atractivo para el usuario",
						"Es la agrupaci�n correcta de funcionalidad del producto software en su interfaz gr�fica, desde su agrupaci�n l�gica hasta el n�mero promeidio de pasos para alcanzar una funci�n o contenido espec�fico.",
						respuestas, posicion));
		posicion++;

		result.add(new Seccion("Usabilidad", subSecciones));
		// fin de carga de secciones de Usabilidad

		// inicio de carga de secciones de Portabilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("Compatible con 1 sistema operativo.");
		respuestas.add("Compatible con 2 sistemas operativos.");
		respuestas.add("Compatible con 3 o mas sistemas operativos.");
		subSecciones
				.add(new SubSeccion("Adaptabilidad", "Es la capacidad del producto software de adaptarse a diferentes sistemas operativos sin cambiar su estructura interna.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El producto se instala en 7 o m�s pasos.");
		respuestas.add("El producto se instala entre 4 y 6 pasos.");
		respuestas.add("El producto se instala en 3 o menos pasos.");
		subSecciones.add(new SubSeccion("Instalabilidad", "EL producto software debe poder ser instalado en una cantidad m�nima de pasos.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Portabilidad", subSecciones));
		// fin de carga de secciones de Portabilidad

		return new Pair<List<Seccion>, Integer>(result, posicion - 1);
	}

	public double getPromedioSubSecciones() {
		return promedioSubSecciones;
	}

	public void setPromedioSubSecciones(double promedioSubSecciones) {
		this.promedioSubSecciones = promedioSubSecciones;
	}

}
