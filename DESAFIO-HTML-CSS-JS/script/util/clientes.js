import { clientes } from '../../repositorio/ClienteRepositorio.js';
import { validaForm } from './validaForm.js';

const inputClienteDesde = document.querySelector("#dataCadastroCliente");
const inputNome = document.querySelector("#nomeCliente");
const inputCod = document.querySelector("#codigoCliente");
const btnAvancar = document.querySelector("#clientes .btnAvancar");
const btnSalvar = document.querySelector("#clientes .btnSalvar");
const btnVoltar = document.querySelector("#clientes .btnVoltar");
const btnNovo = document.querySelector("#clientes .btnNovo");
const campos = document.querySelectorAll("#clientes input");
const formCliente = document.querySelector("#clientes form");

let clientesArow = 0;
let criandoNovoCliente = false;

btnNovo.addEventListener("click", () => criarNovoUsuario());
btnVoltar.addEventListener("click", () => proximoOuAnterior("previous"));
btnAvancar.addEventListener("click", () => proximoOuAnterior("next"));
formCliente.addEventListener("submit", e => {
    if (validaForm("clientes", e)) {
        salvarNovoUsuario();
    }
})

const criarNovoUsuario = () => {
    clientesArow++;
    criandoNovoCliente = true;
    inputNome.value = "";
    inputNome.disabled = false;
    inputNome.focus();

    let hoje = new Date().toISOString().slice(0, 10);
    inputClienteDesde.value = hoje;

    let ultimoCodeCliente = clientes[clientes.length - 1].codCliente;
    inputCod.value = ultimoCodeCliente + 1;
    btnSalvar.classList.add("valid");
}

const salvarNovoUsuario = () => {
    let valor = {};
    campos.forEach(element => {
        if (element.name == "cod") {
            return valor[element.name] = Number(element.value);
        }
        valor[element.name] = element.value;
    })

    clientes.push(valor);
    clientesArow = 0;
    criandoNovoCliente = false;
    inputNome.disabled = true;
    alert("success", "Cliente cadastrado com sucesso!");
    preencherFormularioCliente(clientesArow);
    btnSalvar.classList.remove("valid");
}

export const preencherFormularioCliente = inicio => {
    document.querySelector("#clientes h1").textContent = `Clientes (${clientes.length})`;
    campos.forEach(element => element.value = clientes[inicio][element.name]);
    clientesArow == 0 ? btnVoltar.classList.add("invalid") : btnVoltar.classList.remove("invalid");
    clientesArow == clientes.length - 1 ? btnAvancar.classList.add("invalid") : btnAvancar.classList.remove("invalid");
}

const proximoOuAnterior = acao => {
    if (criandoNovoCliente) { 
        criandoNovoCliente = false;
        inputNome.disabled = true;
    }
    btnSalvar.classList.remove("valid");
    document.querySelectorAll("#clientes .input-error").forEach(input => input.classList.remove("input-error"));
    document.querySelectorAll("#clientes .valida-erro").forEach(input => input.remove());

    if (clientesArow >= clientes.length - 1 && acao === "next") return alert("info", "Este é o último registro!");
    if (clientesArow == 0 && acao === "previous") return alert("info", "Este é o primeiro registro!");

    acao === "next" ? clientesArow++ : clientesArow--;

    preencherFormularioCliente(clientesArow);
}