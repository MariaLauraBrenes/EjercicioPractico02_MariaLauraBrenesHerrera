/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function addReserva(formulario) {
    var idEvento = formulario.elements[0].value;

    var url = '/reservas/agregar/' + idEvento;

    $("#listaReservas").load(url);
}

function removeReserva(formulario) {
    var idEvento = formulario.elements[0].value;

    var url = '/reservas/eliminar/' + idEvento;

    $("#listaReservas").load(url);
}

