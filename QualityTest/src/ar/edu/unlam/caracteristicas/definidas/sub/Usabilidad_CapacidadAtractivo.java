package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Usabilidad_CapacidadAtractivo extends SubCaracteristica {

	public Usabilidad_CapacidadAtractivo(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad de ser Atractivo para el Usuario";
	}

	@Override
	public String getDescripcion() {
		return "Es la agrupación correcta de funcionalidad del producto software en su interfaz gráfica, desde su agrupación lógica hasta el número promedio de pasos para alcanzar una función o contenido específico.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] 6 o más pasos promedio sin organización de categoría.",
				"Regular [1] Entre 3 y 5 pasos promedio y distribuidos en categorías.",
				"Buena [2] Entre 1 o 2 pasos promedio y distribuidos en categorías. "
			);
	}

}
