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

        <br/>
        <div class="container-fluid" align="center" style="margin-left:20px;">
            <h1>Encode Delivery Order</h1><br/>
            <div class="panel panel-default col-md-4">
                <div class="panel-heading">
                    <h3 class="panel-title">Delivery Order</h3>
                </div>
                <div class="panel-body">
                    <label class="" for="doNumber">Delivery Order Number</label>
                    <input type="text" name="doNumber" class="form-control readonlyWhite" id="doNumber" readonly /><br/>
                    <label class="" for="outlet">Outlet</label>
                    <input type="text" name="outlet" class="form-control readonlyWhite" id="outlet" readonly /><br/>
                    <label class="" for="preparedBy">Prepared By</label>
                    <input type="text" name="preparedBy" class="form-control readonlyWhite" id="preparedBy" readonly /><br/>
                    <label class="" for="deliveryDate">Delivery Date</label>
                    <input type="text" name="deliveryDate" class="form-control" id="datepicker" /><br/>
                </div>
            </div>

            <div class="panel panel-default col-md-7">
                <div class="panel-body">
                    <form method="POST" action="EncodeDeliveryOrderServlet">

                        <!--TABLE FOR SHIRT-->
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
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>

                        <!--TABLE FOR PANTS-->
                        <table class="table detailsWidth table-bordered">
                            <thead>
                                <tr>
                                    <th style="vertical-align: middle; text-align: center">Product ID</th>
                                    <th style="vertical-align: middle; text-align: center">Total</th>
                                    <th style="vertical-align: middle; text-align: center">Unit Price</th>
                                    <th style="vertical-align: middle; text-align: center">Total Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                        
                        <table class="table detailsWidth table-bordered">
                            <thead>
                                <tr>
                                    <th colspan="8" style="vertical-align: middle; text-align: center">Size</th>
                                </tr>
                                <tr>
                                    <th style="vertical-align: middle; text-align: center">29</th>
                                    <th style="vertical-align: middle; text-align: center">30</th>
                                    <th style="vertical-align: middle; text-align: center">31</th>
                                    <th style="vertical-align: middle; text-align: center">32</th>
                                    <th style="vertical-align: middle; text-align: center">33</th>
                                    <th style="vertical-align: middle; text-align: center">34</th>
                                    <th style="vertical-align: middle; text-align: center">36</th>
                                    <th style="vertical-align: middle; text-align: center">38</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>

                        <br/><br/>
                        <input type="submit" class="btn btn-danger" value="Create">
                        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
