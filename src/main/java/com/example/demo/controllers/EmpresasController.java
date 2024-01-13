package com.example.demo.controllers;

import com.example.demo.models.Empresas;
import com.example.demo.repositories.EmpresasRepository;
import com.example.demo.util.PdfUtilEmpresas;
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
@CrossOrigin("*")
@RequestMapping(value = "/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasRepository empresasRepository;
    @GetMapping(value = "/get")
    public ResponseEntity<?> getEmpresa(){
        List<Empresas> empresas = empresasRepository.findAll();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmpresa(@RequestBody Empresas empresa){
        empresasRepository.save(empresa);
        return ResponseEntity.ok("post");
    }



    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response) throws IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<Empresas> empresasList = empresasRepository.findAll();

        PdfUtilEmpresas generator = new PdfUtilEmpresas();
        generator.setEmpresasList(empresasList);
        generator.generate(response);

    }
}
