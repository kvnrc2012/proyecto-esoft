((d) => {
  console.log("holaaa");
  /* ========= sidebar toggle ======== */
  const sidebarNavWrapper = document.querySelector(".sidebar-nav-wrapper");
  const mainWrapper = document.querySelector(".main-wrapper");
  const menuToggleButton = document.querySelector("#menu-toggle");
  const menuToggleButtonIcon = document.querySelector("#menu-toggle i");
  const overlay = document.querySelector(".overlay");

  document.getElementById("gestion").addEventListener("click", (e) => {
    e.target.firstElementChild.classList.toggle("fa-chevron-down");
    e.target.firstElementChild.classList.toggle("fa-chevron-up");
    console.log("holaaa");
  });

  menuToggleButton.addEventListener("click", () => {
    sidebarNavWrapper.classList.toggle("active");
    overlay.classList.add("active");
    mainWrapper.classList.toggle("active");

    if (document.body.clientWidth > 1200) {
      if (menuToggleButtonIcon.classList.contains("lni-chevron-left")) {
        menuToggleButtonIcon.classList.remove("lni-chevron-left");
        menuToggleButtonIcon.classList.add("lni-menu");
        console.log("holaaa");
      } else {
        menuToggleButtonIcon.classList.remove("lni-menu");
        menuToggleButtonIcon.classList.add("lni-chevron-left");
        console.log("holaaa");
      }
    } else {
      if (menuToggleButtonIcon.classList.contains("lni-chevron-left")) {
        menuToggleButtonIcon.classList.remove("lni-chevron-left");
        menuToggleButtonIcon.classList.add("lni-menu");
        console.log("holaaa");
      }
    }
  });
  overlay.addEventListener("click", () => {
    sidebarNavWrapper.classList.remove("active");
    overlay.classList.remove("active");
    mainWrapper.classList.remove("active");
    console.log("hollaaaa");
  });
})(document);

