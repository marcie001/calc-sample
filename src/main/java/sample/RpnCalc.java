package sample;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * 逆ポーランド記法電卓
 *
 * @author marcie
 */
public class RpnCalc implements Calculator {

	@Override
	public BigDecimal execute(String... expression) {
		Deque<BigDecimal> result = Stream.of(expression)
				.collect(
						() -> new ArrayDeque<BigDecimal>(),
						(acc, elm) -> {
							BigDecimal a;
							BigDecimal b;
							switch (elm) {
								case "+":
									b = acc.pop();
									a = acc.pop();
									acc.push(a.add(b));
									break;
								case "-":
									b = acc.pop();
									a = acc.pop();
									acc.push(a.subtract(b));
									break;
								case "*":
									b = acc.pop();
									a = acc.pop();
									acc.push(a.multiply(b, Constants.MATH_CONTEXT));
									break;
								case "/":
									b = acc.pop();
									a = acc.pop();
									acc.push(a.divide(b, Constants.MATH_CONTEXT));
									break;
								default:
									acc.push(new BigDecimal(elm));
									break;
							}
						},
						(acc1, acc2) -> {
							throw new UnsupportedOperationException("パラレルはサポートしていません");
						}
				);
		if (result.size() != 1) {
			throw new IllegalArgumentException("式が不正です。");
		}
		return result.pop();
	}
}
