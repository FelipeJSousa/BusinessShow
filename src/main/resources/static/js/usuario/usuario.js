function ShowModal(){
    if($('#id').val()>0 && !$('#senha').val() == false){
        $('#modalAlterarSenha').modal('show');
    }
    else{
        Submit();
    }
}
function Cancelar(){
    $('#senha').val('');
    Submit();
}
function Submit(){
    $('#form').submit();
}