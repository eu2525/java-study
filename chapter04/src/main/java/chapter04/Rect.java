package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int y) {
		this.w = w;
		this.h = y;
	}

	@Override
	public int hashCode() {
		// h와 w를 기준으로 Hashing 한다는 뜻
//		return Objects.hash(h, w);
		// h * w 값을 기준으로 Hashing (같은 넓이이면 같은 해쉬값을 가짐)
		return Objects.hash(h * w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
//		return h == other.h && w == other.w;
		return h * w == other.h * other.w;
	}


	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}
	
}
