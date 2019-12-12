package de.tubs.se1.CAL;

public class Add {
	
	public Value l, r;

	public Add(Value l, Value r) {
		this.l = l;
		this.r = r;
	}

	public String toString() {
		return l.toString() + " + " + r.toString();
	}

	public int evaluate() {
		return l.getValue() + r.getValue();
	}

	public String computeEquation() {
		return toString() + " = " + evaluate();
	}
}
