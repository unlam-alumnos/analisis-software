package ar.edu.unlam.caracteristicas;
import java.util.List;

public abstract class Caracteristica {

	private List<SubCaracteristica> subCaracteristicas;
	
	public Caracteristica(){
		this.subCaracteristicas = this.setSubCaracteristicas();
	}
	
	public abstract String getNombre();
	protected abstract List<SubCaracteristica> setSubCaracteristicas();

	public List<SubCaracteristica> getSubCaracteristicas() {
		return subCaracteristicas;
	}
	
	public double getPromedio() {
		double aux = 0;
		for (SubCaracteristica subCaract : subCaracteristicas){
			aux += subCaract.getResult();
		}
		return aux / subCaracteristicas.size();
	}

}
