package com.apiCrypto.apiCrypto.TestUser;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;



import java.util.ArrayList;
import java.util.List;

import com.apiCrypto.apiCrypto.model.Account_type;
import com.apiCrypto.apiCrypto.model.*;
import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.IUserRepository;
import com.apiCrypto.apiCrypto.service.UserService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
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

	private Auth auth = new Auth("ana@gmail.com","1234", rol);

	private Account_type account = new Account_type(1, "premium", 5);
	
	private User user1 = new User(1, "Ani", "Guari", account, 5, auth);




	
	private Role rol2 = new Role(2,"admin");

	private Auth auth2 = new Auth("jere@gmail.com","111", rol2);

	private Account_type account2 = new Account_type(1, "premium", 5);
	
	private User user2 = new User(2, "jere", "Roca", account2, 5, auth2);
		
	@Test
	public void SELECT_USERS() {
		when(repository.findAll()).thenReturn(new ArrayList<User>());
		List<User> user = service.getAll();
		assertNotNull(user);
	}
	
	@Test
	public void SAVE_USERS() {
		when(repository.existsById(user1.getId_user())).thenReturn(false);
		when(repository.save(user1)).thenReturn(null);
		User test = service.save(user1);
		boolean  flag = true;
		if(test == null){
			flag = false;
		}
		assertTrue(flag);
	}
	
	@Test
	public void SAVE_CLIENT_FAIL() {
		when(repository.existsById(user1.getId_user())).thenReturn(true);
		when(repository.save(user1)).thenReturn(null);
		User test = service.save(user1);
		boolean  flag = true;
		if(test == null){
			flag = false;
		}
		assertTrue(flag);
	}
	
	@Test
	public void UPDATE_CLIENT() {
		when(repository.existsById(user2.getId_user())).thenReturn(true);
		when(repository.save(user2)).thenReturn(null);
		boolean result = service.updateUser(user2);
		assertTrue(result);
	}
	
	@Test
	public void UPDATE_CLIENT_FAIL() {
		when(repository.existsById(user2.getId_user())).thenReturn(false);
		when(repository.save(user2)).thenReturn(null);
		boolean result = service.updateUser(user2);
		assertTrue(result);
	}
	
	/*@Test
	public void DELETE_CLIENT() {
		when(repository.existsById(user2.getId_user())).thenReturn(true);
		service.deleteUser(user2.getId_user());
		assertTrue(result);
	}
	
	@Test
	public void DELETE_CLIENT_FAIL() {
		when(repository.existsById(client2.getId())).thenReturn(false);
		boolean result = service.delete(client2.getId());
		assertFalse(result);

}*/
	}