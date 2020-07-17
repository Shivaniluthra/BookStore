package com.cg.bookstore.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.bookstore.controller.OrderController;
import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.OrderInformation;
import com.cg.bookstore.services.OrderServicesImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	OrderServicesImpl orderService;
	
//	@Test
//	public void testAddOrder() throws Exception {
//		 Order mockOrder= new Order();
//		 int id=1;
//		 CustomerInformation custInfo= new CustomerInformation();
//		 custInfo.setCustomerId(1);
//		 String phoneNumber= "9312392019";
//		 String fullName= "Shivani Luthra";
//		 String city= "Ghaziabad";
//		 Integer zipCode= 201009;
//		 String country= "India";
//		 mockOrder.setCustomerDetails(custInfo);
//		 mockOrder.setPaymentMethod("COD");
//		 mockOrder.setQuantity(2);
//		 mockOrder.setSubTotal(150);
//		 mockOrder.setTotal(300);
//		 mockOrder.setOrderStatus("Shipped");
//	     mockOrder.setShippingAddress("M-266");
//	     String inputInJson = this.mapToJson(mockOrder);
//	     String uri= "/addOrder/1";
//	     
//	     Mockito.when(orderService.addOrder(Mockito.anyInt(), Mockito.any(Order.class), 
//	    		 Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyString()))
//	     .thenReturn(mockOrder);
//	   
//	     RequestBuilder reqBuilder= MockMvcRequestBuilders
//	    		 .post(uri)
//	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)
//	    		 .contentType(MediaType.APPLICATION_JSON);
//	     
//	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
//	     MockHttpServletResponse response = result.getResponse();
//	     
//	     String outputInJson = response.getContentAsString();
//	     assertThat(outputInJson).isEqualTo(inputInJson);
//	     assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}
	
	@Test
	public void testSearchCustomer() throws Exception {
		CustomerInformation customer= new CustomerInformation();
		customer.setPhoneNumber("9312392019");
		customer.setFullName("Shivani Luthra");
		customer.setCity("Mumbai");
		customer.setZipCode(201009);
		customer.setCountry("India");
		customer.setCustomerId(1);
		customer.setEmailAddress("shivani.16@abes.com");
		String inputInJson = this.mapToJson(customer);
		String uri= "/searchShippingInfo/1";
	     
	     Mockito.when(orderService.searchShippingInfo(Mockito.anyInt())).thenReturn(customer);
	     
	     RequestBuilder reqBuilder= MockMvcRequestBuilders
	    		 .get(uri)
	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)
	    		 .contentType(MediaType.APPLICATION_JSON);
	     
	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
	     MockHttpServletResponse response = result.getResponse();
	     
	     String outputInJson = response.getContentAsString();
	     assertThat(outputInJson).isEqualTo(inputInJson);
	     assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
//	@Test
//	public void testModifyShippingInfo() throws Exception {
//		 Order mockOrder= new Order();
//		 CustomerInformation custInfo= new CustomerInformation();
//		 custInfo.setPhoneNumber("9312392019");
//		 custInfo.setFullName("Shivani Luthra");
//		 custInfo.setCity("Ghaziabad");
//		 custInfo.setZipCode(201009);
//		 custInfo.setCountry("India");
//		 mockOrder.setCustomerDetails(custInfo);
//	     mockOrder.setShippingAddress("M-266");
//	     String inputInJson = this.mapToJson(mockOrder);
//	     String uri= "/modifyShippingInfo";
//	     
//	     Mockito.when(orderService.modifyShippingInfo(Mockito.any(Order.class))).thenReturn(mockOrder);
//	     
//	     RequestBuilder reqBuilder= MockMvcRequestBuilders
//	    		 .put(uri)
//	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)
//	    		 .contentType(MediaType.APPLICATION_JSON);
//	     
//	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
//	     MockHttpServletResponse response = result.getResponse();
//	     
//	     String outputInJson = response.getContentAsString();
//	     assertThat(outputInJson).isEqualTo(inputInJson);
//	     assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}
//
//	@Test
//	public void negativeTestModifyShippingInfo() throws Exception {
//		 Order mockOrder= null;
//	     String inputInJson = this.mapToJson(mockOrder);
//	     String uri= "/modifyShippingInfo";
//	     
//	     Mockito.when(orderService.modifyShippingInfo(Mockito.any(Order.class))).thenReturn(mockOrder);
//	     
//	     RequestBuilder reqBuilder= MockMvcRequestBuilders
//	    		 .put(uri)
//	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)
//	    		 .contentType(MediaType.APPLICATION_JSON);
//	     
//	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
//	     MockHttpServletResponse response = result.getResponse();
//	     
//	     String outputInJson = response.getContentAsString();
//	     assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
//	}

	private String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	}
	
	
}
