package com.example.demo.controllers;

import com.example.demo.models.Empresas;
import com.example.demo.models.Productos;
import com.example.demo.repositories.ProductosRepository;
import com.example.demo.util.PdfUtilEmpresas;
import com.example.demo.util.PdfUtilProductos;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/productos")
public class ProductosController {

    @Autowired
    private ProductosRepository productosRepository;
    @GetMapping(value = "/get")
    public ResponseEntity<?> getProducto(){
        List<Productos> productos = productosRepository.findAll();
        return ResponseEntity.ok(productos);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createProducto(@RequestBody Productos producto){
        productosRepository.save(producto);
        return ResponseEntity.ok("post post post productos");
    }

    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response) throws IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<Productos> productosList = productosRepository.findAll();

        PdfUtilProductos generator = new PdfUtilProductos();
        generator.setProductosList(productosList);
        generator.generate(response);
    }
}