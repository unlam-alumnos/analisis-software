package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Eficiencia_ComportamientoEnTiempo;
import ar.edu.unlam.caracteristicas.definidas.sub.Eficiencia_UtilizacionRecursos;

public class Eficiencia extends Caracteristica {

	@Override
	public String getNombre() {
		return "Eficiencia";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Eficiencia_UtilizacionRecursos(this),
				new Eficiencia_ComportamientoEnTiempo(this)
			);
	}

}
