package com.example.compuservicessoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogoController {

    @RequestMapping("/catalogo.html/**")
    public String showCatalogo() {
        return "catalogo.html"; // Devuelve el archivo HTML de catálogo
    }
}