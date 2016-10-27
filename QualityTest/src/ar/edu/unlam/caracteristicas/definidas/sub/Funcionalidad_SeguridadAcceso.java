package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Funcionalidad_SeguridadAcceso extends SubCaracteristica {

	public Funcionalidad_SeguridadAcceso(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Seguridad de acceso";
	}

	@Override
	public String getDescripcion() {
		return "Capacidad del producto software para asegurar la integridad de los datos y la confidencialidad de estos.\n"
				+"Características a medir:\n"
				+"Encriptación de datos - Inicio de sesión de usuarios";
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
