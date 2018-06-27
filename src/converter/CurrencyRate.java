package converter;

import java.math.BigDecimal;

public interface CurrencyRate {
	public BigDecimal getRate(String currency);
}
