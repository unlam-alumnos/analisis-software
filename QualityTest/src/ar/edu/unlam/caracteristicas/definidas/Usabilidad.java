package ar.edu.unlam.caracteristicas.definidas;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.sub.Usabilidad_CapacidadAtractivo;
import ar.edu.unlam.caracteristicas.definidas.sub.Usabilidad_CapacidadEntendimiento;
import ar.edu.unlam.caracteristicas.definidas.sub.Usabilidad_CapacidadOperacion;

public class Usabilidad extends Caracteristica {

	@Override
	public String getNombre() {
		return "Usabilidad";
	}

	@Override
	protected List<SubCaracteristica> setSubCaracteristicas() {
		return Arrays.asList(
				new Usabilidad_CapacidadEntendimiento(this),
				new Usabilidad_CapacidadAtractivo(this),
				new Usabilidad_CapacidadOperacion(this)
			);
	}

}
