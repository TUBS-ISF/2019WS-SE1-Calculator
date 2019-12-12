package de.tubs.se1.calculator;

public abstract class Expression {

	public abstract int evaluate();

	public String computeEquation() {
		return toString() + " = " + evaluate();
	}
}
