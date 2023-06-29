const formulario = document.getElementById("form");
const inputs = document.querySelectorAll("#form input");
console.log(inputs);
const expresiones = {
  correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
  password: /^[a-zA-Z0-9_.+-]{2,}$/,
};

const campos = {
  email: false,
  password: false,
};

const validarFormulario = (e) => {
  if (e.target.name == "password") {
    validarCampo(expresiones.password, e.target, e.target.name);
  }
  if (e.target.name == "correo") {
    validarCampo(expresiones.correo, e.target, e.target.name);
  }
};

const validarCampo = (expresion, input, campo) => {
  if (expresion.test(input.value)) {
    document.querySelector(`#${campo}-group .form__input-estado`).style =
      "color : green";
    document
      .querySelector(`#${campo}-group .form__input-estado`)
      .classList.add("fa-check-circle");
    document
      .querySelector(`#${campo}-group .form__input-estado`)
      .classList.remove("fa-times-circle");
    document
      .querySelector(`#${campo}-group .form__input-error`)
      .classList.remove("form__input-error--active");
    campos[campo] = true;
  } else {
    document.querySelector(`#${campo}-group .form__input-estado`).style =
      "color : red";
    document
      .querySelector(`#${campo}-group .form__input-estado`)
      .classList.add("fa-times-circle");
    document
      .querySelector(`#${campo}-group .form__input-estado`)
      .classList.remove("fa-check-circle");
    document
      .querySelector(`#${campo}-group .form__input-error`)
      .classList.add("form__input-error--active");
    campos[campo] = false;
  }
};

inputs.forEach((input) => {
  input.addEventListener("keyup", validarFormulario);
  input.addEventListener("blur", validarFormulario);
});

formulario.addEventListener("submit", (e) => {
  e.preventDefault();
  if (campos.email && campos.password) {
    form.reset();
    inputs.forEach((el) => {
      document
        .querySelectorAll(`.form-group__input .form__input-estado`)
        .forEach((el) => {
          el.style = "color = black";
        });
    });
    document.querySelectorAll(`.form__input-estado`).forEach((el) => {
      el.classList.remove("fa-check-circle");
    });
  }
});
