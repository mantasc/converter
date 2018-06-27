package converter;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyRateMap implements CurrencyRate {
	private final static Pattern pattern = Pattern.compile(",");

	private Map<String, BigDecimal> rates;

	private CurrencyRateMap(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public static CurrencyRateMap fromStringStream(Stream<String> stringStream) {
		Map<String, BigDecimal> rates = stringStream
				.map(line -> pattern.split(line))
				.filter(lineColumns -> lineColumns.length == 2)
				.collect(Collectors.toMap(
						lineColumns -> lineColumns[0], 
						lineColumns -> new BigDecimal(lineColumns[1])));

		CurrencyRateMap cRates = new CurrencyRateMap(rates);
		return cRates;
	}

	public static CurrencyRateMap fromFile(String csvFile) throws IOException {
		Path path = Paths.get(csvFile);
		try (Stream<String> stringStream = Files.lines(path)) {
			return fromStringStream(stringStream);
		}
	}

	@Override
	public BigDecimal getRate(String currency) {
		BigDecimal result = rates.get(currency);
		if (result == null)
			throw new IllegalArgumentException("No Such Currency Rate: " + currency);
		return result;
	}

}
