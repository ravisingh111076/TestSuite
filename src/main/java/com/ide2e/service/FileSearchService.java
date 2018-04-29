package com.ide2e.service;

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


public class FileSearchService implements RepositoryService {
	
	PropertyBuilder filePropertyBuilder = new PropertyBuilder();
	
	public Set<FileProperty> findAll() {
		Set<FileProperty> fileProperty = new HashSet<>();
		 try {
				Files.list(Paths.get(Config.rootFolder))
				.filter(Files::isRegularFile)
				.forEach(f -> {		
						fileProperty.add(filePropertyBuilder.buildFileProperty(f.toFile()));
				});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return fileProperty;		
	}
	
	private boolean isSupported(Path path) {
		return path.toString().endsWith("." + SupportedFiles.EXCEL.getMimeType())
				|| path.toString().endsWith("." + SupportedFiles.CSV.getMimeType());
			
	}
	
	public Set<FileProperty> findAllSupportedFiles() {
		
		Set<FileProperty> fileProperty = new HashSet<>();
		 try {
				Files.list(Paths.get(Config.rootFolder))
				.filter(Files::isRegularFile)
				.forEach(f -> {	
						if(isSupported(f)) {
							fileProperty.add(filePropertyBuilder.buildFileProperty(f.toFile()));
						}
			  });
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return fileProperty;
	}
}
