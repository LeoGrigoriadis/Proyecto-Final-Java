package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CoinExternoRepository {

    @Autowired
    private RestTemplate rt;
    public Coin findBtc() {
        Coin coin=rt.getForObject("https://criptoya.com/api/bitex/btc/usd/0.1", Coin.class);
        coin.setName("Bitcoin (BTC)");
        return coin; }
    public Coin findUsdt() { Coin coin=rt.getForObject("https://criptoya.com/api/bitex/usdt/usd/0.1", Coin.class);
        coin.setName("Tether (USDT)");
        return coin;  }
    public Coin findEth() { Coin coin=rt.getForObject("https://criptoya.com/api/bitex/eth/usd/0.1", Coin.class);
        coin.setName("Ethereum (ETH)");
        return coin;  }
    public Coin findUsdc() { Coin coin=rt.getForObject("https://criptoya.com/api/bitex/usdc/usd/0.1", Coin.class);
        coin.setName("USD Coin (USDC)");
        return coin;  }

    public double findById(String name) {
        Coin coin=rt.getForObject("https://criptoya.com/api/bitex/{name}/usd/0.1", Coin.class, name);
        return coin.getAsk();  }
}
