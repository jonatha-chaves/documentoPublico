package com.idip.util;

public enum FileType {
	
	FOLDER("pasta", "fa-folder-o"),
	FILE("arquivo", "fa-file-o "),
	FILE_AUDIO("arquivo de audio", "fa-file-audio-o"),
	FILE_CODE("arquivo de código", "fa-file-code-o"),
	FILE_EXCEL("arquivo do excel", "fa-file-excel-o"),
	FILE_IMAGE("arquivo de imagem", "fa-file-image-o"),
	FILE_VIDEO("arquivo de video", "fa-file-video-o"),
	FILE_PDF("arquivo pdf", "fa-file-pdf-o"),
	FILE_POWER_POINT("arquivo do power point", "fa-file-powerpoint-o"),
	FILE_TEXT("arquivo de text", "fa-file-text-o"),
	FILE_WORD("arquivo do word", "fa-file-word-o"),
	FILE_ZIP("arquivo zip", "fa-file-zip-o");
	
	private String definition;
	private String icon;

	private FileType(String definition, String icon) {
		this.definition = definition;
		this.icon = icon;
	}

	public String getDefinition() {
		return definition;
	}

	public String getIcon() {
		return icon;
	}

}
