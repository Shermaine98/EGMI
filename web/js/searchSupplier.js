var i = 1;
var x= true;
function autoCompleteSupplier() {
    $("#supplierName").devbridgeAutocomplete({
        serviceUrl: 'SearchSupplierServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Suppplier',
        onSelect: function (suggestion) {
            $('#supplierName').html('You selected: ' + suggestion.value + ', ' + suggestion.data);
        },
        onHint: function (hint) {
            $('#supplierName').val(hint);
        },
        onInvalidateSelection: function () {
            $('#supplierName').html('You selected: none');
        }
    });
}
function autoCompleteSupplierItem() {
    var supplierName = document.getElementById('supplierName').value;
    if (supplierName == "") {
        window.alert("Please Input Supplier")
    } else {
        $("#itemNameSupplier").devbridgeAutocomplete({
            serviceUrl: 'SearchItemSuppliersServlet',
            dataType: "json",
            params: {supplierName1: supplierName},
            type: 'POST',
            showNoSuggestionNotice: true,
            noSuggestionNotice: 'No Exsiting Item',
        });
    }
}
function chk(){
    if (i > 1) {
         var itemNameSupplier = document.getElementById('itemNameSupplier').value;
        $("#data tbody tr").each(function () {
            var $this = $(this);
            var chk= $this.find('[id="itemName\\[\\]"]').val();
               if (itemNameSupplier == chk ) {
                 x = false;
            }
            }  
        );
    }
    
    return x;
}

function getSupplierItem() {
     x=true;
     x = chk();
    var itemNameSupplier = document.getElementById('itemNameSupplier').value;
    var supplierName = document.getElementById('supplierName').value;
    
    if (x == true) {
        $.ajax({
            url: "SetSupplierItemServlet",
            type: 'POST',
            dataType: "json",
            data: {
                itemNameSupplier: itemNameSupplier,
                supplierName: supplierName
            },
            success: function (data) {

                if (i == 1) {
                    $('#data').append('<tr> <th ></th>  <th style="text-align: center; vertical-align: middle">Item Name</th> <th style="text-align: center; vertical-align: middle" class="input">Unit Price</th><th style="text-align: center">Quantity</th><th style="text-align: center">Total Quantity Price</th></tr><th style="text-align: center">Note/th></tr>');
                }

                $('#data').append('<tr><td> <input type="checkbox" name="chk" /> </td><td><input type="hidden" name = "itemCode"/><input type="text" id= itemName[] value="' + data[0].itemName + '"/> </td><td><input type="text" name = "unitPrice" value="' + data[0].unitPrice + '"/></td><td><input type="number" name = "volumeQty" onkeypress="return event.charCode >= 48 && event.charCode <= 57"/><td><input type="text" name = "Total Quantity Price"  /></td><td><input type="hidden" name = "receivingStatus" value="pending" /></td><td><input type="hidden" name = "reconcileStatus" value="pending" /></td><td><input type="text" name = "note"/></td>'  + '</tr>');
                i++;
            }, error: function (XMLHttpRequest, textStatus, exception) {
                alert(XMLHttpRequest.responseText);
            }
        });
    } else{
        window.alert("item Already Added;");      
    }
}