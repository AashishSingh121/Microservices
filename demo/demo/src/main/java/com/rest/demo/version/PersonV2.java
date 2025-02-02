package com.rest.demo.version;

public class PersonV2 {
	private final Name name;

	public PersonV2( final Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}