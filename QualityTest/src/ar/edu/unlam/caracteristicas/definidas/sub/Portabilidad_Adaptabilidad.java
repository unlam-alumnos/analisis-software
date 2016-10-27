package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Portabilidad_Adaptabilidad extends SubCaracteristica {

	public Portabilidad_Adaptabilidad(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Adaptabilidad";
	}

	@Override
	public String getDescripcion() {
		return "Es la capacidad del producto software de adaptarse a diferentes sistemas operativos sin cambiar su estructura interna.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] Compatible con 1 sistema operativo.",
				"Regular [1] Compatible con 2 sistemas operativos.",
				"Buena [2] Compatible con 3 o más sistemas operativos."
			);
	}

}
