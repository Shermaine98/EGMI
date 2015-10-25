<%-- 
    Document   : Bill of Materials
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page import="Model.SubconPurchaseOrder"%>
<%@page import="Model.SubconPurchaseOrder"%>
<%@page import="Model.PurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
        <title>Receiving</title>
        <script>
            $(document).ready(function () {
                $('#dataTable').DataTable({
                    "paging": false,
                    "info": false,
                    "dom": '<"pull-left "f>'
                });

                $(".viewpurchaseOrder").on("click", (function () {
                    var purchaseOrderNum = $(this).closest("tr").find(".purchaseOrderNum").text();
                    var inventoryType = $(this).closest("tr").find(".inventoryType").text();
                    document.getElementById('hiddenValue').value = purchaseOrderNum;
                    document.getElementById('inventoryType').value = inventoryType;
                    var l = document.getElementById('hiddenValue').value;
                    console.log(l);

                    document.getElementById("form1").submit();

                }));
            });
        </script>
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Receiving</h2></center>

    <br/><br/>
    <%        ArrayList<PurchaseOrder> PurchaseOrderList = (ArrayList<PurchaseOrder>) request.getAttribute("accessoriesPurchaseOrder");
    %>
    <form id="form1" method="POST" action="GetPurchaseOrderReconcileServlet">
        <div align="center" class="container">
            <table id="dataTable" class="table table-striped table-bordered table-hover table-responsive dataTable" style="width:80%">
                <thead>
                    <tr>
                        <th>Purchase Order Number</th>
                        <th>Date Made</th>
                        <th>Delivery Date</th>
                        <th>Prepared By</th>
                        <th>Receiving Status</th>
                        <th>Reconcile Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < PurchaseOrderList.size(); i++) {
                    %> 

                    <tr class="viewpurchaseOrder">
                        <td class="purchaseOrderNum"><%=PurchaseOrderList.get(i).getPoNumber()%></td>
                        <td class="inventoryType"> <%= PurchaseOrderList.get(i).getDateMade()%></td>
                        <td><%= PurchaseOrderList.get(i).getDeliveryDate()%></td>
                        <td><%= PurchaseOrderList.get(i).getPreparedBy()%></td>
                        <td><%= PurchaseOrderList.get(i).getReceivingStatus()%></td>
                        <td><%= PurchaseOrderList.get(i).getReconcileStatus()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <input type="hidden" name="hiddenValue" id="hiddenValue" value=""/>
            <input type="hidden" name="inventoryType" id="inventoryType" value=""/>
        </div>

    </form>
    <!--Supplier Delivery Receipt--> 
    <%
       ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrder = (ArrayList<SupplierPurchaseOrder>) request.getAttribute("");
    %>
    <center><h2>Encode Supplier Purchase Order</h2></center>

    <form method="POST" action="EncodeSupplierDeliveryReceiptServlet">
            
    </form>

    <script></script>
</body>

</html>
