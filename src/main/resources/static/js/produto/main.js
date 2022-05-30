function previewFile() {
    var span = $("#imgpreview")[0];
    $(".img-thumbnail").remove();
    var files = $("#image")[0].files
    for (let i = 0; i < files.length; i++) {

        var file = files[i];
        var reader = new FileReader();

        reader.onload = function(event) {
            var preview = $("<img>", {"src": event.target.result, "class": "img-thumbnail rounded col-2 h-100 me-3"});
            span.append(preview[0]);
            saveImagem(event.target.result)
        }

        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }
}


function saveImagem(imagem){
    $.ajax({
            method: "POST",
            url: "http://localhost:8080" + "/imagem",
            data: {file: imagem}
        }
    )
    .done(function(resp){
        console.log(resp)
    })
    .fail(function(jqXHR, textStatus, msg){
        alert(msg);
    });
}