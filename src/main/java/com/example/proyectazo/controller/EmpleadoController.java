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

import com.example.proyectazo.model.entity.Empleado;
import com.example.proyectazo.model.service.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    private IEmpleadoService empleadoService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Empleado> pageEmpleado = empleadoService.getAll(pageRequest);

            int totalPage = pageEmpleado.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Empleado objEmpleado = new Empleado();
        model.addAttribute("empleado", objEmpleado);
        model.addAttribute("listaEmpleados",empleadoService.cargaEmpleados());
        model.addAttribute("mensaje","REGISTRAR EMPLEADO");
        model.addAttribute("dtxt", "a-active");
        model.addAttribute("list",pageEmpleado.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "empleado/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      empleadoService.eliminarEmpleado(id);
      return "redirect:/empleado/";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Empleado local) {
        empleadoService.guardarEmpleados(local);
        return "redirect:/empleado/";
    }
}
