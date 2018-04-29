package com.ide2e.common;

public enum SupportedFiles {

	EXCEL("xlsx"),
	CSV("csv");
	
	public String getMimeType() {
		return mimeType;
	}

	private String mimeType;
	
	SupportedFiles(String mimeType) {
		this.mimeType=mimeType;
	}
}
