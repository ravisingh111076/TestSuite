package com.ide2e.common;
import java.io.File;

import com.ide2e.core.FileProperty;

public class PropertyBuilder {
	
	public FileProperty buildFileProperty(File f) {
		//String fileName, String fileMimeType, String fileExtension, Long fileSize
		int extensionIndex = f.getName().lastIndexOf(".");
		String extension = f.getName().substring(extensionIndex + 1);
		return new FileProperty(f.getName(),extension, extension, f.length()/1024);
	}
}
