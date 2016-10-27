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
		respuestas.add("No cumple con alguna característica.");
		respuestas.add("Cumple con 1 característica.");
		respuestas.add("Cumple con 2 características.");
		subSecciones
				.add(new SubSeccion(
						"Seguridad Acceso",
						"Capacidad del producto software para asegurar la integridad de los datos y la confidencialidad de estos.\nCaracterísticas a medir:\n-Encriptación de datos\n-Inicio de sesión de usuarios",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("Los resultados tienen un error del orden de 10^-3 o superior.");
		respuestas.add("Los resultados tienen un error del orden entre 10^-4y 10^-6");
		respuestas.add("Los resultados tienen un error del orden de10^-7 o inferior");
		subSecciones
				.add(new SubSeccion("Exactitud de resultados", "Es la capacidad del producto software para proporcionar los resultados con el grado necesario de precisión.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Funcionalidad", subSecciones));
		// fin de carga de secciones de funcionalidad

		// inicio de carga de secciones de Eficiencia
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("41% o más de uso de procesador.");
		respuestas.add("11% a 40% de uso de procesador.");
		respuestas.add("10% o menos de uso de procesador.");
		subSecciones.add(new SubSeccion("Utilización de Recursos", "Se evaluará la eficiencia del producto software de acuerdo al porcentaje de uso de procesador que realice.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El producto está 5 o más segundos sin informar al usuario del estado de la solicitud.");
		respuestas.add("El producto está entre 2 y 4 segundos sin informar al usuario del estado de la solicitud.");
		respuestas.add("El producto está menos de 1 segundo sin informar al usuario del estado de la solicitud.");
		subSecciones.add(new SubSeccion("Comportamiento en el tiempo",
				"Se evaluará el tiempo que está el producto software sin informarle al usuario del estado en que se encuentra la solicitud que realizó.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Eficiencia", subSecciones));
		// fin de carga de eficiencia

		// inicio de carga de secciones de Fiabilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna característica.");
		respuestas.add("Cumple con 1 característica.");
		respuestas.add("Cumple con 2 características.");
		subSecciones
				.add(new SubSeccion(
						"Tolerencia a Fallos",
						"Es la capacidad del producto software de mantener la integridad de los datos cuando se producen fallas del sistema.\nCaracterísticas a medir:\n -Cuando sucede un error se protegen los datos procesados.\n -Se realiza un log de actividades que el sistema estaba haciendo.",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna característica.");
		respuestas.add("Cumple con 1 característica.");
		respuestas.add("Cumple con 2 características.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de recuperación de errores",
						"Es la capacidad del producto software de reanudar sus actividades cuando se producen errores críticos.\nCaracterísticas a medir:\n -El sistema reanuda las actividades si se produce una falla crítica.\n -Reanuda sus actividades y vuelve al estado en que estaba.",
						respuestas, posicion));
		posicion++;

		result.add(new Seccion("Fiabilidad", subSecciones));
		// fin de carga de secciones de Fiabilidad

		// inicio de carga de secciones de Mantenibilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("14% o menos dle codigo comentado.");
		respuestas.add("Entre 15% y 29% del codigo comentado.");
		respuestas.add("30% o más del código comentado.");
		subSecciones.add(new SubSeccion("Capacidad del código para ser analizado",
				"Para evaluar la capidad que tiene el código para ser analizado se tiene en cuenta el porcentaje de comentarios que posee el código por cada método y en general.", respuestas,
				posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("La complejidad ciclomática es mayor o igual a 21.");
		respuestas.add("La complejidad ciclomática es entre 11 y 20.");
		respuestas.add("La complejidad ciclomática es menor o igual 10.");
		subSecciones.add(new SubSeccion("Capacidad del código para ser cambiado",
				"Para evaluar la capacidad que tiene el código para ser cambiado se tomarán en cuenta la complejidad ciclomática del método.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El software presenta un promedio de 5 o más errores por prueba.");
		respuestas.add("Ek software presenta un promedio entre 2 y 4 errores por prueba.");
		respuestas.add("El software presenta un promedio entre 0 y 1 error por prueba.");
		subSecciones.add(new SubSeccion("Estabilidad", "Para determinar la estabilidad del software se evalúa el promedio de fallas que presenta el producto por prueba.", respuestas, posicion));
		posicion++;

		result.add(new Seccion("Mantenibilidad", subSecciones));
		// fin de carga de secciones de Mantenibilidad

		// inicio de carga de secciones de Usabilidad
		subSecciones = new ArrayList<SubSeccion>();
		respuestas = new ArrayList<String>();
		respuestas.add("No cumple con ninguna característica.");
		respuestas.add("Cumple con 1 característica.");
		respuestas.add("Cumple con 2 características.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de ser entendido",
						"Capacidad del producto software, para ayudar a los usuarios ante una determinada situación donde se necesite asistencia.\nCaracterísticas a medir:\n-Posee ayuda contextual sobre menús y botones de acción.\n-Manual de usuario incorporado al sistema como un menú dedicado",
						respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("El usuario requiere consultar a personal especializado para operar el producto software.");
		respuestas.add("El usuario requiere ayuda contextual y manual de uso para operar el producto software.");
		respuestas.add("El usuario opera el producto software sin asistencia.");
		subSecciones.add(new SubSeccion("Capacidad para ser operado",
				"Es la capacidad del producto software de ser utilizado sin asistencia adicional. Se valúa qué requiere el usuario para operar correctamente el producto.", respuestas, posicion));
		posicion++;

		respuestas = new ArrayList<String>();
		respuestas.add("6 o más pasos promedio sin organización de categoría.");
		respuestas.add("Entre 3 y 5 pasos promedio y distribuídos en categorías.");
		respuestas.add("1 o 2 pasos promedio y distribuídos en categorías.");
		subSecciones
				.add(new SubSeccion(
						"Capacidad de ser atractivo para el usuario",
						"Es la agrupación correcta de funcionalidad del producto software en su interfaz gráfica, desde su agrupación lógica hasta el número promeidio de pasos para alcanzar una función o contenido específico.",
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
		respuestas.add("El producto se instala en 7 o más pasos.");
		respuestas.add("El producto se instala entre 4 y 6 pasos.");
		respuestas.add("El producto se instala en 3 o menos pasos.");
		subSecciones.add(new SubSeccion("Instalabilidad", "EL producto software debe poder ser instalado en una cantidad mínima de pasos.", respuestas, posicion));
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
