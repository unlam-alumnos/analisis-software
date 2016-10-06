package metricas;

public class ResultadoMetrica {

	private Metrica metrica;
	private String resultado;
	
	public ResultadoMetrica(Metrica metrica, String resultado) {
		this.metrica = metrica;
		this.resultado = resultado;
	}
	
	public String getNombre() {
		return this.metrica.getTipo().getDescripcion();
	}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
