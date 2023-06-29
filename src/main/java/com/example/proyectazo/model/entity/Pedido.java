package com.example.proyectazo.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_pedido")
    private Date fecha;

    @Column(name = "descripcion_pedido")
    private String descripcion;

    @Column(name = "observacion_pedido")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_local")
    Local local;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    Empleado empleado;
    

    // **Relación con Detalle_pedio
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_pedido")
    private List<DetallePedido> itemPedidos;

    public Pedido() {
        this.itemPedidos = new ArrayList<DetallePedido>();
    }

    @PrePersist
    public void prePersist() {
        this.fecha = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    public List<DetallePedido> getPedidos() {
        return itemPedidos;
    }

    public void setPedidos(List<DetallePedido> pedidos) {
        this.itemPedidos = pedidos;
    }
    
    public void addDetallePedido(DetallePedido detallePedido) {
        this.itemPedidos.add(detallePedido);
    }
 
    public Pedido(Long id, Date fecha, String descripcion, String observacion, Cliente cliente, Local local,
            Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.cliente = cliente;
        this.local = local;
        this.empleado = empleado;
    }
    
    public Pedido(Date fecha, String descripcion, String observacion, Cliente cliente, Local local, Empleado empleado) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.cliente = cliente;
        this.local = local;
        this.empleado = empleado;
    }

    public Pedido(Date fecha, String descripcion, String observacion, Cliente cliente, Local local, Empleado empleado,
            Long cantidad, Double total, Long producto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.cliente = cliente;
        this.local = local;
        this.empleado = empleado;
    }
    
    

}
