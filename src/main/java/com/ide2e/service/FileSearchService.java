package com.ide2e.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.ide2e.common.Config;
import com.ide2e.common.PropertyBuilder;
import com.ide2e.common.SupportedFiles;
import com.ide2e.core.FileProperty;

public class FileSearchService implements SearchService {

	PropertyBuilder filePropertyBuilder = new PropertyBuilder();
	
	DirectoryService directoryService;
	
	public FileSearchService(DirectoryService dirService) {
		directoryService = dirService;
	}

	public Set<FileProperty> findAll() {
		Set<FileProperty> fileProperty = new HashSet<>();
		//Files.list(Paths.get(Config.rootFolder)).filter(Files::isRegularFile)
		directoryService.getAllFiles().forEach(f -> {
			fileProperty.add(filePropertyBuilder.buildFileProperty(f.toFile()));
		});
		return fileProperty;
	}

	private boolean isSupported(File f) {
		return f.getName().endsWith("." + SupportedFiles.EXCEL.getMimeType())
				|| f.getName().toString().endsWith("." + SupportedFiles.CSV.getMimeType());

	}

	public Set<FileProperty> findAllSupportedFiles() {

		Set<FileProperty> fileProperty = new HashSet<>();
		directoryService.getAllFiles().forEach(f -> {
			File file = f.toFile();
			if (isSupported(file)) {
				fileProperty.add(filePropertyBuilder.buildFileProperty(file));
			}
		});
		return fileProperty;
	}

	//can be injected using DI framework 
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}
}
