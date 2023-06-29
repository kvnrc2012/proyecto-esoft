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

import com.example.proyectazo.model.entity.Cliente;
import com.example.proyectazo.model.entity.DetallePedido;
import com.example.proyectazo.model.entity.Pedido;
import com.example.proyectazo.model.service.IClienteService;
import com.example.proyectazo.model.service.IDetallePedidoService;
import com.example.proyectazo.model.service.IEmpleadoService;
import com.example.proyectazo.model.service.ILocalService;
import com.example.proyectazo.model.service.IPedidoService;
import com.example.proyectazo.model.service.IProductoService;

@Controller
@RequestMapping({"/cliente"})
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ILocalService localService;

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> params, Model model){
            int page = params.get("page")  != null ? (Integer.valueOf(params.get("page").toString()) -1 ) : 0;
            int numPage = params.get("numPage")  != null ? (Integer.valueOf(params.get("numPage").toString())) : 5;

            // int numPage = Integer.valueOf(params.get("numPage").toString());

            PageRequest pageRequest = PageRequest.of(page,numPage);
            Page<Cliente> pageCliente = clienteService.getAll(pageRequest);

            int totalPage = pageCliente.getTotalPages();

            if(totalPage > 0){
                List<Integer> pages = IntStream.rangeClosed(1,totalPage).boxed().collect(Collectors.toList());
                model.addAttribute("pages",pages);
            }
        Cliente objCliente = new Cliente();
        model.addAttribute("cliente", objCliente);
        model.addAttribute("listaClientes",clienteService.cargarClientes());
        model.addAttribute("mensaje","REGISTRAR CLIENTE");
        model.addAttribute("ctxt", "a-active");
        model.addAttribute("list",pageCliente.getContent());
        model.addAttribute("current",page+1);
        model.addAttribute("next", page+2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);
        model.addAttribute("numPage", numPage);


        Pedido objPedido = new Pedido();
        model.addAttribute("pedido", objPedido);

        // **Productos
        model.addAttribute("listaProductos", productoService.cargarProductos());

        model.addAttribute("listaLocales", localService.cargarLocales());

        model.addAttribute("listaEmpleados", empleadoService.cargaEmpleados());


        return "cliente/main";
    }

    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id,Model model){
      clienteService.eliminarCliente(id);
      return "redirect:/cliente/";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String store(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }
    
    @RequestMapping(value = "/formPedido", method = RequestMethod.POST )
    public String store(
    @RequestParam("producto") Long producto, 
    @RequestParam("cantidad") Long cantidad,
    @RequestParam("total") Double total,
    Pedido pedido) {

        System.out.println("Id Pedido :"+pedido.getId());
        System.out.println("Fecha :"+pedido.getFecha());
        System.out.println("Descirpción :"+pedido.getDescripcion());
        System.out.println("Observación :"+pedido.getObservacion());
        System.out.println("Id Cliente :"+pedido.getCliente().getId());
        System.out.println("Id Empleado :"+pedido.getEmpleado().getId());
        System.out.println("Id Local :" + pedido.getLocal().getId());
        System.out.println("Id Producto :" + producto);
        System.out.println("Cantidad :" + cantidad);
        System.out.println("Total :"+ total);
        
        Pedido miPedido = new Pedido(
                pedido.getFecha(),
                pedido.getDescripcion(),
                pedido.getObservacion(),
                pedido.getCliente(),
                pedido.getLocal(),
               pedido.getEmpleado());
        pedidoService.guardarPedido(miPedido);
                    
        DetallePedido detallePedido = new DetallePedido(
                cantidad,
                total,
                producto,
                pedidoService.buscarMaximo());
                
        detallePedidoService.guardarDetallePedido(detallePedido);     
        return "redirect:/cliente/";
    }


}
