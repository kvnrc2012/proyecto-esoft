package com.example.proyectazo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "detalle_pedido")
public class DetallePedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_detalle_pedido")
    private Long id;

    @Column(name = "cantidad_detalle_pedido")
    private Long cantidad;

    @Column(name = "total_detalle_pedido")
    private double total;

    @Column(name = "id_producto")
    private Long producto;

    @Column(name = "id_pedido")
    private Long pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }
    
    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public DetallePedido() {
        
    }

    public DetallePedido(Long cantidad, double total, Long producto, Long pedido) {

        this.cantidad = cantidad;
        this.total = total;
        this.producto = producto;
        this.pedido = pedido;
    }
    
    
}
