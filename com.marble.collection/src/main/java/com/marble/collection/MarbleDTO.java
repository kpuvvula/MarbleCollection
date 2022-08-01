package com.marble.collection;

import java.io.Serializable;
import java.math.BigDecimal;

public class MarbleDTO implements Serializable {

	private static final long serialVersionUID = 5990086366634431764L;
	
	public MarbleDTO() {
		
	}
	public MarbleDTO(Long id, String color,String name, BigDecimal weight) {
		this.id = id;
		this.color = color;
		this.name=name;
		this.weight = weight;
	}
	
	private Long id;
	private String color;
	String name;
	private BigDecimal weight;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return "Name: "+ this.getName() + " , Color: "+this.getColor()+" , Weight: "+this.getWeight()+" , Id: "+this.getId();
	}
}