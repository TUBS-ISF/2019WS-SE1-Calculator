package de.tubs.se1.CAL;

public class Value {

	Integer value;

	public Value(int value) {
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	public int getValue() {
		return value.intValue();
	}
}
