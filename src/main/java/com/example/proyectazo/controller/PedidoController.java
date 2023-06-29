package com.example.proyectazo.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.proyectazo.model.entity.Pedido;
import com.example.proyectazo.model.service.IPedidoService;


@Controller
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private IPedidoService pedidoService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Pedido> pagePedido = pedidoService.getAll(pageRequest);

            int totalPage = pagePedido.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Pedido objPedido = new Pedido();
        model.addAttribute("pedido", objPedido);
        model.addAttribute("listaPedidos",pedidoService.cargarPedidos());
        model.addAttribute("mensaje","REGISTRAR CATEGORIA");
        model.addAttribute("etxt", "a-active");
        model.addAttribute("list",pagePedido.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "pedido/main";
    }

}
