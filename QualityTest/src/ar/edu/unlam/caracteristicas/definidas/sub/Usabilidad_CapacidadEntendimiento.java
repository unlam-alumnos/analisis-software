package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Usabilidad_CapacidadEntendimiento extends SubCaracteristica {

	public Usabilidad_CapacidadEntendimiento(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad de ser Entendido";
	}

	@Override
	public String getDescripcion() {
		return "Capacidad que posee el software, para ayudar a los usuarios ante una determinada situación donde se necesite asistencia."
				+"\nCaracterísticas a medir:"
				+"\nPosee ayuda contextual sobre menús y botones de acción. - Manual de usuario incorporado al sistema como un menú dedicado.";
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
