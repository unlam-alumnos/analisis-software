package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Mantenibilidad_CapacidadCambiarCodigo extends SubCaracteristica {

	public Mantenibilidad_CapacidadCambiarCodigo(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad del código de ser cambiado";
	}

	@Override
	public String getDescripcion() {
		return "Para evaluar la capacidad que tiene el código para ser cambiado se tomará en cuenta la complejidad ciclomática del método. ";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] La complejidad ciclomática es mayor o igual a 21.",
				"Regular [1] La complejidad ciclomática es entre 11 y 20.",
				"Buena [2] La complejidad ciclomática es menor o igual a 10."
			);
	}

}
