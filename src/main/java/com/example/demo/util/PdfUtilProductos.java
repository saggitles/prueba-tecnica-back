package com.example.demo.util;

import com.example.demo.models.Productos;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PdfUtilProductos {

    private List<Productos> productosList;

    public void setProductosList(List<Productos> productosList){
        this.productosList= productosList;
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
        Paragraph paragraph = new Paragraph("Lista de Productos", fontTiltle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(5);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 5, 5, 5, 5, 5});
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
        cell.setPhrase(new Phrase("Codigo", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Nombre del producto", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Caracteristicas", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Precio", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Empresa", font));
        table.addCell(cell);

        // Iterating over the list of students
        for (Productos producto : productosList) {
            table.addCell(String.valueOf(producto.getCodigo()));
            table.addCell(producto.getNombreProducto());
            table.addCell(producto.getCaracteristicas());
            table.addCell(producto.getPrecio());
            table.addCell(producto.getEmpresa());
        }
        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();
    }
}

