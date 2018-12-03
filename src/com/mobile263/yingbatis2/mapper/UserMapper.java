package com.mobile263.yingbatis2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mobile263.yingbatis2.pojo.Order;
import com.mobile263.yingbatis2.pojo.User;

public interface UserMapper {

    //测试入参非对象
	public User queryByNameAndAge(@Param("name") String name,@Param("age") int age) throws Exception;
	
	//测试返回全部列表数据
	public List<User> queryByUser(User user) throws Exception;
	
	//通过订单查询订单和用户数据
	public Order oneToOne(int orderNum) throws Exception; 
	
	//通过订单查询用和订单详情
	public Order oneToMany(int orderNum) throws Exception;
	
	//查询订单，查出订单详情和商品信息以及用户信息
	public Order manyToMany(int orderNum) throws Exception;
}
