package com.ide2e.TestSuite;

import com.ide2e.core.FileProperty;
import com.ide2e.service.DirectoryServiceImpl;
import com.ide2e.service.FileSearchService;

/**
 * Main class 
 *
 */
public class App {
	public static void main(String[] args) {
		FileSearchService service = new FileSearchService(new DirectoryServiceImpl());

		System.out.println(" Retrieving all supported files ...");
		service.findAllSupportedFiles().forEach(a -> printDetails(a));

		System.out.println(" Retrieving all files ...");
		service.findAll().forEach(a -> printDetails(a));
	}

	public static void printDetails(FileProperty p) {
		System.out.println("extension : " + p.getFileExtension());
		System.out.println("Name : " + p.getFileName());
	}
}
