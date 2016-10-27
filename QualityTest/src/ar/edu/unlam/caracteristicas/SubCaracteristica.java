package ar.edu.unlam.caracteristicas;
import java.util.List;

public abstract class SubCaracteristica {
	
	private Caracteristica caracteristica;
	private Integer result;

	public SubCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public abstract String getNombre();
	public abstract String getDescripcion();
	public abstract List<String> getRespuestas();

	public void setResult(int result) {
		this.result = result;
	}

	public Integer getResult() {
		return result;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

}
