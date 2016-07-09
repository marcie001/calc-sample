/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ポーランド記法電卓
 *
 * @author marcie
 */
public class PnCalc implements Calculator {

	@Override
	public BigDecimal execute(String... expression) {
		Node tree = createTree(expression);

		Deque<Node> nodeStack = new ArrayDeque<>();
		nodeStack.push(tree);
		while (!nodeStack.isEmpty()) {
			Node node = nodeStack.pop();
			BigDecimal result = node.eval();
			if (result == null) {
				nodeStack.push(node);
				nodeStack.push(node.getRight());
				nodeStack.push(node.getLeft());
			}
		}

		return tree.eval();
	}

	protected Node createTree(String... args) {
		Node root = new Node(args[0], null, null);
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);

		for (int i = 1; i < args.length; i++) {
			String str = args[i];
			Node node = stack.pop();
			Node tmp = new Node(str, null, null);

			if (node.getLeft() == null) {
				node.setLeft(tmp);
				stack.push(node);
			} else if (node.getRight() == null) {
				node.setRight(tmp);
			} else {
				throw new IllegalArgumentException("式が不正です。");
			}

			if (tmp.isOperator()) {
				stack.push(tmp);
			}
		}

		return root;
	}

}
