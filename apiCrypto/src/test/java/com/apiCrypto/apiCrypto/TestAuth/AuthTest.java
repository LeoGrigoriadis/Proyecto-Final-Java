package com.apiCrypto.apiCrypto.TestAuth;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.apiCrypto.apiCrypto.model.Auth;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthTest {
    @Autowired
	private WebApplicationContext aplicationContext;
	
	private MockMvc mock;
	
	@Test
	public void SELECT_AUTH() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		String JsonResponse = mock.perform(
					get("/api/Auth")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn()
					.getResponse()
					.getContentAsString();
		Auth[] auth = new ObjectMapper().readValue(JsonResponse, Auth[].class);
	}	

}
