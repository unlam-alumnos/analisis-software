package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Funcionalidad_ExactitudResultados;
import ar.edu.unlam.caracteristicas.definidas.sub.Funcionalidad_SeguridadAcceso;

public class Funcionalidad extends Caracteristica {

	@Override
	public String getNombre() {
		return "Funcionalidad";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Funcionalidad_SeguridadAcceso(this),
				new Funcionalidad_ExactitudResultados(this)
			);
	}

}
