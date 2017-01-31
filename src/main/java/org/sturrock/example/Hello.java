package org.sturrock.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hello")
public class Hello {

	@XmlElement(name = "Greeting")
	private String greeting = "Hello";
	
	@XmlElement(name = "Name")
	private String name;

	public Hello(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Hello [name=" + name + "]";
	}
	// For JAXB
	@SuppressWarnings("unused")
	private Hello() {
	}
}
