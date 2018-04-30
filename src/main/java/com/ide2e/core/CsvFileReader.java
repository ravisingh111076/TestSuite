package com.ide2e.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.ide2e.service.VehicleData;

public class CsvFileReader {

	//This method needs several improvement to make sure vehicle data was created properly 
	//and incorrect data are handled properly
	//catch needs improvement to handle failure,
	public Set<VehicleData> getVehicleData(Set<File> files) {
		
		Set<VehicleData> vehicleData = new HashSet<>();
		files.forEach(f -> {
			try {
				Stream<String> stream = Files.lines(Paths.get(f.getAbsolutePath()));
				stream.forEach(s -> {
					System.out.println(s);
					String[] vehicleInfo = s.split(",");			
					vehicleData.add(new VehicleData(vehicleInfo[0], vehicleInfo[1],vehicleInfo[2]));
					});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return vehicleData;
	}
}
