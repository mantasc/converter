package converter;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

	private static BigDecimal convert(String fileName, String from, String to, BigDecimal value) throws IOException {

		CurrencyRateMap rates = CurrencyRateMap.fromFile(fileName);
		CurrencyConverter cc = new CurrencyConverter(rates);
		BigDecimal result = cc.convert(from, to, value);
		return result;

	}

	public static void main(String[] args) {

		if (args.length < 4) {
			System.out.println("usage:");
			System.out.println("  java converter.Main <rate file> <currency from> <currency to> <amount>");
			System.out.println("example:");
			System.out.println("  java converter.Main data.csv USD EUR 10");

		} else {
			try {

				BigDecimal result = convert(args[0], args[1], args[2], new BigDecimal(args[3]));
				System.out.println(result);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
