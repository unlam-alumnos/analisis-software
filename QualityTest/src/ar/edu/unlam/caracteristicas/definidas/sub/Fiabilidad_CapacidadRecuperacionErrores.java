package ar.edu.unlam.caracteristicas.definidas.sub;

import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Fiabilidad_CapacidadRecuperacionErrores extends SubCaracteristica {

	public Fiabilidad_CapacidadRecuperacionErrores(Caracteristica caracteristica) {
		super(caracteristica);
	}

	@Override
	public String getNombre() {
		return "Capacidad de Recuperación de Errores";
	}

	@Override
	public String getDescripcion() {
		return "Es la capacidad del sistema de reanudar sus actividades cuando se producen errores críticos."
				+"\nCaracterísticas a medir:"
				+"\nEl sistema reanuda las actividades si se produce una falla crítica. - Reanuda sus actividades y vuelve al estado en que estaba.";
	}

	@Override
	public List<String> getRespuestas() {
		return Arrays.asList(
				"Mala [0] El sistema no se recupera del error.",
				"Regular [1] El sistema reanuda las actividades si se produce un error.",
				"Buena [2] El sistema vuelve al estado en que estaba al momento de producirse el error."
			);
	}

}
