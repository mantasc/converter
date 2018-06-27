package converter.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import converter.CurrencyConverter;
import converter.mock.CurrencyRateMap;

public class CurrencyConverterTest {
	private CurrencyConverter cc;

	@Before
	public void setUp() throws Exception {
		HashMap<String, BigDecimal> r = new HashMap<>();
		r.put("A", new BigDecimal("0.1"));
		r.put("B", new BigDecimal("0.2"));
		r.put("C", new BigDecimal("0.3"));

		CurrencyRateMap rate = new CurrencyRateMap(r);
		cc = new CurrencyConverter(rate);
	}

	@Test
	public void test() {
		BigDecimal result = cc.convert("A", "B", new BigDecimal("1"));
		assertEquals(new BigDecimal("0.5"), result);

	}

	@Test
	public void test2() {
		BigDecimal result = cc.convert("A", "C", new BigDecimal("1"));
		assertEquals(new BigDecimal("0.333333333333333333"), result);

	}

	@Test
	public void test3() {
		BigDecimal result = cc.convert("C", "B", new BigDecimal("1"));
		assertEquals(new BigDecimal("1.5"), result);

	}

}
