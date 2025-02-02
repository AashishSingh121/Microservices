package com.rest.demo.version;

public class PersonV1 {
	private final String name;

	public PersonV1( final String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

}
