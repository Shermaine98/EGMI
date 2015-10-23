var i = 1;
var x = true;
function autoCompleteSupplier() {
    $("#supplierName").devbridgeAutocomplete({
        serviceUrl: 'SearchSupplierServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Suppplier',
    });
}
function autoCompleteSupplierItem() {
    var supplierName = document.getElementById('supplierName').value;
    if (supplierName == "") {
        window.alert("Please Input Supplier");
        $('input:text').focus(
                function () {
                    $('#itemNameSupplier').val('');
                });
    } else {
        $("#itemNameSupplier").devbridgeAutocomplete({
            serviceUrl: 'SearchItemSuppliersServlet',
            dataType: "json",
            params: {
                supplierName1: supplierName},
            type: 'POST',
            showNoSuggestionNotice: true,
            noSuggestionNotice: 'No Exsiting Item',
        });
    }
}
function chk() {
    if (i > 1) {
        var itemNameSupplier = document.getElementById('itemNameSupplier').value;
        $("#data tbody tr").each(function () {
            var $this = $(this);
            var chk = $this.find('[id="itemName\\[\\]"]').val();
            if (itemNameSupplier == chk) {
                x = false;
            }
        }
        );
    }

    return x;
}

function getSupplierItem() {
    x = true;
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
                if (data[0] == null) {
                    window.alert("Please Enter Item / Supplier Name");
                    $('input:text').focus(
                            function () {
                                $('#itemNameSupplier').val('');
                            });
                }
                else if (i == 1) {
                    $('#data').append('<tr><th></th><th>Item Name</th> <th> Unit Price</th> <th>Quantity</th> <th>Total Quantity Price </th> <th>Note</th></tr>');
                    i++;
                   $('#supplierName').attr("disabled","disabled");
                }
                if (data[0] != null) {
                    $('#data').append('<tr><td> <input type="checkbox" name="chk" /> </td><td><input type="hidden" name = "itemCode"/><input type="text" id= "itemName[]" value="' + data[0].itemName + '"/> </td><td><input type="text" id="unitPrice[]" name = "unitPrice" value="' + data[0].unitPrice + '"/></td><td><input type="number"  id="volumeQty[]"   name="volumeQty" onkeypress="return event.charCode >= 48 && event.charCode <= 57"/><td><input type="text" name = "Total Quantity Price" id="TQP[]"  /></td><td><input type="hidden" name = "receivingStatus" value="pending" /><input type="hidden" name = "reconcileStatus" value="pending" /><input type="text" name = "note"/></td>' + '</tr>');
                SolveTQP();
                }

            }, error: function (XMLHttpRequest, textStatus, exception) {
                alert(XMLHttpRequest.responseText);
            }
        });
    } else {
        window.alert("item Already Added");
        $('input:text').focus(
                function () {
                    $('#itemNameSupplier').val('');
                });

    }
}



// TODO: calucaltions
function SolveTQP() {
      $("#data").each(function () {
                var $this = $(this);
                var unitPrice = parseInt($this.find('[id="unitPrice\\[\\]"]').val());
                var volumeQty = parseInt($this.find('[id="volumeQty\\[\\]"]').val());
                var STotal = unitPrice * volumeQty;
                $this.find('[id="TQP\\[\\]"]').val(STotal);
            });
            return false;
    SolveTotal(STotal);
}

function SolveTotal(TQP) {
    var total = 0;
    $("#data").each(function () {
        total = total+TQP;

    });
    parseInt(document.getElementById('total').val(total));

}

