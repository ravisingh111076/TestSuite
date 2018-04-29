package com.ide2e.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileDetails {

	//key =mimetype, value=fileproeprty
	private Map<String,Set<FileProperty>> files = new HashMap<>();

	public void add(FileProperty file) throws UnknownFileException {
		
		String fileMime = file.getFileMimeType();
		
		//mimetype can't be empty or null
		if(fileMime == null || fileMime.isEmpty()) {
			throw new UnknownFileException();
		}
		Set<FileProperty> setfiles = files.get(fileMime);
		
		//create new set to store file property
		if(setfiles == null) {
			setfiles = new HashSet<FileProperty>();
			files.put(file.getFileMimeType(), setfiles);
		}
		
		//add this file to set
		setfiles.add(file);
	}
	
	
}
