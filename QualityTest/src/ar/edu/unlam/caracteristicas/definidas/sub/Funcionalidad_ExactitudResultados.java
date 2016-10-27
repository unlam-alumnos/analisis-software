package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Funcionalidad_ExactitudResultados extends SubCaracteristica {

	public Funcionalidad_ExactitudResultados(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Exactitud resultados";
	}

	@Override
	public String getDescripcion() {
		return "Capacidad del producto software para proporcionar los resultados con el grado necesario de precisión";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] Los resultados tienen un error del orden de 10^-3 o superior.",
				"Regular [1] Los resultados tienen un error del orden entre 10^-4 y 10^-6.",
				"Buena [2] Los resultados tienen un error del orden de 10^-7 o inferior."
			);
	}

}
