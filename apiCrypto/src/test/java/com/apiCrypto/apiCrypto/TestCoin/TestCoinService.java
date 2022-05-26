package com.apiCrypto.apiCrypto.TestCoin;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.apiCrypto.apiCrypto.model.Coin;
import com.apiCrypto.apiCrypto.repository.ICoinRepository;
import com.apiCrypto.apiCrypto.service.CoinService;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCoinService {

    @InjectMocks
    private CoinService service;

    @Mock
    private ICoinRepository repository;

    Coin coin1 = new Coin ("a", "btc");

    Coin coin2 = new Coin("b", "dolar");

    @Test
	public void SELECT_COIN() {
		when(repository.findAll()).thenReturn(new ArrayList<Coin>());
		List<Coin> coin = service.getAll();
		assertNotNull(coin);
	}

	@Test
	public void SAVE_COIN() {
		when(repository.existsById(coin1.getId_coin())).thenReturn(false);
		when(repository.save(coin1)).thenReturn(null);
		boolean result = service.save(coin1);
		assertTrue(result);
	}
	
	@Test
	public void DELETE_COIN() {
		when(repository.existsById(coin2.getId_coin())).thenReturn(true);
		boolean result = service.delete(coin2.getId_coin());
		assertTrue(result);
	}
}
