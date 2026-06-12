function listar() {
    $.ajax({
        method: "GET",
        url: "/mascotas/api/mascotas",
        success: function (mascotas) {
            let tabla = $('#example1').DataTable();
            tabla.clear();

            mascotas.forEach(mascota => {
                let botones = '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update" onclick="identificaActualizar(' + mascota.id + ')"> Editar </button>';
                botones += ' <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-delete" onclick="identificaEliminar(' + mascota.id + ')">Eliminar</button>';

                tabla.row.add([
                    mascota.id,
                    mascota.nombre,
                    mascota.edad,
                    mascota.observaciones,
                    botones
                ]).node().id = 'renglon_' + mascota.id;
            });
            tabla.draw();
        }
    });
}

function guardar() {
    let nombreMascota = document.getElementById('nombre').value;
    let edadMascota = document.getElementById("edad").value;
    let observacionesMascota = document.getElementById("observaciones").value;
    let razaMascota = document.getElementById("raza").value;

    $.ajax({
        method: 'POST',
        url: "/mascotas/api/mascotas",
        contentType: "application/json",
        data: JSON.stringify({
            nombre: nombreMascota,
            edad: edadMascota,
            observaciones: observacionesMascota,
            raza: razaMascota
        }),
        success: function (mascota) {
            alert("Mascota Guardada Correctamente");
            $('#modal-lg').modal('hide');
            listar();
            limpiarFormulario();
        },
        error: function(xhr) {
            alert("Hubo un error al guardar: " + xhr.status);
        }
    });
}

function limpiarFormulario() {
    document.getElementById('nombre').value = "";
    document.getElementById('edad').value = "";
    document.getElementById('observaciones').value = "";
    document.getElementById('raza').value = "";
    document.getElementById('nombre').focus();
}

function identificaActualizar(id) {
    $.ajax({
        method: 'GET',
        url: "/mascotas/api/mascotas/" + id,
        success: function (mascota) {
            document.getElementById('id-update').value = mascota.id;
            document.getElementById('nombre-update').value = mascota.nombre;
            document.getElementById('edad-update').value = mascota.edad;
            document.getElementById('observaciones-update').value = mascota.observaciones;
            document.getElementById('raza-update').value = mascota.raza;
        }
    });
}

function actualizar() {
    let idMascota = document.getElementById('id-update').value;
    let nombreMascota = document.getElementById('nombre-update').value;
    let edadMascota = document.getElementById('edad-update').value;
    let observacionesMascota = document.getElementById('observaciones-update').value;
    let razaMascota = document.getElementById('raza-update').value;

    $.ajax({
        method: 'PATCH',
        contentType: 'application/json',
        url: "/mascotas/api/mascotas/" + idMascota,
        data: JSON.stringify({
            nombre: nombreMascota,
            edad: edadMascota,
            observaciones: observacionesMascota,
            raza: razaMascota
        }),
        success: function () {
            $('#modal-update').modal('hide');
            alert('Mascota actualizada');
            listar();
        }
    });
}

function identificaEliminar(id) {
    $.ajax({
        method: 'GET',
        url: "/mascotas/api/mascotas/" + id,
        success: function (mascota) {
            document.getElementById('id-eliminar').value = mascota.id;
            document.getElementById('nombre-delete').value = mascota.nombre;
            document.getElementById('edad-delete').value = mascota.edad;
            document.getElementById('observaciones-delete').value = mascota.observaciones;
        }
    });
}

function eliminar() {
    let idEliminar = document.getElementById('id-eliminar').value;
    $.ajax({
        method: 'DELETE',
        url: "/mascotas/api/mascotas/" + idEliminar,
        success: function () {
            alert('Mascota Eliminada');
            $('#modal-delete').modal('hide');
            let tabla = $('#example1').DataTable();
            tabla.row('#renglon_' + idEliminar).remove().draw();
        }
    });
}

function cargarRazas() {
    $.ajax({
        url: "/razas/api/razas",
        method: "GET",
        success: function(razas) {
            let options = '<option value="">Seleccione una raza...</option>';
            razas.forEach(raza => {
                options += '<option value="' + raza.id + '">' + raza.nombre + '</option>';
            });
            $("#raza").html(options);
            $("#raza-update").html(options);
        }
    });
}