package com.apiCrypto.apiCrypto.TestUser_Coin;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apiCrypto.apiCrypto.model.*;
import com.apiCrypto.apiCrypto.repository.IUserCoinRepository;
import com.apiCrypto.apiCrypto.service.User_CoinService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User_CoinServiceTest {

    @InjectMocks
	private User_CoinService service;
	
	@Mock
	private IUserCoinRepository repository;

   //User    

   	private Role rol1 = new Role(1,"user");

	private Date fecha1 = new Date(15/10/21);

	private Auth auth = new Auth("ana@gmail.com","1234", rol1);

	private Account_type account = new Account_type(1, "premium", 5);
	
	private User user1 = new User(1, "Ani", "Guari",fecha1 , account, 5, auth);

	
	private Role rol2 = new Role(2,"admin");

	Timestamp fecha2 = new Timestamp(26/10/21);

	private Auth auth2 = new Auth("jere@gmail.com","111", rol2);

	private Account_type account2 = new Account_type(1, "premium", 5);
	
	private User user2 = new User(2, "jere", "Roca",fecha2, account2, 5, auth2);
  
	Timestamp fecha = new Timestamp(26/10/21);

	Timestamp fecha0 = new Timestamp(26/10/21);
    
    //Coin
    Coin coin1 = new Coin ("a", "btc");

    Coin coin2 = new Coin("b", "dolar"); 

    User_Coin usCoin = new User_Coin(1,coin1,20.0,user1);

    User_Coin usCoin2 = new User_Coin(2,coin2,20.0,user2);


    @Test
	public void SELECT_USERCOIN() {
		when(repository.findAll()).thenReturn(new ArrayList<User_Coin>());
		List<User_Coin> user_Coins = service.getAll();
		assertNotNull(user_Coins);
	}

	@Test
	public void SAVE_USERCOIN() {
		when(repository.existsById(usCoin.getId_account())).thenReturn(false);
		when(repository.save(usCoin)).thenReturn(null);
		boolean result = service.save(usCoin);
		assertTrue(result);
	}
	
	
}
