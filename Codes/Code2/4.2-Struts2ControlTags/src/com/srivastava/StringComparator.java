package com.srivastava;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String param1, String param2) {
		return param1.compareToIgnoreCase(param2);
	}

}
