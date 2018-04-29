package com.ide2e.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.ide2e.common.Config;

public class DirectoryServiceImpl implements DirectoryService {
	
	public Stream<Path> getAllFiles() {
		try {
			return Files.list(Paths.get(Config.rootFolder)).filter(Files::isRegularFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
