package org.vite.gateway.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberUtil {
    public static BigInteger toViteAmount(String rawAmount, int decimals) {
        return new BigDecimal(rawAmount).movePointRight(decimals).toBigInteger();
    }

    public static String toViteAmount(Double rawAmount, int decimals) {
        if (rawAmount == null) {
            return null;
        }
        return BigDecimal.valueOf(rawAmount).movePointRight(decimals).toPlainString();
    }

    public static String fromViteAmount(BigInteger viteAmount, int decimals) {
        return new BigDecimal(viteAmount).movePointLeft(decimals).toPlainString();
    }
}
