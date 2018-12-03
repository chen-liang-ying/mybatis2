package com.mobile263.yingbatis2.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDetail implements Serializable{

	private int detailId;
	private int orderId; 
	private int productId; 
	private double price;
	private String status;
	private Product product;
}
