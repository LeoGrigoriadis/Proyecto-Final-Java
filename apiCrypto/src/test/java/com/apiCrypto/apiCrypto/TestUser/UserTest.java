package com.apiCrypto.apiCrypto.TestUser;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apiCrypto.apiCrypto.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	
	@Autowired
	private WebApplicationContext aplicationContext;
	
	private MockMvc mock;
	
	@Test
	public void SELECT_CLIENTS() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		String JsonResponse = mock.perform(
					get("/api/Users")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn()
					.getResponse()
					.getContentAsString();
		User[] user = new ObjectMapper().readValue(JsonResponse, User[].class);
	}	

    /*
	@Test
	public void DELETE_USER() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		long idUser = 1;
		String JsonResponse = mock.perform(
                     delete("/api/Users/delete"+idUser)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isBadRequest())
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertTrue(JsonResponse.equals("Deleted client"));
	}
	
	@Test 
	public void DELETE_CLIENT_FAIL() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		long idUser = 1;
		String JsonResponse = mock.perform(
                     delete("/api/Users/delete"+idUser)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isBadRequest())
				.andReturn()
				.getResponse()
				.getContentAsString();
		assertTrue(JsonResponse.equals("Client doesn't exists"));
	}
	*/
	
}