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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectazo.model.entity.Producto;
import com.example.proyectazo.model.service.ICategoriaService;
import com.example.proyectazo.model.service.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Producto> pageProducto = productoService.getAll(pageRequest);

            int totalPage = pageProducto.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Producto objProducto = new Producto();
        model.addAttribute("producto", objProducto);
        model.addAttribute("listaProductos", productoService.cargarProductos());
        
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());

        model.addAttribute("mensaje","REGISTRAR PRODUCTO");
        model.addAttribute("atxt", "a-active");
        model.addAttribute("list",pageProducto.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        return "producto/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      productoService.eliminarProducto(id);
      return "redirect:/producto/";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Producto producto,RedirectAttributes flash) {
        System.out.println(producto.getId());
        System.out.println(producto.getCategoria().getId());
        System.out.println(producto.getNombre());
        System.out.println(producto.getFecha());
        System.out.println(producto.getPrecio());
        System.out.println(producto.getStock());
        String rpta = productoService.guardarProducto(producto);
        System.out.println(rpta);
        return "redirect:/producto/";
    }

}
