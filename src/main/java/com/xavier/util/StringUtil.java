package com.xavier.util;

public class StringUtil {

	public static final char UNDERLINE = '_';

	/**
	 * <p>驼峰命名转下划线</p>
	 *
	 * @param param Cameled-String
	 * @return Underlined-String
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i != 0) {
					sb.append(UNDERLINE);
				}
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * <p>下划线转驼峰</p>
	 *
	 * @param param              Underlined-String
	 * @param firstCharUpperCast true to upper case
	 * @return Cameled-String
	 */
	public static String underlineToCamel(String param, boolean firstCharUpperCast) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				if (i == 0 && firstCharUpperCast) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
