package com.ct.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ct.entity.Customer;
import com.ct.entity.Orders;


public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Customer getCustomer(int id) {
		Customer cust=null;
		String sql="SELECT * FROM customer where Id=?";
		cust=(Customer) jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper(Customer.class));
		return cust;
	}

	public Customer addCustomer(Customer customer) {
		String sql="Insert into customer (FirstName, LastName, Gender, Address, City, State, Email) Values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,customer.getFirstName(),customer.getLastName(),customer.getGender(),customer.getAddress(),customer.getCity(),customer.getState(),customer.getEmail());
		return customer;
	}

	public Customer editCustomer(Customer customer) {
		String sql="update customer Set FirstName=? , LastName=?, Gender=?, Address=?, City=?, State=?, Email=? where Id= ?";
		jdbcTemplate.update(sql,customer.getFirstName(),customer.getLastName(),customer.getGender(),customer.getAddress(),customer.getCity(),customer.getState(),customer.getEmail(),customer.getId());
	return customer;
	}

	public void deleteCustomer(int id) {

		String sql="DELETE FROM customer where Id=?";
		jdbcTemplate.update(sql,id);
		
	}

	public List<Customer> getAllCustomers() {
		java.util.List<Customer> custlist = new ArrayList<Customer>();
		String sql="SELECT * FROM customer";
		custlist= jdbcTemplate.query(sql,new BeanPropertyRowMapper(Customer.class));
		return custlist;
	}

	public List<Orders> getOrder(int id) {
		java.util.List<Orders> orderlist = new ArrayList<Orders>();
		String sql="SELECT * FROM orders where customerid=?";
		orderlist= jdbcTemplate.query(sql, new Object[]{id},new BeanPropertyRowMapper(Orders.class));
		return orderlist;
	}

	public List<Orders> getAllOrders() {
		java.util.List<Orders> orderlist = new ArrayList<Orders>();
		String sql="SELECT * FROM orders";
		orderlist= jdbcTemplate.query(sql,new BeanPropertyRowMapper(Orders.class));
		return orderlist;
	}
}
//