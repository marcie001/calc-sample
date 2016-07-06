package sample;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calc {

	public static void main(String... args) {
		System.out.printf("%s = %s", Stream.of(args).collect(Collectors.joining(" ")), calc(args).toPlainString());
	}

	public static BigDecimal calc(String... args) {
		Deque<BigDecimal> result = Stream.of(args)
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
									acc.push(a.multiply(b));
									break;
								case "/":
									b = acc.pop();
									a = acc.pop();
									acc.push(a.divide(b));
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
