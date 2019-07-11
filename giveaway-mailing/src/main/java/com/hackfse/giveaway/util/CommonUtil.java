package com.hackfse.giveaway.util;

public class CommonUtil {
	public static Boolean isNullOrEmpty(final Object obj) {
		return (null == obj) || (Constants.EMPTY_STRING.equals(obj));
	}
	
}
