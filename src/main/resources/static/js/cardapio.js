function getCardapio(){
    $.ajax({
        url: "/cardapio",
        type: "GET",
        success: function (data) {
            document.getElementById("cardapio-list").innerHTML = "";

            data.forEach(produto => {
                document.getElementById("cardapio-list").innerHTML += `
                    <li><strong>${produto.nome}</strong> - R$ ${produto.preco.toFixed(2)}</li>
                `;
            });
        },
        error: function () {
            alert("Erro ao buscar os produtos...");
        }
    });
}