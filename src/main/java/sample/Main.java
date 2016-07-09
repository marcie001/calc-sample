package sample;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String... args) {
		Calculator c = getCalculator(args);
		System.out.printf("%s = %s", Stream.of(args).collect(Collectors.joining(" ")), c.execute(args).toPlainString());
	}

	private static Calculator getCalculator(String... args) {
		if (Constants.OPERATORS.contains(args[0])) {
			return new PnCalc();
		} else if (Constants.OPERATORS.contains(args[args.length - 1])) {
			return new RpnCalc();
		}
		throw new IllegalArgumentException("式が不正です。");
	}

}
