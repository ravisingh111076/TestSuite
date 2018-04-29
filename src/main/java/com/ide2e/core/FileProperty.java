package com.ide2e.core;

/**
 * Holds file property.
 * 
 * @author ravisingh
 *
 */
public class FileProperty {

	public FileProperty(String fileName, String fileMimeType, String fileExtension, Long fileSize) {
		super();
		this.fileName = fileName;
		this.fileMimeType = fileMimeType;
		this.fileExtension = fileExtension;
		this.fileSize = fileSize;
	}

	private String fileName;

	private String fileMimeType;

	private String fileExtension;

	private Long fileSize;

	public String getFileName() {
		return fileName;
	}

	public String getFileMimeType() {
		return fileMimeType;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public Long getFileSize() {
		return fileSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileExtension == null) ? 0 : fileExtension.hashCode());
		result = prime * result + ((fileMimeType == null) ? 0 : fileMimeType.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileProperty other = (FileProperty) obj;
		if (fileExtension == null) {
			if (other.fileExtension != null)
				return false;
		} else if (!fileExtension.equals(other.fileExtension))
			return false;
		if (fileMimeType == null) {
			if (other.fileMimeType != null)
				return false;
		} else if (!fileMimeType.equals(other.fileMimeType))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		return true;
	}

}
