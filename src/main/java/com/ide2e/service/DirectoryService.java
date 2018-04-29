package com.ide2e.service;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface DirectoryService {
    
	public Stream<Path> getAllFiles();

}
