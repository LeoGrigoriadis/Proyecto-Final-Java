package com.apiCrypto.apiCrypto.TestTransaction;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apiCrypto.apiCrypto.model.*;
import com.apiCrypto.apiCrypto.repository.ITransactionRepository;
import com.apiCrypto.apiCrypto.service.TransactionService;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
 
    @InjectMocks
	private TransactionService service;
	
	@Mock
	private ITransactionRepository repository;

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
  

    //Coin
    Coin coin1 = new Coin ("a", "btc");

    Coin coin2 = new Coin("b", "dolar"); 

    Timestamp fecha = new Timestamp(26/10/21);

    Transaction t= new Transaction(1,user1, coin1,20.0,fecha,40.0,true);
    Transaction t2= new Transaction(1,user2, coin2,20.0,fecha,40.0,true);

    @Test
	public void SELECT_TRANSACTION() {
		when(repository.findAll()).thenReturn(new ArrayList<Transaction>());
		List<Transaction> transactions = service.getAll();
		assertNotNull(transactions);
	}

	@Test
	public void SAVE_TRANSACTION() {
		when(repository.existsById(t.getId_transaction())).thenReturn(false);
		when(repository.save(t)).thenReturn(null);
		boolean result = service.save(t);
		assertTrue(result);
	}
	

}
