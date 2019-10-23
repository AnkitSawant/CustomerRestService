package com.ct.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.dao.CustomerDao;
import com.ct.entity.Customer;
import com.ct.entity.Orders;

@RestController
public class MainController {

	@RequestMapping(value="/")
	public String getHome() {
		return "index";
	}
			
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public Customer getCustomer(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.getCustomer(id);
		
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers(HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.getAllCustomers();
		
	}
	
	@RequestMapping(value="/addcustomer", method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		//System.out.println(book.getBookName());
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.addCustomer(customer);
		
	}
	
	@RequestMapping(value="/editcustomer", method=RequestMethod.PUT)
	public Customer update(@RequestBody Customer customer, HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		//System.out.println(customer.getBookName());
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.editCustomer(customer);
		
	}
	
	@RequestMapping(value="/deletecustomer", method=RequestMethod.DELETE)
	public void delete(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        dao.deleteCustomer(id);
		
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public List<Orders> getOrder(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.getOrder(id);
		
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public List<Orders> getAllOrders(HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		ApplicationContext ctx=null;
		//ModelAndView mv = new ModelAndView();
    	ctx=new ClassPathXmlApplicationContext("springConfig.xml");        
        CustomerDao dao=(CustomerDao)ctx.getBean("mdao");
       // mv.addObject("movie", dao.getBook(id));
       // mv.setViewName("index");
        return dao.getAllOrders();
		
	}
}