// **Registros Opciones
((d) => {
  const txtcategoria = ["id", "name", "descripcion"],
    txtproveedor = ["id", "name", "direccion", "fecha", "email", "telefono"],
    txtmaterial = ["id", "name", "fecha", "precio", "stock"],
    txtlocal = ["id", "name", "direccion"],
    txtproducto = ["id", "categoria", "name", "fecha", "precio", "stock"],
    txtempleado = [
      "id",
      "name",
      "surname",
      "dni",
      "telefono",
      "nacimiento",
      "fecha",
      "email",
    ],
    txtcliente = [
      "id",
      "name",
      "surname",
      "dni",
      "fecha",
      "ciudad",
      "provincia",
      "direccion",
      "email",
      "telefono",
    ],
    txtpedido = [
      "id",
      "fecha",
      "cliente",
      "empleado",
      "local",
      "observacion",
      "descripcion",
    ];
  const // **Categoria

    path = "http://localhost:8080/",
    $editcategoria = d.querySelectorAll("#editcategoria"),
    $vercategoria = d.querySelectorAll("#vercategoria"),
    $eliminarcategoria = d.querySelectorAll("#eliminarcategoria"),
    $deletecategoria = d.getElementById("deletecategoria"),
    // * Proveedor
    $editproveedor = d.querySelectorAll("#editproveedor"),
    $verproveedor = d.querySelectorAll("#verproveedor"),
    // *Material
    $editmaterial = d.querySelectorAll("#editmaterial"),
    $vermaterial = d.querySelectorAll("#vermaterial"),
    $eliminarmaterial = d.querySelectorAll("#eliminarmaterial"),
    $deletematerial = d.getElementById("deletematerial"),
    // *Local
    $editlocal = d.querySelectorAll("#editlocal"),
    $verlocal = d.querySelectorAll("#verlocal"),
    $eliminarlocal = d.querySelectorAll("#eliminarlocal"),
    $deletelocal = d.getElementById("deletelocal"),
    // *Producto
    $editproducto = d.querySelectorAll("#editproducto"),
    $verproducto = d.querySelectorAll("#verproducto"),
    $eliminarproducto = d.querySelectorAll("#eliminarproducto"),
    $deleteproducto = d.getElementById("deleteproducto"),
    // *Empleado
    $editempleado = d.querySelectorAll("#editempleado"),
    $verempleado = d.querySelectorAll("#verempleado"),
    $eliminarempleado = d.querySelectorAll("#eliminarempleado"),
    $deleteempleado = d.getElementById("deleteempleado"),
    // *Cliente
    $editcliente = d.querySelectorAll("#editcliente"),
    $vercliente = d.querySelectorAll("#vercliente"),
    $eliminarcliente = d.querySelectorAll("#eliminarcliente"),
    $deletecliente = d.getElementById("deletecliente"),
    $pedidocliente = d.querySelectorAll("#pedidocliente"),
    // *Pedido
    $verPedido = d.querySelectorAll("#verpedido");

  ($buscar = d.getElementById("search")),
    ($select = d.getElementById("select"));

  const $inputNombre = d.getElementById("inputNombre");
  const $inputPrecio = d.getElementById("inputPrecio");
  const $inputCantidad = d.getElementById("inputCantidad");
  const $inputTotal = d.getElementById("inputTotal");

  //* Categoria
  $editcategoria.forEach((el) => {
    el.addEventListener("click", () => {
      txtcategoria.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR CATEGORIA";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $vercategoria.forEach((el) => {
    el.addEventListener("click", () => {
      txtcategoria.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER CATEGORIA";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarcategoria.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletecategoria.dataset.id = el.dataset.id;
    });
  });
  //* Proveedor
  $editproveedor.forEach((el) => {
    el.addEventListener("click", () => {
      d.getElementById("id").value = el.dataset.id;
      d.getElementById("nombre").value = el.dataset.name;
      d.getElementById("direccion").value = el.dataset.direccion;
      d.getElementById("fecha").value = el.dataset.fecha;
      d.getElementById("email").value = el.dataset.email;
      d.getElementById("telefono").value = el.dataset.telefono;

      d.getElementById("nombre").disabled = false;
      d.getElementById("direccion").disabled = false;
      d.getElementById("fecha").disabled = false;
      d.getElementById("email").disabled = false;
      d.getElementById("telefono").disabled = false;

      d.getElementById("exampleModalLabel").textContent = "EDITAR PROVEEDOR";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $verproveedor.forEach((el) => {
    el.addEventListener("click", () => {
      d.getElementById("id").value = el.dataset.id;
      d.getElementById("nombre").value = el.dataset.name;
      d.getElementById("direccion").value = el.dataset.direccion;
      d.getElementById("fecha").value = el.dataset.fecha;
      d.getElementById("email").value = el.dataset.email;
      d.getElementById("telefono").value = el.dataset.telefono;

      d.getElementById("nombre").setAttribute("disabled", "true");
      d.getElementById("direccion").setAttribute("disabled", "true");
      d.getElementById("fecha").setAttribute("disabled", "true");
      d.getElementById("email").setAttribute("disabled", "true");
      d.getElementById("telefono").setAttribute("disabled", "true");

      d.getElementById("exampleModalLabel").textContent = "VER PROVEEDOR";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  //* Material
  $editmaterial.forEach((el) => {
    el.addEventListener("click", () => {
      txtmaterial.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR MATERIAL";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $vermaterial.forEach((el) => {
    el.addEventListener("click", () => {
      txtmaterial.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER MATERIAL";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarmaterial.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletematerial.dataset.id = el.dataset.id;
    });
  });
  //* Local
  $editlocal.forEach((el) => {
    el.addEventListener("click", () => {
      txtlocal.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR LOCAL";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $verlocal.forEach((el) => {
    el.addEventListener("click", () => {
      txtlocal.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER LOCAL";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarlocal.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletelocal.dataset.id = el.dataset.id;
    });
  });
  //* Producto
  $editproducto.forEach((el) => {
    el.addEventListener("click", () => {
      txtproducto.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR PRODUCTO";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $verproducto.forEach((el) => {
    el.addEventListener("click", () => {
      txtproducto.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER PRODUCTO";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarproducto.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deleteproducto.dataset.id = el.dataset.id;
    });
  });
  //* Empleado
  $editempleado.forEach((el) => {
    el.addEventListener("click", () => {
      txtempleado.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR PRODUCTO";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $verempleado.forEach((el) => {
    el.addEventListener("click", () => {
      txtempleado.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER PRODUCTO";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarempleado.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deleteempleado.dataset.id = el.dataset.id;
    });
  });
  //* Cliente
  $editcliente.forEach((el) => {
    el.addEventListener("click", () => {
      txtcliente.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
        console.log("errr");
      });
      d.getElementById("exampleModalLabel").textContent = "EDITAR CLIENTE";
      d.getElementById("btn-guardar").style = "display : block";
    });
  });
  $vercliente.forEach((el) => {
    el.addEventListener("click", () => {
      txtcliente.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER CLIENTE";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  $eliminarcliente.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletecliente.dataset.id = el.dataset.id;
    });
  });
  console.log(d.getElementById("clientePedido"));
  $pedidocliente.forEach((el) => {
    el.addEventListener("click", (e) => {
      d.getElementById("clientePedido").value = el.dataset.id;
    });
  });
  //* Pedido
  $verPedido.forEach((el) => {
    el.addEventListener("click", () => {
      let id = el.dataset.id;
      fetch(path + "detalle/buscar/" + id)
        .then((res) => (res.ok ? res.json() : Promise.reject(res)))
        .then((json) => {
          console.log(json);
          if ($inputNombre && $inputPrecio) {
            fetch(path + "productos/buscar/" + json.producto)
              .then((res) => (res.ok ? res.json() : Promise.reject(res)))
              .then((json) => {
                console.log(json);
                if ($inputNombre) {
                  $inputNombre.value = json.nombre;
                }
                if ($inputPrecio) {
                  $inputPrecio.value = json.precio;
                }
              })
              .catch((err) => {
                console.log(err);
              });
          }
          if ($inputCantidad) {
            $inputCantidad.value = json.cantidad;
          }
          if ($inputTotal) {
            $inputTotal.value = json.total;
          }
        })
        .catch((err) => {
          console.log(err);
        });

      txtpedido.forEach((ele) => {
        console.log(eval(`el.dataset.${ele}`));
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "Detalle Pedido";
      d.getElementById("btn-guardar").style = "display : none";
    });
  });
  d.addEventListener("click", (e) => {
    if (
      e.target.matches("#agregarcategoria") ||
      e.target.matches("#iconcategoria")
    ) {
      txtcategoria.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    if (
      e.target.matches("#agregarproveedor") ||
      e.target.matches("#iconproveedor")
    ) {
      txtproveedor.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    if (
      e.target.matches("#agregarempleado") ||
      e.target.matches("#iconempleado")
    ) {
      txtempleado.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    if (
      e.target.matches("#agregarcliente") ||
      e.target.matches("#iconcliente")
    ) {
      txtcliente.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    if (
      e.target.matches("#agregarmaterial") ||
      e.target.matches("#iconproveedor")
    ) {
      txtmaterial.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    if (
      e.target.matches("#agregarproducto") ||
      e.target.matches("#iconproducto")
    ) {
      txtproducto.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
    }
    // Eliminación
    if (e.target.matches("#deletecategoria")) {
      window.location.href = `/categoria/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletematerial")) {
      window.location.href = `/material/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletelocal")) {
      window.location.href = `/local/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deleteproducto")) {
      window.location.href = `/producto/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deleteempleado")) {
      window.location.href = `/empleado/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletecliente")) {
      window.location.href = `/cliente/eliminar/${e.target.dataset.id}`;
    }

    if (e.target.matches("#buscarproducto")) {
    }
  });

  if ($inputCantidad) {
    $inputCantidad.addEventListener("input", () => {
      $inputTotal.value =
        $inputCantidad.value * d.getElementById("inputPrecio").value;
    });
  }

  // **Enviar Registros Paginación
  console.log(window.location.href);
  $select.addEventListener("change", (e) => {
    let a = window.location.href;
    let go = a.split("/");
    let num = $select.value;
    const path = "/" + go[3] + "/?numPage=" + num;
    console.log(path);
    window.location.href = path;
  });

  //** Buscar FETCH */
  const $productoBuscar = d.getElementById("productoBuscar");

  if ($productoBuscar) {
    $productoBuscar.addEventListener("change", () => {
      d.getElementById("busquedaProducto").style = "display: block";
      let path = d.getElementById("productoBuscar").value;

      console.log(path);
      fetch("http://localhost:8080/productos/buscar/" + path, {
        //FormData parsea automaticamente todos los elemntos del formulario
        /*Todos los inputs deben tener el atributo name*/
        mode: "cors",
      })
        .then((res) => (res.ok ? res.json() : Promise.reject(res)))
        .then((json) => {
          console.log(json);
          if ($inputNombre) {
            $inputNombre.value = json.nombre;
          }
          if ($inputPrecio) {
            $inputPrecio.value = json.precio;
          }
          if ($txtcantidad) {
            $txtcantidad.value = "";
          }
          if (txtlocal) {
            $txttotal.value = "";
          }
        })
        .catch((err) => {
          console.log(err);
        });
    });
  }
  const $quitarProducto = d.getElementById("quitarProducto");
  if ($quitarProducto) {
    $quitarProducto.addEventListener("click", () => {
      d.getElementById("busquedaProducto").style = "display: none";
    });
  }

  // * Mensaje De Confirmación Eliminación
  d.querySelectorAll("#eliminar").forEach((el) =>
    el.addEventListener("click", (e) => {
      if (confirm("Está Seguro de Eliminar El Registro?"))
        console.log("ELIMINADO:C");
      else e.preventDefault();
    })
  );
  // * Buscar
  let $names = Array.from(d.querySelectorAll("[data-nombre]"));
  console.log($names);
  if ($buscar) {
    $buscar.addEventListener("keyup", (e) => {
      let value = e.target.value.toLowerCase();
      console.log(value);

      if (value == "") {
        for (const name of $names) {
          console.log("HH");
          name.parentElement.style.display = "table-row";
          console.log(name.parentElement);
        }
      } else {
        for (const name of $names) {
          console.log("sdssd");
          console.log(name.dataset.nombre + "->>" + value);
          name.dataset.nombre.toLowerCase().indexOf(value) == -1
            ? (name.parentElement.style.display = "none")
            : (name.parentElement.style.display = "table-row");
        }
      }
    });
  }

  //* Petición FETCH
})(document);
