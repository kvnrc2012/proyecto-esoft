package com.example.proyectazo.controller;

import com.example.proyectazo.model.entity.Proveedor;
import com.example.proyectazo.model.service.IProveedorService;

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
@RequestMapping("/proveedor")
public class ProveedoresController {
    @Autowired
    private IProveedorService proveedorService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {
        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

        // int numPage = Integer.valueOf(params.get("numPage").toString());

        PageRequest pageRequest = PageRequest.of(page, numPage);
        Page<Proveedor> pageProveedor = proveedorService.getAll(pageRequest);

        int totalPage = pageProveedor.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        Proveedor objProveedor = new Proveedor();
        model.addAttribute("proveedor", objProveedor);
        model.addAttribute("listaProveedores", proveedorService.cargarProveedores());

        model.addAttribute("listaProveedores", proveedorService.cargarProveedores());

        model.addAttribute("mensaje", "REGISTRAR PROVEEDOR");
        model.addAttribute("gtxt", "a-active");
        model.addAttribute("list", pageProveedor.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "proveedor/main";
    }

    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id,Model model){
        Proveedor objCategoria = proveedorService.buscarProveedor(id);
        model.addAttribute("categoria", objCategoria);
        model.addAttribute("listaCategorias",proveedorService.cargarProveedores());
        model.addAttribute("categoria",objCategoria);
        return "proveedor/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      proveedorService.eliminarProveedor(id);
      return "redirect:/proveedor/";
    }
    @RequestMapping("/ver/{id}")
    public String show(){
      return "proveedor/main";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Proveedor proveedor){
       proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedor/";
    }
    @RequestMapping("/buscar/")
    public String listarbusqueda(Model model,Long id){
        if(id == null){
            Proveedor objProveedor = new Proveedor();
            model.addAttribute("listaProveedores",proveedorService.cargarProveedores());
            model.addAttribute("proveedor", objProveedor);
        }else{
            Proveedor objProveedor = proveedorService.buscarProveedor(id);
            model.addAttribute("listaProveedores", proveedorService.buscarProveedor(id));
            model.addAttribute("proveedor", objProveedor);
        }
        return "proveedor/main";
    }

}
