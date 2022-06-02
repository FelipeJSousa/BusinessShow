let ProdutoList = [];
const ApiUrl = "http://localhost:8080"

function renderProdutos(){
    var eleListaProdutos = $(".lista-produtos")
    eleListaProdutos.empty()
    for (const produto of ProdutoList) {

        var img2_1 = $('<img>').attr('src', `/imagem/${produto.listaImagem[0].id}`)
                            .attr('style','width: auto; max-height: 10rem;min-height: 10rem')
                            .addClass('card-img-top mx-auto')

        var body2_2 = $('<div>').addClass('card-body')

        var categoria3_1 = $('<span>').addClass('badge rounded-pill text-bg-success').text(`${produto.categoria.nome}`)

        var titulo3_2 = $('<span>').addClass('d-flex justify-content-between');

        titulo3_2.append($('<h5>').addClass('card-title my-4 me-2 col text-start').text(`${produto.nome}`))
        titulo3_2.append($('<h5>').addClass('card-title my-4 col text-end').text(`R$ ${produto.valor.toFixed(2)}`))

        var botao3_3 = $('<span>').addClass('d-flex justify-content-end').append($('<a>').addClass('btn btn-outline-success d-flex w-50 align-self-end justify-content-center')
                                                                                          .attr('href',`/produto/detalhes?id=${produto.id}`)
                                                                                          .text('Visualizar'))


        var footer2_3 = $('<span>').addClass('card-footer')

        var footerbody = $('<span>').addClass('d-flex justify-content-between').append(
            $('<p>').addClass('text-start p-0 m-0').text(`Qtde: ${produto.qtde}`)
        )
        var parts = produto.dataCriacao.split('-');
        var dataCriacao = `${parts[2].slice(0, 2)}/${parts[1]}/${parts[0]}`;
        footerbody.append($('<p>').addClass('text-end p-0 m-0').text(`Data: ${dataCriacao}`))

        footer2_3.append(footerbody)

        body2_2.append(categoria3_1)
        body2_2.append(titulo3_2)
        body2_2.append(botao3_3)

        var card1 = $('<div>').addClass('card me-4 mb-4 col-sm-10  col-md-5 col-lg-3 p-2 new-card').append(img2_1)
        card1.append(body2_2)
        card1.append(footer2_3)

        eleListaProdutos.append(card1)

    }
}

function BuscarTermo(event){

    console.log('buscaTermo event - value', event.target.value);

    if(event.target.value.replaceAll(" ","").length < 3 && event.target.value.length > 0)
        return;

    $.ajax({
        type: "GET",
        contentType: "application/json; charset=utf-8",
        url: ApiUrl + "/produto/busca?termo=" + event.target.value,
        headers: {
            origin: "http://localhost:8080"
        },
        success: response => {
            console.log('response /produto/busca', response)
            ProdutoList = response;
            console.log('lista de produtos - response', ProdutoList)
            renderProdutos()
        },
        failure: response => {
            console.log('response /produto/busca', response)
            _error = response.erro;
            $('#message').text('Não foi possível obter os anúncios.')
        }
    });
}