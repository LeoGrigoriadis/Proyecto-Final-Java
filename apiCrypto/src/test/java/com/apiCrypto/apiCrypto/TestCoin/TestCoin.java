package com.apiCrypto.apiCrypto.TestCoin;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apiCrypto.apiCrypto.model.Coin;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCoin {
   
    @Autowired
	private WebApplicationContext aplicationContext;
	
	private MockMvc mock;
	
	@Test
	public void SELECT_COIN() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(aplicationContext).build();
		String JsonResponse = mock.perform(
					get("/api/Coin")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn()
					.getResponse()
					.getContentAsString();
		Coin[] coin = new ObjectMapper().readValue(JsonResponse, Coin[].class);
	}	

}
