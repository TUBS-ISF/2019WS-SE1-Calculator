package de.tubs.se1.calculator;

public class AddWithBrackets extends Add {

	public AddWithBrackets(Expression l, Expression r) {
		super(l, r);
	}
	
	public String toString() {
		return "(" + l.toString() + " + " + r.toString() + ")";
	}

}
