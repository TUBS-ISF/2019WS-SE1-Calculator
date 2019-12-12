package de.tubs.se1.calculator;

public class Add extends Expression {
	
	public Expression l, r;

	public Add(Expression l, Expression r) {
		this.l = l;
		this.r = r;
	}

	public String toString() {
		return l.toString() + " + " + r.toString();
	}

	public int evaluate() {
		return l.evaluate() + r.evaluate();
	}
}
