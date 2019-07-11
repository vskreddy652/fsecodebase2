package com.hackfse.giveaway.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {
	public static Boolean isNullOrEmpty(final Object obj) {
		return (null == obj) || (Constants.EMPTY_STRING.equals(obj));
	}
	
	public String writeListToJsonArray(List<Object[]> list) throws IOException {  
	    
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();

	    mapper.writeValue(out, list);

	    final byte[] data = out.toByteArray();
	    return new String(data);
	}
}
