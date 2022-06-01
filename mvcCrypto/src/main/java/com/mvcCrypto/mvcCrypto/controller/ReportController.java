package com.mvcCrypto.mvcCrypto.controller;

import com.lowagie.text.DocumentException;
import com.mvcCrypto.mvcCrypto.controller.service.TransactionService;
import com.mvcCrypto.mvcCrypto.controller.service.UserService;
import com.mvcCrypto.mvcCrypto.model.User;
import com.mvcCrypto.mvcCrypto.reportes.TransactionPdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ReportController {

    @Autowired
    private TransactionService ts;
    @Autowired
    private UserService us;

    @GetMapping("/get-pdf")
    public void reportTransactionPDFbyUser(HttpServletResponse response) throws DocumentException, IOException {
        User user=us.getOne(us.getGmailActualSesion()); //el usuario en sesión actual
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","transactions.pdf");
        TransactionPdfReport pdf = new TransactionPdfReport(ts.getAll(user.getId_user()));
        pdf.export(response);
    }
}
