package com.xavier.util;

import java.io.File;
import java.util.Locale;

/**
 * <p>字符串工具类</p>
 *
 * @author NewGr8Player
 */
public class StringUtil {

	private StringUtil() {
	}

	/**
	 * <p>判断字符串是否为空</p>
	 *
	 * @param str 验证字符串
	 * @return 为空返回<b> true </b>,否则返回<b> false </b>
	 */
	public static boolean isEmptyOrBlank(String str) {
		if (str == null) {
			return true;
		}
		int len = str.length();
		if (len == 0) {
			return true;
		}
		for (int i = 0; i < len; i++) {
			switch (str.charAt(i)) {
				case ' ':
				case '\t':
				case '\n':
				case '\r':
				case '\b':/* 根据场景确认是否启用该项 */
				case '\f':/* 根据场景确认是否启用该项 */
					break;
				default:
					return false;
			}
		}
		return true;
	}

	/**
	 * <p>判断字符串是否不为空</p>
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyOrBlank(String str) {
		return !isEmptyOrBlank(str);
	}

	/**
	 * <p>包路径转换为文件路径</p>
	 *
	 * @param packagepath
	 * @return
	 */
	public static String packagePathToFilePath(String packagepath) {
		String result = null;
		if (packagepath != null) {
			result = packagepath.replace(".", File.separator);
		}
		return result;
	}

	/**
	 * <p>转换为Unicode字符</p>
	 *
	 * @param s
	 * @return
	 */
	public static String toUnicodeString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				sb.append("\\u" + Integer.toHexString(c));
			}
		}
		return sb.toString();
	}

	/**
	 * <p>驼峰命名转换</p>
	 *
	 * @param inputString
	 * @param firstCharacterUppercase
	 * @return
	 */
	public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
		StringBuilder sb = new StringBuilder();
		boolean nextUpperCase = false;
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			switch (c) {
				case '_':
				case '-':
				case '@':
				case '$':
				case '#':
				case ' ':
				case '/':
				case '&':
					if (sb.length() > 0) {
						nextUpperCase = true;
					}
					break;
				default:
					if (nextUpperCase) {
						sb.append(Character.toUpperCase(c));
						nextUpperCase = false;
					} else {
						sb.append(c);
					}
					break;
			}
		}
		if (firstCharacterUppercase) {
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		}
		return sb.toString();
	}

	/**
	 * <p>标准化属性名</p>
	 *
	 * @param inputString
	 * @return
	 */
	public static String getValidPropertyName(String inputString) {
		String answer;
		if (inputString == null) {
			answer = null;
		} else if (inputString.length() < 2) {
			answer = inputString.toLowerCase(Locale.US);
		} else {
			if (Character.isUpperCase(inputString.charAt(0)) && !Character.isUpperCase(inputString.charAt(1))) {
				answer = inputString.substring(0, 1).toLowerCase(Locale.US) + inputString.substring(1);
			} else {
				answer = inputString;
			}
		}

		return answer;
	}
}
