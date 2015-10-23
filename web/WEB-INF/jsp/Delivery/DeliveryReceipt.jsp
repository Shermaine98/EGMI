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
        <style>
        .content {
width: 700px ;
margin-left: auto ;
margin-right: auto ;
}
        </style>
    </head>
    <body>  
        <div align="center" class="container content"> 
            <form method="POST" action="EncodeDeliveryReceiptServlet">
                <div class="panel panel-default col-md-6">
                    <div class="panel-heading">
                        <h3 class="panel-title">Delivery Receipt</h3>
                    </div>
                    <div class="panel-body">
                        <label class="" for="drNumber">Delivery Number</label>
                        <input type="text" name="drNumber" class="form-control readonlyWhite" id="drNumber" readonly /><br/>
                        <label class="" for="doNumber">Delivery Order Number</label>
                        <input type="text" name="doNumber" class="form-control readonlyWhite" id="doNumber" readonly /><br/>
                        <label class="" for="location">Location</label>
                        <input type="text" name="location" class="form-control readonlyWhite" id="location" readonly /><br/>
                        <label class="" for="promo">Promo</label>
                        <input type="text" name="promo" class="form-control readonlyWhite" id="promo" readonly /><br/>
                        <label class="" for="doNumber">Delivery Date</label>
                        <input type="text" name="doNumber" class="form-control" id="datepicker" /><br/><br/><br/>
                        <input type="submit" class="btn btn-danger" value="Submit">
                        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
                    </div>
                </div>


            </form>
        </div>

    </body>
</html>
