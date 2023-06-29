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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.proyectazo.model.entity.Local;
import com.example.proyectazo.model.service.ILocalService;


@Controller
@RequestMapping("/local")
public class LocalController {
    
    @Autowired
    private ILocalService localService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Local> pageLocal = localService.getAll(pageRequest);

            int totalPage = pageLocal.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Local objLocal = new Local();
        model.addAttribute("local", objLocal);
        model.addAttribute("listaLocales",localService.cargarLocales());
        model.addAttribute("mensaje","REGISTRAR CATEGORIA");
        model.addAttribute("htxt", "a-active");
        model.addAttribute("list",pageLocal.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "local/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      localService.eliminarLocal(id);
      return "redirect:/local/";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Local local) {
        System.out.println(local.getId());
        System.out.println(local.getNombre());
        System.out.println(local.getDireccion());
        localService.guardarLocales(local);
        return "redirect:/local/";
    }

}
