<%-- 
    Document   : PICKING FORM
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.PickingForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <title>Encode Picking Form</title>

       

    <body>  
        <br/><br/><br/>
    <center><h2>Picking Form</h2></center>
    <form method="POST" action="EncodePickingFormServlet">
        <div align="center" class="container">
            <table class="table table-bordered" style="width:45%">
                <colgroup>
                    <col style="width:35%" />
                </colgroup>
                <thead>
                    <tr>
                        <th>Outlet</th>
                        <td class="value"><input type="text" class="input" name="outlet"/></td>
                    </tr>
                    <tr>
                        <th>Promo</th>
                        <td><input type="text" class="input" name="promo"/></td> 
                    </tr>
                    <tr>
                        <th>Warehouse Manager</th>
                        <td><input type="text" class="input" name="warehouseManager"/></td> 
                    </tr>
                    <tr>
                        <th>Date Made</th>
                        <td><input type="text" class="input" name="dateMade"  readonly size="12"
                                   value="<%  PickingForm x = new PickingForm();
                                       x.setDateMade();
                                   %><%=x.getDateMade()%>"/></td>
                    </tr>
                </thead>
            </table>

            <br/>
            <table class="table width table-bordered">
                <thead>
                    <tr><th style="text-align: center; vertical-align: middle" rowspan="3">Product ID</th>
                        <th style="text-align: center" colspan="5">Approved</th></tr>
                    <tr>
                        <th style="text-align: center" colspan="4">Size</th>
                        <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th></tr>
                    <tr>
                        <th>S</th>
                        <th>M</th>
                        <th>L</th>
                        <th>XL</th></tr>
                </thead>
                <tbody>
                    <!-- insert body here -->
                </tbody>
            </table>


            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
</body>
</html>
