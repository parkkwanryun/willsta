package com.itwill.willsta.domain;

public class StaticProperties {
	private static String postRealPath;

	
	
	public static String getPostRealPath() {
		return postRealPath;
	}

	public static void setPostRealPath(String postRealPath) {
		StaticProperties.postRealPath = postRealPath;
	}
	
	
}
