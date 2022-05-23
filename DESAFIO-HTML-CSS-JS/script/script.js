import { preencherFormularioCliente } from './util/clientes.js';
import { preencherFormularioProduto } from './util/produtos.js';
import { layout } from './util/layout.js'

layout();
preencherFormularioCliente(0);
preencherFormularioProduto(0);

window.alert = (type, msg) => {    
    let divPai = document.querySelector(".itens");
    let divNotificacao = document.createElement('div');
    divNotificacao.setAttribute("class", "notification show" + type);
    let spanImage = document.createElement("span");
    spanImage.setAttribute("class", "image material-symbols-outlined");
    let divText = document.createElement("div");
    divText.setAttribute("class", "text");
    divText.innerHTML = msg;
    let divclose = document.createElement("div");
    divclose.setAttribute("class", "close");
    divclose.innerHTML = "x";
    divclose.addEventListener("click", ()=> {
        divNotificacao.remove() 
    });    
    setTimeout(() => {
        divNotificacao.remove();
    }, 3000); 
}