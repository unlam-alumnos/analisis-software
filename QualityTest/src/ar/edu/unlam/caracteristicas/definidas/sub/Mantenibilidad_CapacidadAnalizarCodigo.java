package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Mantenibilidad_CapacidadAnalizarCodigo extends SubCaracteristica {

	public Mantenibilidad_CapacidadAnalizarCodigo(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad del código de ser analizado";
	}

	@Override
	public String getDescripcion() {
		return "Para evaluar la capacidad que tiene el código para ser analizado se tiene en cuenta el porcentaje de comentarios que posee el código por cada método y en general.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] 14% o menos del código comentado.",
				"Regular [1] Entre 15 y 29% del código comentado.",
				"Buena [2] 30% o más del código comentado."
			);
	}

}
