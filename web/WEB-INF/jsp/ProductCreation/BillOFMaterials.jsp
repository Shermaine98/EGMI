<%-- 
    Document   : Bill of Materials
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/searchInput.css">
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <script src="js/searchItem.js"></script>
        <script src="js/deleteRow.js"></script>
        <title>Bill of Materials</title>
        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                margin: 0; 
            }
        </style>
        <script>
            $(document).ready(function () {
                var prID = '${BoMPrNumber}';
                document.getElementById('productID').value = prID;
            });

        </script>
    </head>
    <body> 
        <br/><br/><br/>
        <div>
            <center><h2>Encode Bill of Materials</h2></center>
            <br/><br/>

            <div align="center" class="container">
                <table class="table width35 table-bordered">
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <td><input type="text" class="input" name="productID" id="productID" value=""/></td>
                        </tr>
                        <tr>
                            <th>Product Name</th>
                            <td><input type="text" class="input" name="productName"/></td>
                        </tr>
                        <tr>
                            <th>Product Type</th>
                            <td> 
                                <select name="sizeName" id="sizeName">
                                    <option value="Pants">Pants</option>
                                    <option value="Shirt">Shirt</option>
                                </select>
                            </td>
                        </tr>
                    </thead>
                </table>
                <input type="text" style="width:35%; height:35px" name="itemName" id="ItemName" onkeydown="autoComplete()" placeholder="Search Item"/>
                <input type="hidden" name="itemName" id ="ItemName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                <input type="Button" onClick="getItem()" style="height:34px" class="btn btn-danger" value="ADD ITEM">
                <br/><br/>
                <table  id="thisTable"class="table table-bordered" style="width:47%">
                    <colgroup>
                        <col style="width:3%" />
                    </colgroup>
                    <tbody id="dataTable">
                    </tbody>
                </table>
                <br/>
                <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
                <br/><br/>
                <input type="button" style="width:77px; height:34px" class="btn btn-danger" onclick= "viewModal()" data-toggle="modal" data-target="#myModal" value="Create">
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

                <form method="POST" action="EncodeBillOfMaterialsServlet">
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Add Item</h4>
                                </div>

                                <div class="modal-body">



                                    <table class="table width35 table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Product ID</th>
                                                <td><input type="text" class="input" name= "productIDModal" id="productIDModal"/></td>
                                            </tr>
                                            <tr>
                                                <th>Product Name</th>
                                                <td><input type="text" class="input" name="productNameModal" id="productNameModal"/></td>
                                            </tr>
                                            <tr>
                                                <th>Product Type</th>
                                                <td><input type="text" class="input" name="sizeTypeModal" id="sizeTypeModal" /></td>
                                            </tr>
                                        </thead>
                                    </table>

                                    <table  id="thisTableModal"class="table table-bordered" style="width:47%">
                                        <colgroup>
                                            <col style="width:3%" />
                                        </colgroup>
                                        <tbody id="dataTableModal">
                                        </tbody>
                                    </table>



                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Edit</button>
                                    <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Create">
                                </div>

                            </div>
                        </div>
                    </div>
                </form>


            </div>

        </div>
        <script>
            function viewModal() {
                var productID = document.getElementById('productID').value;
                var sizeName = document.getElementById('sizeName').value;
                var productName = "shirt78";
                

                document.getElementById('productIDModal').value = productID;
                document.getElementById('sizeTypeModal').value = sizeName;
                document.getElementById('productNameModal').value = productName;

                //$('#dataTableModal').remove();
                eraseModal();

                console.log(productID);
                $("#dataTable tr").each(function () {
                    var $this = $(this);
                    var itemCode = $this.find('[id="itemCode\\[\\]"]').val();
                    var itemName = $this.find('[id="itemCode\\[\\]"]').val();
                    console.log(itemName);
                    var consume = $this.find('[id="itemConsumption\\[\\]"]').val();
                    console.log(consume);
                    var unitMeasurement = $this.find('[id="unitMeasurement\\[\\]"]').val();
                    console.log(unitMeasurement);

                    if (!itemName == ""){
                        $('#dataTableModal').append('<tr>\n\
                        <td><input type = "hidden" name = "itemCodeModal" value="' + itemCode + '"></td>\n\
                        <td><input type = "text" name = "itemNameModal" value="' + itemName + '"></td>\n\
                        ' + itemName + 
                        '<td><input type = "text" name="itemConsumptionModal" value="' + consume + '"></td>\n\
                        <td><input type = "text" name="unitMeasurementModal" value="' + unitMeasurement + '"></td></tr>');
        }

                });
            


            }

            function eraseModal() {
                var Parent = document.getElementById('dataTableModal');
                while (Parent.hasChildNodes()) {
                    Parent.removeChild(Parent.firstChild);
                }
            }

            $('form').on('focus', 'input[type=number]', function (e) {
                $(this).on('mousewheel.disableScroll', function (e) {
                    e.preventDefault();
                });
            });

            $('form').on('blur', 'input[type = number]', function (e) {
                $(this).off('mousewheel.disableScroll');
            });
        </script>    
    </body>

</html>
