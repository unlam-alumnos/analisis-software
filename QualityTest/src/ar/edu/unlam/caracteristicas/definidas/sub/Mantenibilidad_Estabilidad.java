package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Mantenibilidad_Estabilidad extends SubCaracteristica {

	public Mantenibilidad_Estabilidad(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Estabilidad";
	}

	@Override
	public String getDescripcion() {
		return "Para determinar la estabilidad del software se evalúa el promedio de fallas que presenta el producto por prueba.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] El software presenta un promedio 5 o más errores por prueba.",
				"Regular [1] El software presenta un promedio entre 2 y 4 errores por prueba.",
				"Buena [2] El software presenta un promedio entre 0 y 1 error por prueba."
			);
	}

}
