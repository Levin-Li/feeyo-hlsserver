package com.feeyo.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	
	public static final String EMPTY_STR = "";
	public static final String[] EMPTY_STR_ARRAY = new String[0];

	/**
	 * �������ǲ���ȫ��Ϊ��ĸ(a~zA~Z)
	 * 
	 * @param input
	 * @return true��ʾȫ��Ϊ��ĸ(a~zA~Z)
	 */
	public static boolean isAlpha(CharSequence input) {
		if (input == null || input.length() == 0) {
			return false;
		}
		char ch;
		for (int i = input.length() - 1; i >= 0; i--) {
			ch = input.charAt(i);
			if (ch < 'A' || 'z' < ch || ('Z' < ch && ch < 'a')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ����ĸ��д
	 * 
	 * @param input
	 * @return
	 */
	public static String capitalize(String input) {
		int length;
		if (input == null || (length = input.length()) == 0) {
			return input;
		}
		char ch = input.charAt(0);
		char upCh = Character.toUpperCase(ch);
		if (ch == upCh) {
			return input;
		}
		char[] newChars = new char[length];
		newChars[0] = upCh;
		input.getChars(1, length, newChars, 1);
		return String.valueOf(newChars);
	}

	/**
	 * ��� �� null���߿��ַ��� �ͷ���true
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(CharSequence input) {
		return input == null || input.length() == 0;
	}

	/**
	 * �ָ��ַ���
	 * 
	 * @param input
	 * @param separator
	 * @param hasEmpty
	 *            �����Ƿ�����հ��ַ�
	 * @return
	 */
	public static String[] split(String input, char separator, boolean hasEmpty) {
		if (input == null) {
			return null;
		}

		int length = input.length();
		if (length == 0) {
			return EMPTY_STR_ARRAY;
		}
		List<String> tempStrs = new ArrayList<String>();
		/*
		 * ������ԣ���¼��ʼ��������ȡ�ַ���������������������
		 */
		int start = 0;
		int end = 0;
		boolean lastMatched = false;// �ϴ�ƥ�䵽��
		boolean match = false;
		while (end < length) {
			if (input.charAt(end) == separator) {
				if (match || hasEmpty) {
					tempStrs.add(input.substring(start, end));
					lastMatched = true;
					match = false;
				}
				start = ++end;
				continue;
			}
			lastMatched = false;
			match = true;
			end++;
		}
		if (match || hasEmpty && lastMatched) {
			tempStrs.add(input.substring(start, end));
		}
		return tempStrs.toArray(new String[tempStrs.size()]);
	}

	/**
	 * �ָ��ַ���,����ֵ�����հ��ַ�
	 * 
	 * @param input
	 * @param separator
	 *            �ָ��ַ�
	 * @return
	 */
	public static String[] split(String input, char separator) {
		return split(input, separator, true);
	}
}