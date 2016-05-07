package com.smogorzhevskiy.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Contract;
import com.smogorzhevskiy.entities.Picture;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 07.05.16.
 */
@Component
public class CreatePdf {
    public String create(Contract contract) throws DocumentException, IOException {
        String CATALINA_HOME = "C:\\Other\\apache-tomcat-8.0.33\\pdf\\";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(CATALINA_HOME +contract.getArtist().getCredential().getLogin()+".pdf"));
        document.open();

        document.add(new Paragraph("Publisher info"));
        document.add(new Paragraph("Name: "+contract.getArtist().getName()));
        document.add(new Paragraph("Email: "+contract.getArtist().getCredential().getEmail()));
        document.add(new Paragraph("Phone Number: "+contract.getArtist().getGallery()));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Artist sign:_________________________"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Admin sign:_________________________"));

        document.close();
        return CATALINA_HOME +contract.getArtist().getCredential().getLogin()+".pdf";
    }
}