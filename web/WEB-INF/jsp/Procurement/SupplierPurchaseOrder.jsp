<%-- 
    Document   : Supplier Purchase Order
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <script type="text/javascript" src="js/searchSupplier.js"></script>
        <script type="text/javascript" src="bootstrap/js/jquery-ui.js"></script>
       
        <title>Encode Supplier Purchase Order</title>
         <script>
            $(document).ready(function () {
            var spoNumber = '${SPONumber}';
            document.getElementById('poNumber').value = spoNumber;
            
            });

        </script>
    </head>
    <body>  
        <br/>
        
    <center><h2>Encode Supplier Purchase Order</h2></center><br/>
    <form method="POST" action="EncodeSupplierPurchaseOrderServlet">
        <div align="center" class="container">
            <table class="table table-bordered" style="width:40%">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Purchase Order number</th>
                        <td class="value"><input class="input" type="text" name="poNumber" id="poNumber"/></td>
                    </tr><tr>
                        <th>Prepared By</th>
                        <td><input type="hidden" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%> <%= user.getLastName()%> </td>
                    </tr><tr>
                        <th>Delivery Date </th>
                        <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>                 
                    </tr><tr>
                        <th>Supplier</th>
                        <td> <input type="text" style="width:35%; height:35px" name="supplierName" id="supplierName" onkeydown="autoCompleteSupplier()" placeholder="Search Supplier"/>
                    <input type="hidden" name="supplierName" id ="supplierName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>  </td>               
                    </tr>
                </thead>
            </table>
                <input type="text" style="width:35%; height:35px" name="itemNameSupplier" id="itemNameSupplier" onkeydown="autoCompleteSupplierItem()" placeholder="Search Item"/>
                <input type="hidden" name="itemNameSupplier" id="itemNameSupplier" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                <input type="Button" onClick="getItemSupplierItem()" style="height:34px" class="btn btn-danger" value="ADD ITEM">
            <br/><br/>
            <table class="table table-bordered width">
                <thead>
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
                    <td><input type="text" class="input" name="Total Price" value =""/></td>
                </tr>
                </tbody>
            </table>
            <table class="table table-bordered width">
                <tr>
                    <th>TOTAL:</th>
                    <td><input type="text" class="input" name="Total" value =""/></td>
                </tr>
            </table>
            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script>
        function autoComplete() {
            $("#ItemName").devbridgeAutocomplete({
                serviceUrl: 'SearchItem',
                type: 'POST',
                showNoSuggestionNotice: true,
                noSuggestionNotice: 'No Exsiting Item',
            });
        }
        $(function () {
            $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat: 'yy-mm-dd'});

        });
        
    </script>
</body>
</html>
