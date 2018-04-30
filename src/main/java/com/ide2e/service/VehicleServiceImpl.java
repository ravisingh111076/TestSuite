package com.ide2e.service;

import java.io.File;
import java.util.Set;
import java.util.logging.Logger;

import com.ide2e.core.CsvFileReader;

/**
 * Provides implementation for vehicle service. Consumes FileSearchService
 * retrieve all files builds vehicle data using Csv files. Similarly
 * ExcelFileReader can be used for reading data from excel. Ideally contains
 * based routing can be used to route data to different processor responsible
 * for reading different types of data.
 * 
 * @author ravisingh
 *
 */
public class VehicleServiceImpl implements VehicleService {

	Logger log = Logger.getLogger(VehicleServiceImpl.class.getName());

	SearchService service;

	public VehicleServiceImpl(SearchService service) {
		if (service == null) {
			log.info("SearchService is null");
			service = new FileSearchServiceImpl(new DirectoryServiceImpl());
		}
		this.service = service;
	}

	@Override
	public Set<VehicleData> getVehicles() {
		log.info("getVehicles called");
		Set<File> files = service.getSupportedFiles();
		CsvFileReader reader = new CsvFileReader();
		return reader.getVehicleData(files);
	}

	public void setService(SearchService service) {
		this.service = service;
	}

	public static void main(String[] ravi) {
		VehicleServiceImpl vehicleService = new VehicleServiceImpl(null);
		vehicleService.getVehicles();
	}
}
