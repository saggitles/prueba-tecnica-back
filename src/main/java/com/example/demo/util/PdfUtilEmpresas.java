package com.example.demo.util;
import java.io.IOException;
import java.util.List;


import com.example.demo.models.Empresas;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

public class PdfUtilEmpresas {
    private List<Empresas> empresasList;

    public void setEmpresasList(List<Empresas> empresasList){
        this.empresasList= empresasList;
    }

    public void generate(HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("Lista de Empresas", fontTiltle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(4);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 4, 4, 4, 4 });
        table.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Nit", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nombre de la empresa", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Dirección", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Telefono", font));
        table.addCell(cell);

        // Iterating over the list of students
        for (Empresas student : empresasList) {
            // Adding student id
            table.addCell(String.valueOf(student.getNit()));
            // Adding student name
            table.addCell(student.getNombreEmpresa());
            // Adding student section
            table.addCell(student.getDireccion());
            table.addCell(student.getTelefono());
        }
        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();
}}
