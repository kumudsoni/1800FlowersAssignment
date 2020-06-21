package com.zensar.springboot.project.controller;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.springboot.project.model.ResponseDTO;
import com.zensar.springboot.project.model.UserDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	
	
	@Autowired
	private UserController controller;
		
	@Test
	public void findUserInfoTest() throws Exception {
		
		
		List<UserDTO> actual = controller.findUserInfo();
	
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserDTO>> typeReference = new TypeReference<List<UserDTO>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/userdata.json");
		try {
			List<UserDTO> expected = mapper.readValue(inputStream,typeReference);
			Assert.assertEquals(actual,expected);
			  
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
	
	@Test
	public void countEndpointTestSuccess() {
		Long actual = controller.countEndpoint();
		Long expected = new Long(100);
		
		Assert.assertEquals(actual,expected);
		
	}
	@Test
	public void countEndpointTestFail() {
		Long actual = controller.countEndpoint();
		Long expected = new Long(200);
		
		Assert.assertNotEquals(actual,expected);
		
	}
	
	@Test
	public void findUniqueUserIds() {
		ResponseDTO actual = controller.findUniqueUserIds();
		
		Set<Integer> unique_UserId = new HashSet<>();
		unique_UserId.add(1);
		unique_UserId.add(2);
		unique_UserId.add(3);
		unique_UserId.add(4);
		unique_UserId.add(5);
		unique_UserId.add(6);
		unique_UserId.add(7);
		unique_UserId.add(8);
		unique_UserId.add(9);
		unique_UserId.add(10);
		
		ResponseDTO expected = new ResponseDTO(10, unique_UserId);
		
		Assert.assertEquals(actual,expected);
		
	}
	@Test
	public void updateUserListEndpointTest_Success() {
		List<UserDTO> actual = 	controller.updateUserListEndpoint(4);
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserDTO>> typeReference = new TypeReference<List<UserDTO>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/userdata_with_updatedfield.json");
		try {
			List<UserDTO> expected = mapper.readValue(inputStream,typeReference);
			Assert.assertEquals(actual,expected);
			  
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
	@Test
	public void updateUserListEndpointTest_Fail() {
		List<UserDTO> actual = 	controller.updateUserListEndpoint(2);
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserDTO>> typeReference = new TypeReference<List<UserDTO>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/userdata_with_updatedfield.json");
		try {
			List<UserDTO> expected = mapper.readValue(inputStream,typeReference);
			Assert.assertNotEquals(actual,expected);
			  
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}
}






