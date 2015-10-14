<%-- 
    Document   : EncodeReplenishmentRequest
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.ReplenishmentRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <title>Encode Replenishment Request</title>

      
    </head>


    <body>  
        <br/><br/><br/>
    <center><h2>Replenishment Request</h2></center>
    <form method="POST" action="EncodeReplenishmentReportServlet">
        <div align="center" class="container">
            <br/>
            <table class="table detailsWidth table-bordered">
                <colgroup>
                    <col style="width:30%"/>
                    <col style="width:70%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Outlet</th>
                        <td class="value"><input class="input" type="text" name="outlet" value="AUTO" /></td>
                    </tr><tr>
                        <th>Promo</th>
                        <td><input type="text" class="input" name="promo" value="AUTO"/></td>
                    </tr><tr>
                        <th>Promo Supervisor</th>
                        <td><input type="text" class="input" name="promoSupervisor"  readonly value="AUTO"/></td>  
                    </tr><tr>
                        <th>Date Made</th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="auto" /></td>                 
                    </tr>
                </thead>
            </table>

            <br/>
            <table class="table table-hover table-bordered width" >
                <colgroup>
                    <col style="width:15%" />
                    <col style="width:15%" />
                    <col style="width:15%" />
                    <col style="width:15%" />
                </colgroup>
                <thead>
                    <tr>
                        <th rowspan="3" style="text-align: center; vertical-align: middle">Product ID</th>
                        <th rowspan="3" style="text-align: center; vertical-align: middle">Beginning Total</th>
                        <th rowspan="3" style="text-align: center; vertical-align: middle">Sold Out</th>
                        <th rowspan="3" style="text-align: center; vertical-align: middle">Ending Total</th>
                        <th colspan="5" style="text-align: center; vertical-align: middle">Request</th>
                    </tr>
                    <tr>
                        <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                        <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
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
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td>
                        <td class="value"></td></tr>
                </tbody>
            </table>

            <br/><br/>
            <!-- ANother button?? -->
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
</body>
</html>
