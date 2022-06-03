package com.mvcCrypto.mvcCrypto.controller;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.controller.service.*;

import com.mvcCrypto.mvcCrypto.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.sql.Timestamp;

@Controller
@RequestMapping("")
public class MasterController {

    @Autowired
    private CoinExternoService ces;

    @Autowired
    private CoinExternoRepository ccc;
    @Autowired
    private CoinApiService cas;
    @Autowired
    private TransactionService ts;

    @Autowired
    private UserCoinService ucs;

    @Autowired
    private UserService us;


    @GetMapping("/app-view")
    public String getAll(Model model) {
        try {
            User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
            model.addAttribute("user",user);  //el usuario en sesión actual llevado a la vista
            model.addAttribute("coins",ces.getAll()); //criptos de api externa
            model.addAttribute("transaction", new Transaction()); //objeto para crear nueva transacción
            model.addAttribute("user_coin", new User_CoinAdapter()); //objeto para crear nueva transacción
            model.addAttribute("movs",ts.getLast(user.getId_user())); //lista de ultimos movimientos de la sesión actual
            model.addAttribute("wallet",ucs.findAllByIdUser(user.getId_user())); //wallet de la sesión actual
            return "AppView";
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return "AppView";
    }

    @GetMapping("/external-entity")
    public String ExternalEntity(Model model){
        User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
        model.addAttribute("user",user);  //el usuario en sesión actual llevado a la vista
        model.addAttribute("user_coin", new User_Coin()); //objeto para crear nueva transacción
        return "ExternalEntity";
    }

    @GetMapping("/form-transactions")
    public String FormTransactions(Model model){
        User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
        model.addAttribute("user",user);  //el usuario en sesión actual llevado a la vista
        model.addAttribute("transaction", new Transaction()); //objeto para crear nueva transacción
        model.addAttribute("user_coin", new User_CoinAdapter()); //objeto para crear nueva transacción
        return "FormTransactions";
    }

    @GetMapping("/all-transactions")
    public String AllTransactions(Model model){
        User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
        model.addAttribute("movs", ts.getAll(user.getId_user()));
        return "AllTransactions";
    }

    @PostMapping("/withdraw")
    public  String withdraw( @ModelAttribute("user_coin") User_CoinAdapter user_coin, RedirectAttributes redirect){
        if(((!user_coin.getId_coin().getId_coin().equals("BTC"))
                &&(!user_coin.getId_coin().getId_coin().equals("ETH"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDT"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDC")))
                ||user_coin.getBalance()<=0) {
            redirect.addFlashAttribute("message", "Es necesario cumplir con las condiciones dadas.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        User user = us.getOne(us.getGmailActualSesion());
        user_coin.getId_coin().setId_coin(user_coin.getId_coin().getId_coin().toLowerCase());

        User_Coin coin=ucs.findById(user.getId_user(), user_coin.getId_coin().getId_coin());
        if(user_coin.getBalance()>coin.getBalance()){
            redirect.addFlashAttribute("message", "No puedes retirar este monto.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        try{
        User_Coin uc = new User_Coin();
        Transaction tra=new Transaction();

        uc.setBalance(user_coin.getBalance());
        uc.setId_user(user);
        uc.setId_coin(user_coin.getId_coin());

        tra.setType(true);
        tra.setDate(new Timestamp(System.currentTimeMillis()));
        tra.setBalance(user_coin.getBalance());
        tra.setId_user(user);
        tra.setId_coin(cas.getOne(user_coin.getId_coin().getId_coin()));
        tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin())); //llamada a api externa
        tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin())); //llamada a api externa
        ts.save(tra);
        ts.cobrar(uc);

        redirect.addFlashAttribute("message", "Retiro realizado correctamente." )
               .addFlashAttribute("active", "success");
        return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de retiro." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }catch (Exception e){
            redirect.addFlashAttribute("message", "Falló el intento de retiro." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
    }

    @PostMapping("/deposit")
    public  String deposit(@ModelAttribute("user_coin") User_CoinAdapter user_coin, RedirectAttributes redirect){
        if(((!user_coin.getId_coin().getId_coin().equals("BTC"))
                &&(!user_coin.getId_coin().getId_coin().equals("ETH"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDT"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDC")))
                ||user_coin.getBalance()<=0){
            redirect.addFlashAttribute("message", "Es necesario cumplir con las condiciones dadas.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/external-entity";
        }
        try{
            User_Coin uc = new User_Coin();
            Transaction tra=new Transaction();

            User user = us.getOne(us.getGmailActualSesion());
            user_coin.getId_coin().setId_coin(user_coin.getId_coin().getId_coin().toLowerCase());

            uc.setBalance(user_coin.getBalance());
            uc.setId_user(user);
            uc.setId_coin(user_coin.getId_coin());

            tra.setType(false);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(user_coin.getBalance());
            tra.setId_user(user);
            tra.setId_coin(cas.getOne(user_coin.getId_coin().getId_coin()));
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin())); //llamada a api externa


            ts.depositar(uc);
            ts.save(tra);

            redirect.addFlashAttribute("message", "Deposito realizado correctamente." )
                    .addFlashAttribute("active", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de deposito." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        catch (Exception e){
            redirect.addFlashAttribute("message", "Falló el intento de deposito." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
    }

    @PostMapping("/transfer")
    public  String transfer(@ModelAttribute("user_coin") User_CoinAdapter user_coin, RedirectAttributes redirect){
        if(((!user_coin.getId_coin().getId_coin().equals("BTC"))
                &&(!user_coin.getId_coin().getId_coin().equals("ETH"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDT"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDC")))
                ||user_coin.getBalance()<=0
                ||user_coin.getId_destino()<=0) {
            redirect.addFlashAttribute("message", "Es necesario cumplir con las condiciones dadas.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        User user = us.getOne(us.getGmailActualSesion());
        user_coin.getId_coin().setId_coin(user_coin.getId_coin().getId_coin().toLowerCase());

        User_Coin coinConfirm=ucs.findById(user.getId_user(), user_coin.getId_coin().getId_coin());
        if(user_coin.getBalance()>coinConfirm.getBalance()){
            redirect.addFlashAttribute("message", "No puedes transferir este monto.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        try{
            User_Coin ucInicial = new User_Coin();
            Transaction traInicial=new Transaction();
            User_Coin ucDestino = new User_Coin();
            Transaction traUserDestino=new Transaction();
            double balance = user_coin.getBalance();

            User userDestino = us.getById(user_coin.getId_destino());

           CoinAdapter coin= cas.getOne(user_coin.getId_coin().getId_coin());

            ucInicial.setBalance(balance);
            ucInicial.setId_user(user);
            ucInicial.setId_coin(coin);

            ucDestino.setBalance(balance);
            ucDestino.setId_user(userDestino);
            ucDestino.setId_coin(coin);

            traInicial.setType(true);
            traInicial.setDate(new Timestamp(System.currentTimeMillis()));
            traInicial.setBalance(balance);
            traInicial.setId_user(user);
            traInicial.setId_coin(coin);
            traInicial.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin().toLowerCase())); //llamada a api externa

            traUserDestino.setType(false);
            traUserDestino.setDate(new Timestamp(System.currentTimeMillis()));
            traUserDestino.setBalance(balance);
            traUserDestino.setId_user(userDestino);
            traUserDestino.setId_coin(coin);
            traUserDestino.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin().toLowerCase()));

            ts.cobrar(ucInicial);
            ts.save(traInicial);

            ts.depositar(ucDestino);
            ts.save(traUserDestino);

            redirect.addFlashAttribute("message", "Transferencia realizada correctamente." )
                   .addFlashAttribute("active", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de transferencia." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }catch (Exception e){
            redirect.addFlashAttribute("message", "Falló el intento de transferencia." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
    }

    @PostMapping("/trade")
    public  String trade( @ModelAttribute("user_coin") User_CoinAdapter user_coin, RedirectAttributes redirect){
        if(((!user_coin.getId_coin().getId_coin().equals("BTC"))
                &&(!user_coin.getId_coin().getId_coin().equals("ETH"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDT"))
                &&(!user_coin.getId_coin().getId_coin().equals("USDC")))
                ||((!user_coin.getId_coin_destino().equals("BTC"))
                &&(!user_coin.getId_coin_destino().equals("ETH"))
                &&(!user_coin.getId_coin_destino().equals("USDT"))
                &&(!user_coin.getId_coin_destino().equals("USDC")))
                ||user_coin.getBalance()<=0) {
            redirect.addFlashAttribute("message", "Es necesario cumplir con las condiciones dadas.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        User user = us.getOne(us.getGmailActualSesion());
        user_coin.getId_coin().setId_coin(user_coin.getId_coin().getId_coin().toLowerCase());

        User_Coin coinConfirm=ucs.findById(user.getId_user(), user_coin.getId_coin().getId_coin());
        if(user_coin.getBalance()>coinConfirm.getBalance()){
            redirect.addFlashAttribute("message", "No puedes tradear este monto.")
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        try{
            User_Coin uc = new User_Coin();
            Transaction tra=new Transaction();
            User_Coin ucDestino = new User_Coin();
            Transaction traDestino=new Transaction();

            double balance = user_coin.getBalance();

            CoinAdapter coin= cas.getOne(user_coin.getId_coin().getId_coin());
            CoinAdapter coinDestino = cas.getOne(user_coin.getId_coin_destino());

            uc.setBalance(balance);
            uc.setId_user(user);
            uc.setId_coin(coin);

            double cotOrigen=0;
            double cotDestino=0;

            for(Coin coinc : ces.getAll()){
                if(coin.getId_coin().equals("btc")){
                    cotOrigen = ccc.findBtc().getAsk();
                }else if(coin.getId_coin().equals("eth")){
                    cotOrigen = ccc.findEth().getAsk();
                }else if(coin.getId_coin().equals("usdc")){
                    cotOrigen = ccc.findUsdc().getAsk();
                }else if(coin.getId_coin().equals("usdt")){
                    cotOrigen = ccc.findUsdt().getAsk();
                }
            }

            for(Coin coinc : ces.getAll()){
                if(coinDestino.getId_coin().equals("btc")){
                    cotDestino = ccc.findBtc().getAsk();
                }else if(coinDestino.getId_coin().equals("eth")){
                    cotDestino = ccc.findEth().getAsk();
                }else if(coinDestino.getId_coin().equals("usdc")){
                    cotDestino = ccc.findUsdc().getAsk();
                }else if(coinDestino.getId_coin().equals("usdt")){
                    cotDestino = ccc.findUsdt().getAsk();
                }
            }


            double conversion = (balance*cotOrigen)/cotDestino;

//100bc   -> x
//       ->y
            ucDestino.setBalance(conversion);
            ucDestino.setId_user(user);
            ucDestino.setId_coin(coinDestino);

            tra.setType(true);
            tra.setDate(new Timestamp(System.currentTimeMillis()));
            tra.setBalance(balance);
            tra.setId_user(user);
            tra.setId_coin(coin);
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin().toLowerCase())); //llamada a api externa

            traDestino.setType(false);
            traDestino.setDate(new Timestamp(System.currentTimeMillis()));
            traDestino.setBalance(conversion);
            traDestino.setId_user(user);
            traDestino.setId_coin(coinDestino);
            tra.setPrice_in_transaction(ces.getOne(user_coin.getId_coin().getId_coin().toLowerCase()));

            ts.cobrar(uc);
            ts.save(tra);

            ts.depositar(ucDestino);
            ts.save(traDestino);

            redirect.addFlashAttribute("message", "Trade realizado correctamente." )
                  .addFlashAttribute("active", "success");
            return "redirect:/app-view";
        }catch (NullPointerException e){
            e.fillInStackTrace();
            redirect.addFlashAttribute("message", "Falló el intento de tradeo." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
        catch (Exception e){
            redirect.addFlashAttribute("message", "Falló el intento de tradeo." )
                    .addFlashAttribute("active", "danger");
            return "redirect:/app-view";
        }
    }
}
