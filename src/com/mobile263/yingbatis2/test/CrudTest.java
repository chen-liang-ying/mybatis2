package com.mobile263.yingbatis2.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mobile263.yingbatis2.mapper.UserMapper;
import com.mobile263.yingbatis2.pojo.Order;
import com.mobile263.yingbatis2.pojo.User;

public class CrudTest {

	private UserMapper userMapper;
	private SqlSession  sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setup() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		
	}
	
	@After
	public void tearDown() {
		sqlSession.commit();
		sqlSession.close();	

	}
	
	@Test
	public void testQueryByNameAndAge() throws Exception {
		User user = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user.toString());
	}
	
	@Test
	public void testQueryByUser() throws Exception {
		User user = new User();
		user.setUserName("%小%");
		user.setAge(12);
		List<User> users= userMapper.queryByUser(user);
		for (User user2 : users) {
			System.out.println(user2.toString());
		}
	}
	
	@Test
	public void testSessionCache() throws Exception {
		User user = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user.toString());
		User user2 = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user2.toString());
	}
	
	@Test
	public void testSessionCache2() throws Exception {
		User user = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user.toString());
		sqlSession.clearCache();
		User user2 = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user2.toString());
	}
	
	
	@Test
	public void testMapperCache() throws Exception {
		User user = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user.toString());
		sqlSession.close();
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		User user2 = userMapper.queryByNameAndAge("%周%",23);
		System.out.println(user2.toString());
	}
	
	@Test
	public void testOneToOne() throws Exception {
		
		Order order = userMapper.oneToOne(1);
		System.out.println(order.toString());
	}
	
	@Test
	public void testOneToMany() throws Exception {
		
		Order order = userMapper.oneToMany(1);
		System.out.println(order.toString());
	}
	
	@Test
	public void testmanyToMany() throws Exception {
		
		Order order = userMapper.manyToMany(2);
		System.out.println(order.toString());
	}
	
	
}
