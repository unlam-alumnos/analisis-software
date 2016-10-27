package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Eficiencia_UtilizacionRecursos extends SubCaracteristica {

	public Eficiencia_UtilizacionRecursos(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Utilización de Recursos";
	}

	@Override
	public String getDescripcion() {
		return "Se evaluará la eficiencia del producto software de acuerdo al porcentaje de uso de procesador que realice.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
			"Mala [0] 41% o más de uso de procesador.",
			"Regular [1] 11% a 40% de uso de procesador.",
			"Buena [2] 10% o menos de uso de procesador."
		);
	}

}
