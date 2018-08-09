$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize();


function goBack() {
    window.history.back();
}

$(function(){

  $('.qtd').keyup(function () {
    this.value = this.value.replace(/[^0-9\.]/g,'');
  });

  $("#calcular").on('click', function() {
    var qtd1 = ($("#qtd1").val());
    var qtd2 = ($("#qtd2").val());
    var qtd3 = ($("#qtd3").val());

    qtd1 = qtd1 * 50;
    qtd2 = qtd2 * 50;
    qtd3 = qtd3 * 50;

    $('#valorTotal').html('Valor Total: R$' + (qtd1 + qtd2 + qtd3) + ',00');

  });

});

var ctx = $("#myChart");
var myPieChart = new Chart(ctx,{
    type: 'bar',	
    data: {
        labels: ["Magenta", "Branco", "Azul"],
        datasets: [{
          fontColor: "#424242",	        	
          label: "Quantidade de Produto por Cor",	
          backgroundColor: ["#fff", "#fff","#fff"],
          data: [321, 524 , 765],
        }]
      },
    options:{
    	responsive: true,
    	scales: {
    	      xAxes: [{
    	        display: true,
    	        gridLines: {
    	          display: false,
    	        },
    	      }],
    	      yAxes: [{
    	        display: true,
    	        gridLines: {
    	          display: false,
    	        },
    	        ticks: {
                    beginAtZero:true
                }
    	      }]
    	    },
   
	   
        title: {
        	fontColor: "#424242",
            display: true,
            text: 'Quantidade disponível por cor',
          },
        }
});

