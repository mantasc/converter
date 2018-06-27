package converter.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.junit.Test;

import converter.CurrencyRateMap;

public class CurrencyRateMapTest {

	@Test
	public void testNormal() {

		Stream<String> stringStream = Stream.of("A,0.1", "B,0.2", "C,0.3", "", "test");
		CurrencyRateMap cr = CurrencyRateMap.fromStringStream(stringStream);

		assertEquals(new BigDecimal("0.1"), cr.getRate("A"));
		assertEquals(new BigDecimal("0.2"), cr.getRate("B"));
		assertEquals(new BigDecimal("0.3"), cr.getRate("C"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testError() {

		Stream<String> stringStream = Stream.of("A,1", "B,2", "C,3", "", "test");
		CurrencyRateMap cr = CurrencyRateMap.fromStringStream(stringStream);
		cr.getRate("X");

	}

}
