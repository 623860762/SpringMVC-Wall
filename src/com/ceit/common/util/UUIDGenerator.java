package com.ceit.common.util;

import java.util.UUID;

public class UUIDGenerator {

	public static String getUUID32()
	{
		String uuid=UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
}
