<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@include file="LevelOFAccess.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Encode Delivery Order</title>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
    </head>
    <body>  
        <br/><br/><br/>
        <%            
        ArrayList<SupplierPurchaseOrder> PurchaseOrder = (ArrayList<SupplierPurchaseOrder>) session.getAttribute("SupplierPurchaseOrderListR");
        %>
    <center><h2>Encode Delivery Receipt</h2></center>
    <div id= "center" align="center">
        <form method="POST" action="SupplierDeliveryReceiptServlet">
            <table class="table table-bordered" width="50%" id="table">
                <thead class="fixedHeader">
                    <tr>
                        <th>Purchase Order</th>
                        <td><input name="poNumber" type="text" value="<%=PurchaseOrder.get(0).getPoNumber()%>"/></td>
                        <th>Delivery Order Number</th>
                        <td><input name="drNumber" type="text" value="dr Number"/></td>
                        <th>Updated By</th>
                        <td>updated by</td>
                    </tr>
                    <tr>
                        <th>Date Made</th>
                        <td><%= PurchaseOrder.get(0).getDateMade()%></td>
                        <th>Reconcile Status</th>
                        <td><%= PurchaseOrder.get(0).getReconcileStatus()%></td>
                    </tr>
                   
                </thead>
            </table>
            <table class="table table-bordered">
                <thead>
                 
                    <tr> 
                        <td><input type="checkbox" name="chk" onClick="" checked />Select All</td>
                    </tr>
                </thead>
                <tbody>
                     <tr>
                        <th></th>
                        <th>Item Name</th>
                        <th>Unit Price</th>
                        <th>Qty</th>
                        <th>Total Price</th>
                    </tr>
                    <%
                        for (int y = 0; y < PurchaseOrder.size(); y++) {
                    %>
                    <tr>
                        <td><input type="checkbox" name="chk" onClick="" checked/></td>
                        <td><%=PurchaseOrder.get(y).getItemCode()%></td>
                        <td><%= PurchaseOrder.get(y).getUnitPrice()%></td>
                        <td><%=PurchaseOrder.get(y).getVolumeQty() %></td>
                        <td>Total Price</td>
                    </tr>
                    <%
                        }
                    %>
                <tbody>
            </table>
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </form>
    </div>
</body>
</html>