package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Gustavo Chavarría
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC");

        var clientes = clienteService.getClientes();
        //var clientes = Arrays.asList(); Ocultar listas
        model.addAttribute("clientes", clientes);

        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
            
}
