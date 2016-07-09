/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.math.BigDecimal;

/**
 *
 * @author marcie
 */
public class Node {

	private String expression;

	private Node left;

	private Node right;

	public Node() {
	}

	public Node(String expression, Node left, Node right) {
		this.expression = expression;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * このノードが演算子かどうか判定する
	 *
	 * @return
	 */
	public boolean isOperator() {
		return Constants.OPERATORS.contains(getExpression());
	}

	/**
	 * このノードの計算処理を行う。まだ計算できないときは null を返す。
	 *
	 * @return
	 */
	public BigDecimal eval() {
		if (!isOperator()) {
			return new BigDecimal(getExpression());
		}
		BigDecimal a = getLeft().eval();
		if (a == null) {
			return null;
		}
		BigDecimal b = getRight().eval();
		if (b == null) {
			return null;
		}

		BigDecimal result = null;
		switch (getExpression()) {
			case "-":
				result = a.subtract(b);
				break;
			case "+":
				result = a.add(b);
				break;
			case "*":
				result = a.multiply(b, Constants.MATH_CONTEXT);
				break;
			case "/":
				result = a.divide(b, Constants.MATH_CONTEXT);
				break;
			default:
				throw new UnsupportedOperationException("演算子 " + getExpression() + " はサポートしていません。");
		}
		setExpression(result.toPlainString());
		return result;
	}

}
