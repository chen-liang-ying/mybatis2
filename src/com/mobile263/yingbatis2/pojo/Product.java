package com.mobile263.yingbatis2.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product implements Serializable{

	private int pid; 
	private String pname;
	private double price; 
	private String proDetail;
}
