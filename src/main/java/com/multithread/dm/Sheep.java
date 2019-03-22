package com.multithread.dm;

public class Sheep {
	
	private String fullName;
	
	private String alias;

	private String faviouriteGrass;
	
	private String squashRacket;

	public Sheep() {
		
	}
	
	public Sheep(String fullName, String alias, String faviouriteGrass, String squashRacket) {
		this.fullName = fullName;
		this.alias = alias;
		this.faviouriteGrass = faviouriteGrass;
		this.squashRacket = squashRacket;
	}

	@Override
	public String toString() {
		return "Sheep [fullName=" + fullName + ", alias=" + alias + ", faviouriteGrass=" + faviouriteGrass
				+ ", squashRacket=" + squashRacket + "]";
	}
	
}
