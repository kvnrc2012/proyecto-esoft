const formulario = document.getElementById("form");
const inputs = document.querySelectorAll("#form input");
console.log(inputs);

const expresiones = {
  email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
  password: /^[a-zA-Z0-9_.+-]{2,}$/,
};

const campos = {
  email: false,
  password: false,
};

const validarCampo = (expresion, input, campo) => {
  if (expresion.test(input.value)) {
    marcarCampoValido(campo);
    campos[campo] = true;
  } else {
    marcarCampoInvalido(campo);
    campos[campo] = false;
  }
};

const marcarCampoValido = (campo) => {
  const estadoElement = document.querySelector(
    `#${campo}-group .form__input-estado`
  );
  const errorElement = document.querySelector(
    `#${campo}-group .form__input-error`
  );

  estadoElement.style.color = "green";
  estadoElement.classList.add("fa-check-circle");
  estadoElement.classList.remove("fa-times-circle");
  errorElement.classList.remove("form__input-error--active");
};

const marcarCampoInvalido = (campo) => {
  const estadoElement = document.querySelector(
    `#${campo}-group .form__input-estado`
  );
  const errorElement = document.querySelector(
    `#${campo}-group .form__input-error`
  );

  estadoElement.style.color = "red";
  estadoElement.classList.add("fa-times-circle");
  estadoElement.classList.remove("fa-check-circle");
  errorElement.classList.add("form__input-error--active");
};

//*Principio Solid 2 - Open and Close
const validarFormulario = (e) => {
  const campo = e.target.name;
  validarCampo(eval(`expresiones.${campo}`), e.target, campo);
};

inputs.forEach((input) => {
  input.addEventListener("keyup", validarFormulario);
  input.addEventListener("blur", validarFormulario);
});

formulario.addEventListener("submit", (e) => {
  e.preventDefault();
  if (campos.email && campos.password) {
    formulario.reset();
    resetearCampos();
  }
});

//*Principio Solid 1 - Single Responsibility
const resetearCampos = () => {
  document.querySelectorAll(".form__input-estado").forEach((element) => {
    element.style.color = "black";
    element.classList.remove("fa-check-circle");
  });
};
