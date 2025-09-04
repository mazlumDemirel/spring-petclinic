package org.springframework.samples.petclinic.model;

public class FarmEntity {
	private long id;
	private String name;
	private String location;
	private String ownerName;
	private String phoneNumber;

	public FarmEntity() {
	}

	public FarmEntity(String name, String location, String ownerName, String phoneNumber) {
	}
}
