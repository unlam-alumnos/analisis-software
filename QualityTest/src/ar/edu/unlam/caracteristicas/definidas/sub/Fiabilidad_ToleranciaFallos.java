package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Fiabilidad_ToleranciaFallos extends SubCaracteristica {

	public Fiabilidad_ToleranciaFallos(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Tolerancia a Fallos";
	}

	@Override
	public String getDescripcion() {
		return "Es la capacidad del producto software de mantener la integridad de los datos cuando se producen fallas del sistema."
				+"\nCaracterísticas a medir:\n"
				+"Cuando sucede un error se protegen los datos procesados - Se realiza un log de actividades que el sistema estaba haciendo";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] No cumple con alguna característica.",
				"Regular [1] Cumple con 1 característica.",
				"Buena [2] Cumple con 2 características."
			);
	}

}
