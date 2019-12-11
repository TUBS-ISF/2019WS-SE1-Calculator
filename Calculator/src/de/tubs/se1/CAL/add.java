package de.tubs.se1.CAL;
public class add {
	public VALUE l, r;
	public add(VALUE l, VALUE r) {
		this.l = l;
		this.r = r;
	}
	public String returnAStringRepresentionOfTheExpression() {
		return l.toString() + " + " + r.toString();
	}
	public int evaluatetheexpressiontoanintegervalue() {
		return l.getValue() + r.getValue();
	}
	public String computeAnEquationRepresentingTheExpressionAndItsValue() {
		return returnAStringRepresentionOfTheExpression() + " = " + evaluatetheexpressiontoanintegervalue();
	}
}
