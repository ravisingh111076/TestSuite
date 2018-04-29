package com.ide2e.TestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ide2e.core.UnknownFileException;
import com.ide2e.service.FileSearchService;

import java.util.logging.Logger;

public class RepositoryServiceTest {

	Logger log = Logger.getLogger(RepositoryServiceTest.class.getName());
	
	FileSearchService service;
	
	@Before
	public void setUp() {
	    log.info("Configuring test data");
	    service = new FileSearchService(); 
	}

	@Test
	public void testFindAll() {
		log.info("Executing test... ");
	}
	
	@Test
	public void testFindAll_EmptyMimeType() {
		log.info("Executing test... ");
		service.findAll();	
	}
}
