$(function () {
    $("#myTable").dynamicTable({
        columns: [{
                text: "Código Produto",
                key: "codigoProduto"
            },
            {
                text: "Cor",
                key: "cor"
            },
            {
                text: "Quantidade",
                key: "quantidade"
            },
        ],
        data: [{
                codigoProduto: "M001",
                cor: "Magenta",
                quantidade: '321',
            },
            {
            	codigoProduto: "M002",
                cor: "Branco",
                quantidade: '524',
            },
            {
            	codigoProduto: "M003",
                cor: "Azul",
                quantidade: '765',
            },
        ],

    });

    $('#btnGetData').click(function () {
        var data = $("#myTable").getTableData();
        console.log(data);
    });
});