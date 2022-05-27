package com.apiCrypto.apiCrypto.TestAuth;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.apiCrypto.apiCrypto.model.*;
import com.apiCrypto.apiCrypto.repository.IAuthRepository;
import com.apiCrypto.apiCrypto.service.AuthService;


import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTest {
    
    @InjectMocks
	private AuthService service;
	
	@Mock
	private IAuthRepository repository;

	//Auth1	
    private Role rol = new Role(1,"user");

	private Auth auth1 = new Auth("ana@gmail.com","1234", rol);
	
	//Auth2
	private Role rol2 = new Role(2,"admin");

	private Auth auth2 = new Auth("toma@gmail.com","tom", rol2);



    @Test
	public void SELECT_AUTH() {
		when(repository.findAll()).thenReturn(new ArrayList<Auth>());
		List<Auth> auth = service.getAll();
		assertNotNull(auth);
	}

	@Test
	public void SAVE_AUTH() {
		when(repository.existsById(auth1.getGmail())).thenReturn(false);
		when(repository.save(auth1)).thenReturn(null);
		boolean result = service.save(auth1);
		assertTrue(result);
	}
	
	@Test
	public void DELETE_AUTH() {
		when(repository.existsById(auth2.getGmail())).thenReturn(true);
		boolean result = service.deleteAuth(auth2.getGmail());
		assertTrue(result);
	}
}
