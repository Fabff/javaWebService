$(document).ready(function () {
    $('a[href=work]').on('click', function (event) {
        event.preventDefault();

        if ($('body').children().length<6) {
            $.ajax({
                url: "http://localhost:8080/services/rest/work",
                success: function (result) {
                    var catalog='';
                    result.forEach(function(nextWork){
                        catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
                    });

                    $("a[href=work]").after('<br>'+catalog);
                }
            });
        }
    });
});