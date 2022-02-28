package org.yeli;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberFormatterTest {

    @Test
    public void shouldFormatToFiveDecimals() {
        BigDecimal b = BigDecimal.valueOf(1234.5678910);
        String s = NumberFormatter.toFiveDecimals(b);
        assertEquals("1,234.56789", s );

        b = BigDecimal.valueOf(400000.00000);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("400,000", NumberFormatter.toFiveDecimals(b));

        b= BigDecimal.valueOf(4333222111.00001);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("4,333,222,111.00001", s);

        b= BigDecimal.valueOf(4333222111.001);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("4,333,222,111.00100", s);

        b = BigDecimal.valueOf(20000);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("20,000", NumberFormatter.toFiveDecimals(b));

        b = BigDecimal.valueOf(10367000.00);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("10,367,000", NumberFormatter.toFiveDecimals(b));

        b = BigDecimal.valueOf(1036700000.00);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("1,036,700,000", NumberFormatter.toFiveDecimals(b));

        b = BigDecimal.valueOf(1036700000.000123);
        s = NumberFormatter.toFiveDecimals(b);
        assertEquals("1,036,700,000.00012", NumberFormatter.toFiveDecimals(b));

        // this method will fail the following test
        b = BigDecimal.valueOf(1036700000.000003);
        assertEquals("1,036,700,000.00000", NumberFormatter.toFiveDecimals(b));
    }

    @Test
    public void shouldFormatBigDecimalsToFiveDecimalsWithNumberFormat() {
        BigDecimal b = new BigDecimal("1234.5678910");
        String s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("1,234.56789", s);

        b = BigDecimal.valueOf(400000.00000);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("400,000", s);

        b= BigDecimal.valueOf(4333222111.00001);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("4,333,222,111.00001", s);

        b= BigDecimal.valueOf(4333222111.001);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("4,333,222,111.001", s);

        b = BigDecimal.valueOf(20000);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("20,000", s);

        b = BigDecimal.valueOf(10367000.00);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("10,367,000", s);

        b = BigDecimal.valueOf(1036700000.00);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("1,036,700,000", s);

        b = BigDecimal.valueOf(1036700000.000123);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("1,036,700,000.00012", s);

        // this method will be successful for the following test
        b = BigDecimal.valueOf(1036700000.000003);
        s = NumberFormatter.toFiveDecimalsWithNumberFormat(b);
        assertEquals("1,036,700,000", s);
    }

    @Test
    public void shouldFormatDoubleToFiveDecimalsWithNumberFormat() {
        String s = NumberFormatter.toFiveDecimalsWithNumberFormat(1234.5678910);
        assertEquals("1,234.56789", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(400000.00000);
        assertEquals("400,000", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(4333222111.00001);
        assertEquals("4,333,222,111.00001", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(4333222111.001);
        assertEquals("4,333,222,111.001", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(20000);
        assertEquals("20,000", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(10367000.00);
        assertEquals("10,367,000", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(1036700000.00);
        assertEquals("1,036,700,000", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(1036700000.000123);
        assertEquals("1,036,700,000.00012", s);

        s = NumberFormatter.toFiveDecimalsWithNumberFormat(1036700000.000003);
        assertEquals("1,036,700,000", s);
    }
}
