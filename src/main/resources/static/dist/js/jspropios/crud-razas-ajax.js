function listarRazas() {
    $.ajax({
        method: "GET",
        url: "/razas/api/razas",
        success: function (razas) {
            let tabla = $('#exampleRazas').DataTable();
            tabla.clear();
            razas.forEach(raza => {
                let botones = '<button type="button" class="btn btn-danger" onclick="eliminarRaza(' + raza.id + ')">Eliminar</button>';
                tabla.row.add([raza.id, raza.nombre, botones]).node().id = 'raza_' + raza.id;
            });
            tabla.draw();
        }
    });
}

function guardarRaza() {
    let nombreRaza = document.getElementById('nombreRaza').value;
    $.ajax({
        method: 'POST',
        url: "/razas/api/razas",
        contentType: "application/json",
        data: JSON.stringify({ nombre: nombreRaza }),
        success: function () {
            alert("Raza guardada");
            document.getElementById('nombreRaza').value = "";
            listarRazas();
        },
        error: function(xhr) {
            alert("Error al guardar raza: " + xhr.status);
        }
    });
}

function eliminarRaza(id) {
    $.ajax({
        method: 'DELETE',
        url: "/razas/api/razas/" + id,
        success: function () {
            alert('Raza Eliminada');
            let tabla = $('#exampleRazas').DataTable();
            tabla.row('#raza_' + id).remove().draw();
        }
    });
}