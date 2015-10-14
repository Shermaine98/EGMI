<%-- 
    Document   : Supplier Purchase Order
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <script src="js/searchSupplier.js"></script>
        <script src="js/deleteRow.js"></script>
        <script src="bootstrap/js/jquery-ui.js"></script>
        <title>Encode Supplier Purchase Order</title>
        <style>
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }
        </style>
        <script>
            $(document).ready(function () {
                var spoNumber = '${SPONumber}';
                document.getElementById('poNumber').value = spoNumber;

            });

        </script>
    </head>
    <body>  
        <br/>
        <div align="center" class="container">
            <h2>Encode Supplier Purchase Order</h2><br/>
            <form method="POST" action="EncodeSupplierPurchaseOrderServlet">

                <table class="table table-bordered" style="width:40%">
                    <colgroup>
                        <col style="width:40%"/>
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Purchase Order No.</th>
                            <td class="value"><input class="input" type="text" name="poNumber" id="poNumber" readonly /></td>
                        </tr><tr>
                            <th>Prepared By</th>
                            <td><input type="hidden" name="preparedBy" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%> <%= user.getLastName()%> </td>
                        </tr><tr>
                            <th>Delivery </th>
                            <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>                 
                        </tr><tr>
                            <th>Supplier</th>
                            <td> <input type="text" name="supplier" id="supplierName" onkeydown="autoCompleteSupplier()" placeholder="Search Supplier"/>
                                <input type="hidden" name="supplierName" id ="supplierName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>  </td>               
                        </tr>
                    </thead>
                </table>
                <input type="text" style="width:35%; height:35px" name="itemNameSupplier" id="itemNameSupplier" onkeydown="autoCompleteSupplierItem()" placeholder="Search Item"/>
                <input type="hidden" name="itemNameSupplier" id="itemNameSupplier" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                <input type="Button" onClick="getSupplierItem()" style="height:34px" class="btn btn-danger" value="ADD ITEM">
                <br/><br/>
                <table id ="data" class="table table-bordered width">
                    <!--                    <thead>
                                            <tr>
                                                <th></th>
                                                <th>Item Name</th>
                                                <th>Unit Price</th>
                                                <th>Quantity</th>
                                                <th>Total Quantity Price</th>
                                            </tr>
                                        </thead>
                                        <tbody id="dataTable">
                                            <tr>  
                                                <td><input type="checkbox" name="chk" /></td>
                                                <td><input type="text" class="input" name="unitPrice"></td>
                                                <td><input type="text" class="input" name="qty"/></td>
                                                <td><input type="text" class="input" name="qty"/></td>
                                                <td><input type="text" class="input" name="Total Price" value ="" readonly /></td>
                                            </tr>
                                        </tbody>-->
                </table>
                <table class="table table-bordered" style="width:20%;">
                    <tr>
                        <th>TOTAL</th>
                        <td><input type="text" class="input" name="Total" value ="" readonly /></td>
                    </tr>
                </table>
                <br/><br/>

                <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('data')" />
                <br/><br/>
                <input type="submit" class="btn btn-danger" value="Submit">
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

            </form>
        </div>
        <script>

            $(function () {
                $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat: 'yy-mm-dd'});

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
