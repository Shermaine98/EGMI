<%-- 
    Document   : EncodeDeliveryOrder
    Created on : 08 19, 15, 10:00:55 PM
    Author     : Geraldine
--%>

<%--<%@page import="Model.PurchaseOrder"%>--%>
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
        <title>Encode Delivery Order</title>
        <script>
            $(document).ready(function () {
                var doNumber = '${doNumber}';
                document.getElementById('doNumber').value = doNumber;
            });

        </script>
    </head>
    <body>  
    
    <br/><br/><br/>
    <center><h1>Encode Delivery Order</h1></center>
    <br/> 
    <div>
        <table class="table table-bordered" style="margin-left: 70px; width:35%">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Delivery Order No.</th>
                        <td class="value"><input class="input" type="text" name="doNumber" id="doNumber"/></td>
                    </tr><tr>
                        <th>Outlet</th>
                        <td><input type="text" class="input" name="outlet" value="AUTO"/></td>
                    </tr><tr>
                        <th>Prepared By</th>
                        <td><input type="text" class="input" name="preparedBy"  readonly/></td>  
                    </tr><tr>
                        <th>Delivery Date</th>
                        <td><input type="text" class="input" name="deliveryDate" readonly/></td>
                    </tr>
                </thead>
            </table>
    </div>

    <br/><br/>

    <div id= "center" align="center">
        <form method="POST" action="EncodeDeliveryOrderServlet">

            <table class="table detailsWidth table-bordered">
                <thead>
                    <tr>
                        <th rowspan="2" style="vertical-align: middle; text-align: center">Product ID</th>
                        <th colspan="4" style="text-align:center">Size</th>
                        <th rowspan="2" style="vertical-align: middle; text-align: center">Total</th>
                        <th rowspan="2" style="vertical-align: middle; text-align: center">Unit Price</th>
                        <th rowspan="2" style="vertical-align: middle; text-align: center">Total Price</th>
                    </tr>
                    <tr>
                        <th>S</th>
                        <th>M</th>
                        <th>L</th>
                        <th>XL</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- EDITABLE HERE (code?) -->
                </tbody>
            </table>
            
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Create">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

        </form>
    </div>
</body>
</html>
