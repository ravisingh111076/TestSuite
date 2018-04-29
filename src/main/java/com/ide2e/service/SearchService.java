package com.ide2e.service;

import java.util.Set;
import com.ide2e.core.FileProperty;

public interface SearchService {

	public Set<FileProperty> findAll();
	
	public Set<FileProperty> findAllSupportedFiles();
}
