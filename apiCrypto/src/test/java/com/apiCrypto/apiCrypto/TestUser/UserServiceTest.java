package com.apiCrypto.apiCrypto.TestUser;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apiCrypto.apiCrypto.model.Auth;
import com.apiCrypto.apiCrypto.model.Role;
import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserRepository;
import com.apiCrypto.apiCrypto.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
  @SpringBootTest
public class UserServiceTest {
    
   @InjectMocks
	private UserService service;
	
	@Mock
	private IUserRepository repository;

	private Role rol = new Role(1,"user");
	Date fecha = new Date(15/10/21);

	private Auth auth = new Auth("ana@gmail.com","1234", rol);

	private Account_type account = new Account_type(1, "premium", 5);
	
	private User user1 = new User(1, "Ani", "Guari",fecha , account, 5, auth);




	
	private Role rol2 = new Role(2,"admin");

	Date fecha2 = new Date(26/10/21);

	private Auth auth2 = new Auth("jere@gmail.com","111", rol2);

	private Account_type account2 = new Account_type(1, "premium", 5);
	
	private User user2 = new User(2, "jere", "Roca",fecha2, account2, 5, auth2);
		
	@Test
	public void SELECT_USERS() {
		when(repository.findAll()).thenReturn(new ArrayList<User>());
		List<User> user = service.getAll();
		assertNotNull(user);
	}
	
	@Test
	public void SAVE_USERS() {
		when(repository.existsById(user1.getId_user())).thenReturn(true);
		when(repository.save(user1)).thenReturn(null);
		Boolean flag = service.save(user1);
		assertTrue(flag);
	}
	
	@Test
	public void SAVE_CLIENT_FAIL() {
		when(repository.existsById(user1.getId_user())).thenReturn(false);
		when(repository.save(user1)).thenReturn(null);
		boolean  flag  = service.save(user1);
		assertTrue(flag);
	}
	
	@Test
	public void DELETE_CLIENT() {
		when(repository.existsById(user2.getId_user())).thenReturn(true);
		boolean result = service.deleteUser(user2.getId_user());
		assertTrue(result);
	}
	

	}