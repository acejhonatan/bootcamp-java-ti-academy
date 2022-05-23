import { clientes } from '../../repositorio/ClienteRepositorio.js';
import { produtos } from '../../repositorio/ProdutoRepositorio.js';
import { validaForm, renderizaUmErro } from './validaForm.js';

const inputIdCliente = document.querySelector("#pedidos input[name='codCliente");
const inputNomeCliente = document.querySelector("#pedidos input[name='nomeCliente']");
const inputCodProduto = document.querySelector("#codProduto");
const inputDescProduto = document.querySelector("#descricao");
const inputPrecoProduto = document.querySelector("#valor");
const campos = document.querySelectorAll("#formPedidos input");
const tabela = document.querySelector(".table-pedido tbody");
const divTotal = document.querySelector("#total span");
const boxFormPedido = document.querySelector('.box-form-pedido');

let pedidos = [];

document.querySelector("#formPedidos").addEventListener("submit", e => {
    if (validaForm("formPedidos", e)) { salvarPedido(); }
});

inputIdCliente.addEventListener("keyup", e => procurarNomeCliente(e));
inputIdCliente.addEventListener("change", e => procurarNomeCliente(e));
inputCodProduto.addEventListener("keyup", e => procurarProduto(e));
inputCodProduto.addEventListener("change", e => procurarProduto(e));

const procurarNomeCliente = e => {
    let nome = clientes.find(cliente => cliente.codCliente == e.target.value);
    inputNomeCliente.value = nome !== undefined ? nome.nomeCliente : "";
};

const procurarProduto = e => {
    let produto = produtos.find(produto => produto.codProduto == e.target.value)
    inputDescProduto.value = produto !== undefined ? produto.descProduto : ''
    inputPrecoProduto.value = produto !== undefined ? produto.precoProduto : ''
}

const salvarPedido = () => {
    let item = {};
    campos.forEach(element => {
        if (element.name) {
            item[element.name] = element.value;
        }
    })

    let clienteExiste = clientes.find(cliente => cliente.codCliente  == item.codCliente);
    if (!clienteExiste) return renderizaUmErro(inputIdCliente, inputIdCliente, "Cliente não encontrado.");

    let produtoExiste = produtos.find(produto => produto.codProduto  == item.codProduto)
    if (!produtoExiste) return renderizaUmErro(inputCodProduto, boxFormPedido, "Produto não encontrado.")

    let itemJaAdicionado = pedidos.find(pedido => pedido.codProduto == item.codProduto);

    if (itemJaAdicionado) {
        renderizaUmErro(inputCodProduto, boxFormPedido, `${item.descProduto} já está no pedido!`);
        return marcarUmItemNaTabela(item);
    }

    if (verificarEstoque(item)) {
        document.querySelector("#pedidos input[name='quantidadeProduto']").value = "";
        document.querySelector("#pedidos input[name='quantidadeProduto']").focus();
        return alert("error", "Estoque insuficiente.<br> Estoque disponível: " + verificarEstoque(item));
    }

    pedidos.push(item);
    renderizaItens();
};

const verificarEstoque = item => {
    let tem = false;
    produtos.forEach(element => {
        if (element.codProduto == item.codProduto) {
            if (Number(item.quantidadeProduto) > Number(element.qtdEstoqueProd)) {
                tem = element.qtdEstoqueProd;
            }
        }
    })
    return tem;
};

const criaTr = (tabela, itens, id) => {
    let tr = document.createElement("tr");
    itens.forEach(item => {
        let td = document.createElement("td");
        td.textContent = item;
        tr.appendChild(td);
    });
    let tdDelete = document.createElement("td");
    tdDelete.textContent = "delete";
    tdDelete.setAttribute("class", "material-symbols-outlined btn-delete");
    tdDelete.addEventListener("click", () => {
        removerItem(id);
    });
    tr.appendChild(tdDelete);
    tr.setAttribute("data-id", id);
    tabela.append(tr);
};

const renderizaItens = () => {
    tabela.innerHTML = "";
    pedidos.forEach(item => {
        let dadosDaTabela = [
            item.codProduto,
            item.descProduto,
            moedaBrasileira(item.precoProduto),
            item.quantidadeProduto,
            moedaBrasileira(item.precoProduto * item.quantidadeProduto)
        ]
        criaTr(tabela, dadosDaTabela, item.codProduto);
    });
    let total = pedidos.reduce((a, b) => a + Number(b.precoProduto * b.quantidadeProduto), 0);
    divTotal.textContent = moedaBrasileira(total);
    limparFormularioPedidos();
};

const removerItem = id => {
    let item = pedidos.filter(item => item.codProduto == id);
    if (window.confirm(`Remover ${item[0].descProduto} do pedido?`)) {
        pedidos = pedidos.filter(element => Number(element.codProduto) != Number(id));
        renderizaItens();
    }
};

const limparFormularioPedidos = () => {
    document.querySelector("#formPedidos input[name='codProduto']").value = "";
    document.querySelector("#formPedidos input[name='descProduto']").value = "";
    document.querySelector("#formPedidos input[name='precoProduto']").value = "";
    document.querySelector("#formPedidos input[name='quantidadeProduto']").value = "";
    document.querySelector("#formPedidos input[name='codProduto']").focus();
};

const moedaBrasileira = num => Number(num).toLocaleString("pt-br", { style: "currency", currency: "brl" });

const marcarUmItemNaTabela = item => {
    let tr = document.querySelector(`.table-pedido tr[data-id="${item.codProduto}"]`);
    tr.classList.add("tr-marcada");
    limparFormularioPedidos();
    setTimeout(() => tr.classList.remove("tr-marcada"), 2000);

}