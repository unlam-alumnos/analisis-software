package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Fiabilidad_CapacidadRecuperacionErrores;
import ar.edu.unlam.caracteristicas.definidas.sub.Fiabilidad_ToleranciaFallos;

public class Fiabilidad extends Caracteristica {

	@Override
	public String getNombre() {
		return "Fiabilidad";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Fiabilidad_ToleranciaFallos(this),
				new Fiabilidad_CapacidadRecuperacionErrores(this)
			);
	}

}
