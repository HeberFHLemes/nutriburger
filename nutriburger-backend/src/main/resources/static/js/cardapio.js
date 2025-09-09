function getCardapio() {
    $.ajax({
        url: "/cardapio",
        type: "GET",
        success: function (data) {
            let listaHTML = "";
            data.forEach(produto => {
                let dadosHTML = "<ul>";
                for (let chave in produto.dadosNutricionais) {
                    dadosHTML += `<li>${chave}: ${produto.dadosNutricionais[chave]}</li>`;
                }
                dadosHTML += "</ul>";

                let ingredientesHTML = "";
                if (produto.ingredientes && produto.ingredientes.length > 0) {
                    ingredientesHTML = "<ul>";
                    produto.ingredientes.forEach(ingrediente => {
                        ingredientesHTML += `<li>${ingrediente}</li>`;
                    });
                    ingredientesHTML += "</ul>";
                }

                listaHTML += `
                    <li>
                        <strong>${produto.nome}</strong> -
                        ${produto.preco.toLocaleString("pt-BR", { style: "currency", currency: "BRL" })}
                        <div><strong>Dados Nutricionais:</strong>${dadosHTML}</div>
                        <div><strong>Ingredientes:</strong>${ingredientesHTML}</div>
                    </li>
                `;
            });
            document.getElementById("cardapio-list").innerHTML = listaHTML;
        },
        error: function () {
            alert("Erro ao buscar os produtos...");
        }
    });
}