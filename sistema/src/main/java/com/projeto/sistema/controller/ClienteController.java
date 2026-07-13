package com.projeto.sistema.controller;

import com.projeto.sistema.models.Cliente;
import com.projeto.sistema.repository.CidadeRepository;
import com.projeto.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/cadastroCliente")
    public ModelAndView cadastrar(Cliente cliente){
        ModelAndView mv = new ModelAndView("admin/clientes/cadastro");
        mv.addObject("cliente",cliente);
        mv.addObject("listaCidades",cidadeRepository.findAll());
        return mv;
    }

    @PostMapping("/salvarCliente")
    public ModelAndView salvar(Cliente cliente, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(cliente);
        }
        clienteRepository.saveAndFlush(cliente);
        return cadastrar(new Cliente());
    }

    @GetMapping("/editarCliente/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cadastrar(cliente.get());
    }

    @GetMapping("/listarCliente")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("admin/clientes/lista");
        mv.addObject("listaClientes", clienteRepository.findAll());
        return mv;
    }

    @GetMapping("/removerCliente/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente.get());
        return listar();
    }
    


}
