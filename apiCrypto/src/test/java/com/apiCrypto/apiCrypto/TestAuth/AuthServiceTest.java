package com.apiCrypto.apiCrypto.TestAuth;

import static org.junit.Assert.assertNotNull;
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

    private Role rol = new Role(1,"user");

	private Auth auth = new Auth("ana@gmail.com","1234", rol);


    @Test
	public void SELECT_AUTH() {
		when(repository.findAll()).thenReturn(new ArrayList<Auth>());
		List<Auth> auth = service.getAll();
		assertNotNull(auth);
	}

	
}
