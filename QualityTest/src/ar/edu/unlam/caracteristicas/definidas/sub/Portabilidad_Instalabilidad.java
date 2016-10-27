package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Portabilidad_Instalabilidad extends SubCaracteristica {

	public Portabilidad_Instalabilidad(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Instalabilidad";
	}

	@Override
	public String getDescripcion() {
		return "El producto software debe poder ser instalado en una cantidad mínima de pasos.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] El producto se instala en 7 o más pasos.",
				"Regular [1] El producto se instala entre 4 y 6 pasos.",
				"Buena [2] El producto se instala en 3 o menos pasos."
			);
	}

}
