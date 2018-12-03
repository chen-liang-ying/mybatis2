package com.mobile263.yingbatis2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mobile263.yingbatis2.pojo.Order;
import com.mobile263.yingbatis2.pojo.User;

public interface UserMapper {

    //������ηǶ���
	public User queryByNameAndAge(@Param("name") String name,@Param("age") int age) throws Exception;
	
	//���Է���ȫ���б�����
	public List<User> queryByUser(User user) throws Exception;
	
	//ͨ��������ѯ�������û�����
	public Order oneToOne(int orderNum) throws Exception; 
	
	//ͨ��������ѯ�úͶ�������
	public Order oneToMany(int orderNum) throws Exception;
	
	//��ѯ��������������������Ʒ��Ϣ�Լ��û���Ϣ
	public Order manyToMany(int orderNum) throws Exception;
}
