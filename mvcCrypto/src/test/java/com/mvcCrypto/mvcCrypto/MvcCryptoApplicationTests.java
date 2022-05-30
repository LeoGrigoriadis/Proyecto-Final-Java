package com.mvcCrypto.mvcCrypto;

import com.mvcCrypto.mvcCrypto.controller.service.AuthService;
import com.mvcCrypto.mvcCrypto.controller.service.UserService;
import com.mvcCrypto.mvcCrypto.model.Auth;
import com.mvcCrypto.mvcCrypto.model.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
class MvcCryptoApplicationTests {

	@Autowired
	private AuthService uA;
	@Autowired
	private PasswordEncoder pE;
	@Autowired
	private WebApplicationContext webC;
	private MockMvc mvc;

	@Test
	void contextLoads() {
		Auth user = new Auth();

		user.setGmail("leo@gmail.com");
		user.setPassword(pE.encode("123"));
		Role role = new Role();
		role.setId_role(1);
		role.setName("user");
		user.setId_role(role);
		System.out.println("contra iniciada: "+user.getPassword());


		UserDetails r = uA.loadUserByUsername(user.getGmail());
		Assert.assertEquals(r.getPassword(),user.getPassword());

	}

}
