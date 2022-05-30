package com.apiCrypto.apiCrypto.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.apiCrypto.apiCrypto.model.Transaction;

public class TransactionPdfReport {
    List<Transaction> transactionList;
    
    public TransactionPdfReport(List<Transaction> transactionList){
        this.transactionList = transactionList;
    }

    public void HeaderTable(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.cyan);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("Nombre"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Fecha"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Tipo de Movimiento"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Monto"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Coin"));
        table.addCell(cell);

    }

    public void BodyTable(PdfPTable table)
    {
        for(Transaction t: transactionList)
        {
        		table.addCell(t.getId_user().getFirst_name());
        		table.addCell(String.valueOf(t.getDate()));
                if(t.isType() == true){
                    table.addCell("Deposito");
                }else{
                    table.addCell("Extraccion");
                }
        		table.addCell(String.valueOf(t.getPrice_in_transaction()));
        		table.addCell(t.getId_coin().getName()) ;
        		      			
        }
    }

    public void export(HttpServletResponse hsr) throws DocumentException, IOException
    {
        Document doc = new Document(PageSize.A4);
        PdfWriter.getInstance(doc, hsr.getOutputStream());
        doc.open();
        Paragraph paragraph = new Paragraph("transaction movement");
        paragraph.setSpacingAfter(5);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);
        doc.add(paragraph);
        PdfPTable pdf = new PdfPTable(5);
        HeaderTable(pdf);
        BodyTable(pdf);
        doc.add(pdf);
        doc.close();
    }

    }

