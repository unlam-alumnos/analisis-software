package ar.edu.unlam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;
import ar.edu.unlam.caracteristicas.definidas.Eficiencia;
import ar.edu.unlam.caracteristicas.definidas.Fiabilidad;
import ar.edu.unlam.caracteristicas.definidas.Funcionalidad;

public class AlgoritmoCalidad {

	private List<Caracteristica> caracteristicas;
	private List<SubCaracteristica> subCaracteristicas;
	
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public List<SubCaracteristica> getSubCatacteristicas() {
		return subCaracteristicas;
	}

	public void cargar() {
		
		this.caracteristicas = Arrays.asList(
				new Funcionalidad(),
				new Eficiencia(),
				new Fiabilidad()
			);
		
		this.subCaracteristicas = new ArrayList<SubCaracteristica>();
		for(Caracteristica caract : this.caracteristicas){
			this.subCaracteristicas.addAll( caract.getSubCaracteristicas() );
		}
		
	}
	
}