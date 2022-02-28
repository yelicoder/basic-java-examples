package org.yeli;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

public class NumberFormatter {

    public static String simpleToString(BigDecimal b) {
        return b.toString();
    }

    public static String toPlanString(BigDecimal b) {
        return b.toPlainString();
    }

    public static String toFiveDecimals(BigDecimal b) {

        String formattedString = "";
        String s = b.toPlainString();
        int length = s.lastIndexOf('.');
        String subString = s.substring(length+1);
        Long decimalValue = Long.parseLong(subString);

        if (decimalValue>0 && length !=-1) {
            formattedString=String.format("%,.5f", b);
        } else {
            formattedString = String.format("%,.0f", b);
        }
        return formattedString;
    }

    public static String toFiveDecimalsWithNumberFormat(Object b) {

        DecimalFormat formatter = new DecimalFormat();
        try {
            formatter = (DecimalFormat) NumberFormat.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        formatter.applyPattern("###,###.#####");

        StringBuffer sb = new StringBuffer();
        FieldPosition fp = new FieldPosition(NumberFormat.FRACTION_FIELD);
        formatter.format(b, sb, fp);
        return sb.toString();
    }
}
