var i = 1;
function autoComplete() {
    $("#ItemName").devbridgeAutocomplete({
        serviceUrl: 'SearchItemServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Item',
    });
}
function getItem() {
    var itemName = document.getElementById('ItemName').value;
    console.log(itemName);
    $.ajax({
        url: "SetItemServlet",
        type: 'POST',
        dataType: "json",
        data: {
            itemName: itemName
        },
        success: function (data) {
          
               if (i == 1) {
                        $('#dataTable').append('<tr> <th ></th>  <th style="text-align: center; vertical-align: middle">Item Name</th> <th style="text-align: center; vertical-align: middle" class="input">Consumption</th><th style="text-align: center">Unit Measurement</th></tr>');
                    }

                    $('#dataTable').append('<tr> <td><input type="checkbox" name="chk" />\n\
                                                        </td>\n\
                                                        <td>\n\
                                                            <input type="hidden" name = "itemCode" value="' + data[0].ItemCode + '"/>'
                            + data[0].itemName + '</td> <td><input  class="input" type="number" name="itemConsumption"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"  /></td> <td><select name="unitMeasurement"> <option value="kg">kg</option><option value="cm">cm</option> </select> </td>'
                            + '</tr>');
                    i++;
          },error: function (XMLHttpRequest, textStatus, exception) {
            alert(XMLHttpRequest.responseText);
        }
    });
}
