import { validaForm, renderizaUmErro } from './validaForm.js';

const btnSubmitLogin = document.querySelector("#login button");
const usuarioInput = document.querySelector("#usuario");
const senhaInput = document.querySelector("#senha");
const formLogin = document.querySelector("#login form");

formLogin.addEventListener("submit", e => {
    if (validaForm("login", e)) login();
});

const fetchData = async () => {
    try {
        const res = await fetch('../../repositorio/UsuarioRepositorio.json');
        let usuarios = await res.json();
        return usuarios.usuarios;
    } catch (err) {
        console.log(err);
    }
};

fetchData();

const login = async () => {
    let usuarioParaLogar = { usuario: usuarioInput.value, senha: senhaInput.value };
    btnSubmitLogin.innerHTML = btnSubmitLogin.dataset.loading;
    setTimeout(async () => {
        let usuarios = await fetchData()
        let procurarUser = usuarios.find(usuarios => (usuarios.usuario == usuarioParaLogar.usuario));
        let procurarSenha = usuarios.find(usuarios => (usuarios.senha == usuarioParaLogar.senha && usuarios.usuario == usuarioParaLogar.usuario));
        btnSubmitLogin.innerHTML = btnSubmitLogin.dataset.text;        
        if (!procurarUser) return renderizaUmErro(usuarioInput, usuarioInput, "Usuário não existe.");
        if (procurarUser && !procurarSenha) return renderizaUmErro(senhaInput, senhaInput, "Senha inválida.");
        return loginAutorizado();
    }, 777);
};

const loginAutorizado = () => {
    window.location.href = "../../panel.html";
};




