package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Eficiencia_ComportamientoEnTiempo extends SubCaracteristica {

	public Eficiencia_ComportamientoEnTiempo(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Comportamiento en el Tiempo";
	}

	@Override
	public String getDescripcion() {
		return "Se evaluará el tiempo que está el producto software sin informarle al usuario del estado en que se encuentra la solicitud que realizó.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
			"Mala [0] El producto está más de 5 o más segundos sin informar al usuario del estado de la solicitud.",
			"Regular [1] El producto está entre 2 y 4 segundos sin informar al usuario del estado de la solicitud.",
			"Buena [2] El producto está menos de 1 segundo sin informar al usuario del estado de la solicitud."
		);
	}

}
