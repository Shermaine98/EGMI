<%-- 
    Document   : DeliveryReceipt
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
          <link rel="stylesheet" type="text/css" href="bootstrap/tableBoarder.css">
        <title>Encode Delivery Receipt</title>
       <script>
            $(document).ready(function () {
                var drNumber = '${drNumber}';
                document.getElementById('drNumber').value = drNumber;
            });

        </script> 
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Delivery Receipt</h2></center>
    <form method="POST" action="EncodeDeliveryReceiptServlet">
        <div align="center" class="container">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Delivery Number</th>
                        <th>Delivery Order Number</th>
                        <th>Location</th>
                         <th>Promoter</th>
                        <th>Date Made</th>
                         <th>Delivery Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="value"><input type="text" name="drNumber" id="drNumber" size="12"/></td>
                        <td><input type="text" name="doNumber" size="12"/></td> 
                        <td><input type="text" name="location" size="12"/></td> 
                        <td><input type="text" name="promo" size="12"/></td>   
                        <td><input type="text" name="location" size="12"/></td>
                        <td><input type="text" name="deliveryDate" size="12"/></td></tr>
                </tbody>
            </table>

            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
</body>
</html>
