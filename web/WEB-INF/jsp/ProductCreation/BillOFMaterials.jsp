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
        <link rel="stylesheet" type="text/css" href="bootstrap/css/searchInput.css">
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <script src="js/searchItem.js"></script>
        <script src="js/deleteRow.js"></script>
        <title>Bill of Materials</title>

        <script>
            $(document).ready(function () {
                var prID = '${BoMPrNumber}';
                document.getElementById('productID').value = prID;
            });

        </script>
    </head>
    <body> 
        <br/>
        <div>
            <center><h2>Encode Bill of Materials</h2></center>
            <br/><br/>
            <form method="POST" action="EncodeBillOfMaterialsServlet">
                <div align="center" class="container">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <td><input type="text" name="productID" id="productID" value="" readonly/></td>
                            </tr>
                            <tr>
                                <th>Product Name</th>
                                <td><input type="text" name="productName"/></td>
                            </tr>
                            <tr>
                                <th>Product Type</th>
                                <td> 
                                    <select name="sizeName">
                                        <option value="Pants">Pants</option>
                                        <option value="Shirt">Shirt</option>
                                    </select>
                                </td>
                            </tr>
                        </thead>
                    </table>
                    <input name="itemName" class="search" id="ItemName" onkeydown="autoComplete()" placeholder="Search Item"/>
                    <input type="hidden" name="itemName" id ="ItemName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                    <input type="Button" onClick="getItem()" class="btn btn-danger" value="Add Item">
                    <br/><br/>
                    <table  class="table table-bordered">
                        <colgroup>
                            <col style="width:3%"/>
                        </colgroup>
                        <tbody id="dataTable">
                        </tbody>
                    </table>
                    <br/>
                    <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
                    <br/><br/>
                    <input type="submit" class="btn btn-danger" value="Create">
                    <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
                </div>
            </form>
        </div>
        <script>
            $(document).ready(function () {

                $(".production").on("click", (function () {
                    var productionNumber = $(this).closest("tr").find(".productionNumber").text();
                    $.ajax({
                        url: "ViewConsumptionServletJson",
                        type: 'POST',
                        dataType: "json",
                        data: {
                            productionNumber: productionNumber
                        },
                        success: function (data) {


                            $('#consumptionReportList tbody tr').remove();
                            $('#consumptionReportList').append('<tr><td>ProductionNumber</td></tr>');
                            $('#consumptionReportList').append('<tr><td>' + data[0].productionNumber + ' </td></tr>');
                            $('#consumptionReportList').append('<tr><td>Date Made</td></tr>');
                            $('#consumptionReportList').append('<tr><td>' + data[0].dateMade + ' </td></tr>');

                            for (var i = 0; i < data.length; i++) {
                                $('#consumptionReportList').append('<tr><td class"volumeQty">' + data[i].volumeQty + ' </td><tr>');
                            }

                            $('#consumptionReportList').append('<tr> <td><input id="TotalS" name="TotalS" onload="calculateTotalShirt()" /></td></tr>');
                            //     $('#consumptionReportList').append('<tr><td>' + data[0].productionNumber + '</td><td>' + data[0].dateMade + '</td><td>' + data[0].productionNumber + '</td><td>' + data[0].preparedBy + '</td></tr>');

                        },
                        error: function (XMLHttpRequest, textStatus, exception) {
                            alert(XMLHttpRequest.responseText);
                        }
                    });
                }));

                $('#view').DataTable({
                    "paging": false,
                    "info": false,
                    "dom": '<"pull-left "f>'
                });
            });
            $('form').on('focus', 'input[type=number]', function (e) {
                $(this).on('mousewheel.disableScroll', function (e) {
                    e.preventDefault();
                });
            });
            $('form').on('blur', 'input[type=number]', function (e) {
                $(this).off('mousewheel.disableScroll');
            });
        </script>    
    </body>

</html>
