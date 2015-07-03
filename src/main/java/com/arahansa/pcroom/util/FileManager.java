package com.arahansa.pcroom.util;

import java.io.File;

public class FileManager {

	private static  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

	public static String getFilename(String pathname) {
		return classLoader.getResource(pathname).getFile();
	}

	public static File getFile(String pathname) {
		return new File(classLoader.getResource(pathname).getFile());
	}

}
