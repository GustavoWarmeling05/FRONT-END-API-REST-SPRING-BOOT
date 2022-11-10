let formulario = document.querySelector("form")

let inome = document.querySelector('.nome')
let iemail = document.querySelector('.email')
let isenha = document.querySelector('.senha')
let itelefone = document.querySelector('.telefone')

function cadastrar() {

    fetch('http://localhost:8080/users',
        {
            method: "POST",
            body: JSON.stringify({
                nome: inome.value,
                email: iemail.value,
                senha: isenha.value,
                telefone: itelefone.value
            }),
            headers: { "Content-type": "application/json; charset=UTF-8" }
        }
    )
    .then((response) => response.json())
    .then((json) => console.log(json));

}

formulario.addEventListener('submit', function (event) {
    event.preventDefault()

    dados = {
        nome: inome.value,
        email: iemail.value,
        senha: isenha.value,
        telefone: itelefone.value
    }

    cadastrar()
    obrigado()

})

function obrigado(){
    window.location.href = "obrigado.html"
  }