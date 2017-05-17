package com.nexus.domain;

public enum Category {
	SMARTPHONE("SMARTPHONE"),
	TABLET("TABLET"),
	DIGITAL_MEDIA_PLAYERS("DIGITAL_MEDIA_PLAYERS");

	String cat;

	private Category(String cat) {
		this.cat = cat;
	}

	public String getCat() {
		return cat;
	}
}
