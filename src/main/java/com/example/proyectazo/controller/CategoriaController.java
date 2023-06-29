package com.example.proyectazo.controller;

import com.example.proyectazo.model.entity.Categoria;
import com.example.proyectazo.model.service.ICategoriaService;

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


@Controller
@RequestMapping({"/categoria"})
public class CategoriaController {
    
    @Autowired
    private ICategoriaService categoriaService;
    
    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Categoria> pageCategoria = categoriaService.getAll(pageRequest);

            int totalPage = pageCategoria.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Categoria objCategoria = new Categoria();
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias",categoriaService.cargarCategorias());
        model.addAttribute("mensaje","REGISTRAR CATEGORIA");
        model.addAttribute("btxt", "a-active");
        model.addAttribute("list",pageCategoria.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "categoria/main";
    }
    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id,Model model){
        Categoria objCategoria = categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias",categoriaService.cargarCategorias());
        return "categoria/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      categoriaService.eliminarCategoria(id);
      return "redirect:/categoria/";
    }
    @RequestMapping("/ver/{id}")
    public String show(){
      return "categoria/main";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categoria/";
    }   
}
