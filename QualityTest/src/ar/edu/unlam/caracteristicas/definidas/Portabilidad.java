package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Portabilidad_Adaptabilidad;
import ar.edu.unlam.caracteristicas.definidas.sub.Portabilidad_Instalabilidad;

public class Portabilidad extends Caracteristica {

	@Override
	public String getNombre() {
		return "Portabilidad";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Portabilidad_Adaptabilidad(this),
				new Portabilidad_Instalabilidad(this)
			);
	}

}
