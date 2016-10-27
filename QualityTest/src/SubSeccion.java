import java.util.List;

public class SubSeccion {
	private String nombre;
	private String descripcion;
	private List<String> respuestas;
	private Integer result;
	private int posicion;

	public SubSeccion(String nombre, String descripcion, List<String> respuestas, int posicion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.respuestas = respuestas;
		this.result = null;
		this.posicion = posicion;
	}

	public int getPosicion() {
		return posicion;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Integer getResult() {
		return result;
	}

}
