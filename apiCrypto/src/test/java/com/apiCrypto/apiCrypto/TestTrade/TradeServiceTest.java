package com.apiCrypto.apiCrypto.TestTrade;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apiCrypto.apiCrypto.model.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {

    @InjectMocks
	private TradeService service;
	
	@Mock
	private ITradeRepository repository;

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
   

    Trade trade1 = new Trade(1, user1, coin1, fecha , 20.0, 40.0);


    Trade trade2 = new Trade(2, user2, coin2, fecha2, 30.0,50.0);

    @Test
	public void SELECT_TRADE() {
		when(repository.findAll()).thenReturn(new ArrayList<Trade>());
		List<Trade> trade = service.getAll();
		assertNotNull(trade);
	}

	@Test
	public void SAVE_TRADE() {
		when(repository.existsById(trade1.getId_trade())).thenReturn(false);
		when(repository.save(trade1)).thenReturn(null);
		boolean result = service.save(trade1);
		assertTrue(result);
	}
	
	@Test
	public void DELETE_TRADE() {
		when(repository.existsById(trade1.getId_trade())).thenReturn(true);
		boolean result = service.delete(trade1.getId_trade());
		assertTrue(result);
	}
}

