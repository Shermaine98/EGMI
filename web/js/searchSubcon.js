var i = 1;
var x = true;
function autoCompleteSubcon() {
  
    $("#subconName").devbridgeAutocomplete({
        serviceUrl: 'SearchSubconServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Suppplier',
        onSelect: function (event, ui) {
         var subconName = document.getElementById('subconName').value;
            $.ajax({
                type: 'POST',
                url: 'SetSubconServiceServlet',
                dataType: 'json',
                data: {
                    subconName: subconName
                },
                success: function (data) {
                    if (i === 1) {
                        $('#dataSubconService').append('<tr><th></th><th>Service</th></tr>');
                        i++;
                    }
                    for (var y = 0; y < data.length; y++) {
                        $('#dataSubconService').append('<tr><td><input type="checkbox"/></td><td>' + data[y].service + '</td></tr>');
                    }
                }
            });
        }
    });
}