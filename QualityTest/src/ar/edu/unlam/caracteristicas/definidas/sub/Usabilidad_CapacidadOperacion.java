package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Usabilidad_CapacidadOperacion extends SubCaracteristica {

	public Usabilidad_CapacidadOperacion(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad para ser Operado";
	}

	@Override
	public String getDescripcion() {
		return "Es la Capacidad del producto software de ser utilizado sin asistencia adicional. Se valúa qué requiere el usuario para operar correctamente el producto.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] El usuario requiere consultar al personal especializado para operar el producto software.",
				"Regular [1] El usuario requiere ayuda contextual y manual de uso para operar el producto software.",
				"Buena [2] El usuario opera el producto software sin asistencia."
			);
	}

}
