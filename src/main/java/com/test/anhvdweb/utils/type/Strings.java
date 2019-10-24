package com.test.anhvdweb.utils.type;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author anhvd
 */
public final class Strings {
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String replaces(String str, String pattern, String str2) {
        if(str == null) return null;
        Pattern p = compile(pattern); return p.matcher(str).replaceAll(str2);
    }

    public static boolean isEquals(final String s1, final String s2) {
        return isEquals(s1, s2, false);
    }

    public static boolean isEquals(String s1, String s2, boolean ic) {
        if(s1 == s2) return true;
        else if(s1 == null && s2 == null) return true;
        else if(s1 == null || s2 == null) return false;
        else return ic ? s1.equalsIgnoreCase(s2) : s1.equals(s2);
    }

    public static String trim(final String s) {
        return ((s == null) ? null : s.trim());
    }

    public static String trimToEmpty(String s) {
        if (s == null) return ""; return s.trim();
    }

    public static String trimToNull(String s) {
        s = trim(s); return isEmpty(s) ? null : s;
    }

    public static String nullToEmpty(String s) {
        return s == null ? "" : s;
    }

    public static String nullToEmpty(BigDecimal v) {
        return v == null ? "" : v.toPlainString();
    }
}
