package de.tubs.se1.calculator;

public class Value extends Expression {

	Integer value;

	public Value(int value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	public int evaluate() {
		return value.intValue();
	}
}
