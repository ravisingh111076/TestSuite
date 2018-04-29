package com.ide2e.TestSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.ide2e.core.FileProperty;
import com.ide2e.service.DirectoryService;
import com.ide2e.service.FileSearchService;

import java.io.File;
import java.nio.file.Path;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class RepositoryServiceTest {

	Logger log = Logger.getLogger(RepositoryServiceTest.class.getName());

	FileSearchService service;

	@Before
	public void setUp() {

		log.info("Configuring test data");

		// mocking directoryService..
		// providing test for business service only
		Path path1 = mock(Path.class);
		File file1 = mock(File.class);
		when(file1.getName()).thenReturn("first.txt");
		
		when(file1.length()).thenReturn(2L);
		when(path1.toFile()).thenReturn(file1);
		
		//file 2
		Path path2 = mock(Path.class);
		File file2 = mock(File.class);
		when(file2.getName()).thenReturn("a.xlsx");
		when(file2.length()).thenReturn(100L);
		when(path2.toFile()).thenReturn(file2);
		
		Path path3 = mock(Path.class);
		File file3 = mock(File.class);
		when(file3.getName()).thenReturn("third.csv");
		when(file3.length()).thenReturn(100L);
		when(path3.toFile()).thenReturn(file3);
		
		Path path4 = mock(Path.class);
		File file4 = mock(File.class);
		when(file4.getName()).thenReturn("assas.xyz");
		when(file4.length()).thenReturn(200L);
	    when(path4.toFile()).thenReturn(file4);
		
		service = new FileSearchService(new DirectoryService() {
			@Override
			public Stream<Path> getAllFiles() {
				return Stream.of(path1,path2,path3,path4);
			}
		});
	}

	@Test
	public void testFindAll() {
		log.info("Executing test... ");
		assertEquals(4, service.findAll().size());
	}

	@Test
	public void testFindAll_SupportedMimeType() {
		
		log.info("Executing test... ");
		 Set<FileProperty> result =service.findAllSupportedFiles();
		assertEquals(2, result.size());
		result.forEach(a -> assertTrue(a.getFileExtension().equals("xlsx") 
				|| a.getFileExtension().equals("csv")));
	}
}
