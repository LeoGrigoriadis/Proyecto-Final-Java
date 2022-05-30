package com.apiCrypto.apiCrypto.reportes;

import java.util.List;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.lowagie.text.pdf.PdfTable;

public class TransactionPdfReport {
    List<Transaction> transactionList;
    
    public TransactionPdfReport(List<Transaction> transactionList){
        this.transactionList = transactionList;
    }

    public void HeaderTable(PdfTable table){
        
    }
}
