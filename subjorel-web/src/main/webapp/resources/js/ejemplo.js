/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myScript2()
{
    alert('prueba externa');
}

function cambiarTexto()
{
    document.getElementById("campo").value = "texto campo";

}

function mostrarTiempoSubasta()
{
    // Set the unit values in milliseconds.
    var msecPerMinute = 1000 * 60;
    var msecPerHour = msecPerMinute * 60;
    var msecPerDay = msecPerHour * 24;
    //obtiene los valores de la subasta

    // var diaSubasta=document.getElementById("diaSubasta").value;
    //  var horaSubasta=document.getElementById("horaSubasta").value;
    // var minutoSubasta=document.getElementById("minutoSubasta").value;
    //  var segundosSubasta=document.getElementById("segundosSubasta").value;

    //obtiene los valores del sistema
    var fechaHora = new Date();



    var tiempotot = fechaHora.getTime();

    //var tiempoLimite = new Date(2016,0,7);
    var tiempotot2 = document.getElementById("horaSistema").value;
    //alert(tiempotot2);
    
    var interval = tiempotot2 - tiempotot;

    var dias = Math.floor(interval / msecPerDay);
    interval = interval - (dias * msecPerDay);

    var horas = Math.floor(interval / msecPerHour);
    interval = interval - (horas * msecPerHour);

    var minutos = Math.floor(interval / msecPerMinute);
    interval = interval - (minutos * msecPerMinute);

    var segundos = Math.floor(interval / 1000);

    //var horas = tiempoTrasncurrido.getHours();
    //var minutos = tiempoTrasncurrido.getMinutes();
    //var segundos = tiempoTrasncurrido.getSeconds();


    document.getElementById("reloj").innerHTML = dias + ' dias ' + horas + ':' + minutos + ':' + segundos;


}

function muestraReloj() {
    var fechaHora = new Date();
    var horas = fechaHora.getHours();
    var minutos = fechaHora.getMinutes();
    var segundos = fechaHora.getSeconds();

    if (horas < 10) {
        horas = '0' + horas;
    }
    if (minutos < 10) {
        minutos = '0' + minutos;
    }
    if (segundos < 10) {
        segundos = '0' + segundos;
    }

    document.getElementById("reloj").innerHTML = horas + ':' + minutos + ':' + segundos;
}

window.onload = function () {
    setInterval(mostrarTiempoSubasta, 1000);
}

