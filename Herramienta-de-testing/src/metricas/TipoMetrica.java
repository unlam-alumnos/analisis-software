package metricas;

public enum TipoMetrica {
	
	CantidadComentarios ("Cantidad de Comentarios"),
	CantidadLineas ("Cantidad de Líneas"),
	ComplejidadCiclomatica ("Complejidad Ciclomática"),
	Halstead ("Halstead"), 
	FanIn ("Fan In"),
	FanOut ("Fan Out");

	private String descripcion;
	
	private TipoMetrica(String descripcion){
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
