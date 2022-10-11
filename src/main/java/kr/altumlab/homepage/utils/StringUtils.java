package kr.altumlab.homepage.utils;

import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;

public class StringUtils {
	public static DecimalFormat AMOUNT_FORMAT = new DecimalFormat("###,##0");

    /**
     * 생성자
     */
    private StringUtils() {}

	public static String addComma(Object val) {
		if(ObjectUtils.isEmpty(val)) return "";
		return AMOUNT_FORMAT.format(val);
	}

}
