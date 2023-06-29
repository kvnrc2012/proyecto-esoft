package com.example.proyectazo.controller;

import com.example.proyectazo.model.entity.Material;
import com.example.proyectazo.model.service.IMaterialService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/material")
public class MaterialController {
    
    @Autowired
    private IMaterialService materialService;

    @GetMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model) {

        int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
        int numPage = params.get("numPage") != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

        // int numPage = Integer.valueOf(params.get("numPage").toString());

        PageRequest pageRequest = PageRequest.of(page, numPage);
        Page<Material> pageMaterial = materialService.getAll(pageRequest);

        int totalPage = pageMaterial.getTotalPages();

        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }

        List<Integer> pages = myPages(totalPage);
        model.addAttribute("pages", pages);
        

        Material objMaterial = new Material();
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales", materialService.cargarMateriales());
        model.addAttribute("mensaje", "REGISTRAR MATERIAL");
        model.addAttribute("itxt", "a-active");
        model.addAttribute("list", pageMaterial.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);

        return "material/main";
    }
    


    public  List<Integer> myPages(int totalPage) {
        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
        return pages;
    }


    @RequestMapping("/editar/{id}")
    public String update(@PathVariable(value = "id") Long id,Model model){
        Material objMaterial = materialService.buscarMaterial(id);
        model.addAttribute("material", objMaterial);
        model.addAttribute("listaMateriales",materialService.cargarMateriales());
        model.addAttribute("material",objMaterial);
        return "material/main";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      materialService.eliminarMaterial(id);
      return "redirect:/material/";
    }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(@Valid Material material, BindingResult result, Model model, RedirectAttributes flash,@RequestParam Map<String, Object> params) {
        if (result.hasErrors()) {
            return "material/main";
        }
        
        String rpta = materialService.guardarMaterial(material);
        flash.addFlashAttribute("mensajeFinal", rpta);
        return "redirect:/material/";
    }
}
