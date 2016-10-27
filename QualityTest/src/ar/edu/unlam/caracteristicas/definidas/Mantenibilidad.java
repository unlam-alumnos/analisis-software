package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Mantenibilidad_CapacidadAnalizarCodigo;
import ar.edu.unlam.caracteristicas.definidas.sub.Mantenibilidad_CapacidadCambiarCodigo;
import ar.edu.unlam.caracteristicas.definidas.sub.Mantenibilidad_Estabilidad;

public class Mantenibilidad extends Caracteristica {

	@Override
	public String getNombre() {
		return "Mantenibilidad";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Mantenibilidad_CapacidadAnalizarCodigo(this),
				new Mantenibilidad_CapacidadCambiarCodigo(this),
				new Mantenibilidad_Estabilidad(this)
			);
	}

}
