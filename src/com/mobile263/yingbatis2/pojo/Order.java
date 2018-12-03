package com.mobile263.yingbatis2.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order implements Serializable{

	private int oid;
	private int userId;
	private String orderNumber;
	private User user ;
	
	
	//һ�������ж���������飬�����嵥�б�
	private List<OrderDetail> details;
}
