public class Pair<T, U> {
	private T v1;
	private U v2;

	public Pair(T v1, U v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public T getV1() {
		return v1;
	}

	public void setV1(T v1) {
		this.v1 = v1;
	}

	public U getV2() {
		return v2;
	}

	public void setV2(U v2) {
		this.v2 = v2;
	}

}