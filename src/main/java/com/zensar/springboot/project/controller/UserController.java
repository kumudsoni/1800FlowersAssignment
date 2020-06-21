package com.zensar.springboot.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.springboot.project.model.ResponseDTO;
import com.zensar.springboot.project.model.UserDTO;

@RestController
@RequestMapping(value = "Userdata")
public class UserController {

	@Autowired
	RestTemplate restTemplete;

	private String URL = "http://jsonplaceholder.typicode.com/posts";
	private static String UPDATE_USER_LIST_TITEL= "1800Flowers";
	
	
	@GetMapping("/findUserInfo")
	public List<UserDTO> findUserInfo() {
		List<UserDTO> userList = getAPIdata();
		return userList;
	}
	

	@GetMapping("/countEndpoint")
    public Long countEndpoint() {
		List<UserDTO> userList = getAPIdata();
        return (long) userList.size();
    }
	
	@GetMapping("/findUniqueUserIds")
	public ResponseDTO findUniqueUserIds() {

		List<UserDTO> userList = getAPIdata();

		Map<Integer, UserDTO> map = new HashMap<Integer, UserDTO>();
		ResponseDTO responseDTO = new ResponseDTO();

		if (userList != null) {
			map = new HashMap<Integer, UserDTO>();
			for (UserDTO dto : userList) {
				map.put(dto.getUserId(), dto);
			}
			responseDTO = new ResponseDTO(map.size(), map.keySet());
		}

		return responseDTO;
	}

	@GetMapping("updateUserListEndpoint/{Id}")
	public List<UserDTO> updateUserListEndpoint(@PathVariable int Id) {

		List<UserDTO> userList = getAPIdata();

		List<UserDTO> updateduserList = new ArrayList<>();
		for (UserDTO userDTO : userList) {

			if (userDTO.getId() == Id) {
				userDTO.setTitle(UPDATE_USER_LIST_TITEL);
				userDTO.setBody(UPDATE_USER_LIST_TITEL);
			}
			System.out.println(userDTO.toString());

			updateduserList.add(userDTO);

		}

		return updateduserList;

	}

	private List<UserDTO> getAPIdata() {
		ResponseEntity<List<UserDTO>> rateResponse = restTemplete.exchange(URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserDTO>>() {
				});
		List<UserDTO> userList = rateResponse.getBody();
		return userList;
	}

}
