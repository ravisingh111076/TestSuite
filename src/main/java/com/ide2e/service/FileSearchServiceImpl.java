package com.ide2e.service;

import java.io.File;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ide2e.common.PropertyBuilder;
import com.ide2e.common.SupportedFiles;
import com.ide2e.core.FileProperty;

/**
 * Service provides find file property.
 * Implementation consumes directory service to fetch files from file system. 
 * @author ravisingh
 *
 */
public class FileSearchServiceImpl implements SearchService {

	Logger log = Logger.getLogger(FileSearchServiceImpl.class.getName());
	
	/*
	 * Builder used to create file property bean.
	 */
	PropertyBuilder filePropertyBuilder = new PropertyBuilder();

	/**
	 * Reference of directory service.
	 * Ideally can be injected as external dependency.
	 *
	 */
	DirectoryService directoryService;

	public FileSearchServiceImpl(DirectoryService dirService) {
		directoryService = dirService;
	}

	/**
	 * Implementation of findAll, returns all files under root directory
	 */
	public Set<FileProperty> findAll() {
		
		logMessage("calling find all");
		
		Set<FileProperty> fileProperty = new HashSet<>();
	
		//call directory Service.
		//in real world scenario this can be further de-couple with another layer of abstraction.
		//which can abstract away calling of service,and handling failure or fall back.
		//essentially protecting service to cause failure.
		directoryService.getAllFiles().forEach(f -> {
			fileProperty.add(filePropertyBuilder.buildFileProperty(f.toFile()));
		});
		return fileProperty;
	}

	private boolean isSupported(File f) {
		return f.getName().endsWith("." + SupportedFiles.EXCEL.getMimeType())
				|| f.getName().endsWith("." + SupportedFiles.CSV.getMimeType());
	}

	public Set<FileProperty> findAllSupportedFiles() {
		logMessage("calling findAllSupportedFiles");
		Set<FileProperty> fileProperty = new HashSet<>();
		directoryService.getAllFiles().forEach(f -> {
			File file = f.toFile();
			if (isSupported(file)) {
				fileProperty.add(filePropertyBuilder.buildFileProperty(file));
			}
		});
		return fileProperty;
	}

	public Set<File> getSupportedFiles() {
		logMessage("calling getSupportedFiles");
		Set<File> files = new HashSet<>();
		directoryService.getAllFiles().forEach(f -> {
			File file = f.toFile();
			if (file.getName().endsWith("." + SupportedFiles.CSV.getMimeType())){
				files.add(file);
			}
		});
		return files;
	}
	// can be injected using DI framework
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}
	
	private void logMessage(String message) {
		if(log.isLoggable(Level.INFO))
			log.info(message);
	}	
}
