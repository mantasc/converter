package converter.mock;

import java.math.BigDecimal;
import java.util.Map;

import converter.CurrencyRate;

public class CurrencyRateMap implements CurrencyRate {

	Map<String, BigDecimal> rates;

	public CurrencyRateMap(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	@Override
	public BigDecimal getRate(String currency) {
		return rates.get(currency);
	}

}
