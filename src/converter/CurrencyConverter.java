package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {
	private CurrencyRate currencyRate;

	public CurrencyConverter(CurrencyRate currencyRate) {
		this.currencyRate = currencyRate;
	}

	public BigDecimal convert(String currencyFrom, String currencyto, BigDecimal amount) {
		BigDecimal result = amount
				.multiply(currencyRate.getRate(currencyFrom))
				.divide(currencyRate.getRate(currencyto), 18, RoundingMode.HALF_UP)
				.stripTrailingZeros();
		return result;
	}

}
