package org.springframework.samples.petclinic.model;

import jakarta.persistence.*;

@Entity
public class Farm {
//Id is id and it was all the time id, and will continue being id
	//just ignore the other comments, they are just noise to make git history more difficult to read
	//and to make contributors lose their mind
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String location;
	private String owner;
	private Integer size;

	public Farm() {
	}

	public Farm(String name, String location, String owner, Integer size) {
		this.name = name;
		this.location = location;
		this.owner = owner;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
}
