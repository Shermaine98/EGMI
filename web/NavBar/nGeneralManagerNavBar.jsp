<%-- 
    Document   : AssitantProductionManagerNavBar
    Created on : Aug 20, 2015, 7:15:16 PM
    Author     : shermainesy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <!--<title>Welcome to Hammerhead!</title>-->
    </head>
    <body>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-left"><img src="Images/hhlogo.png" height="50" width="50"></a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li> <a href="Accounts/Homepage.jsp">Home</a></li>
                        <!--Product Creation-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Product Creation
                                <span class="caret"></span></a> 
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="">Bill Of Materials</a></li>
                                <li><a href="/EGMI/SetPIDServlet">Encode Bill Of Materials</a></li>
                                <li><a href="">View Bill of Materials</a></li>
                                <li><a href="">Consumption Report</a></li>
                                <li><a href="/EGMI/SetPDIDServlet">Encode Consumption Report</a></li>
                                <li><a href="/EGMI/ViewConsumptionReportServlet">View Consumption Report</a></li>
                            </ul>
                        </li>
                        
                        <!--Procurement-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Procurement
                                <span class="caret"></span></a> 
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="">Supplier Purchase Order</a></li>
                                <li><a href="/EGMI/SetSPOServlet">Encode Supplier Purchase Order</a></li>
                                <li><a href="">View Supplier Purchase Order</a></li>
                                <li><a href="">Subcontractor Purchase Order</a></li>
                                <li><a href="SubconPurchaseOrder.jsp">Encode Subcontractor Purchase Order</a></li>
                                <li><a href="">View Subcontractor Purchase Order</a></li>
                                <li><a href="Receiving.jsp">Receiving</a></li>
                                <li class="divider"></li>
                                <li><a href="CuttingReport.jsp">Encode Cutting Report</a></li>
                                <li><a href="">View Cutting Report</a></li>
                            </ul>
                        </li>
                        
                        <!--Inventory-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Inventory
                                <span class="caret"></span></a> 
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/EGMI/GetAccessoriesInventoryServlet">Accessories Inventory</a></li>
                                <li><a href="/EGMI/GetProductionInventoryServlet">Production Inventory</a></li>
                                <li><a href="/EGMI/GetWarehouseInventoryServlet">Warehouse Inventory</a></li>
                                <li class="divider"></li>
                                <li><a href="BoutiqueInventory.jsp">Boutique Inventory</a></li>
                            </ul>
                        </li>
                        
                        <!--DELIVERY-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Delivery
                                <span class="caret"></span></a> 
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="ReplenishmentRequest.jsp">Replenishment Request</a></li>
                                <li><a href="PickingForm.jsp">Picking Form</a></li>
                                <li><a href="/EGMI/GetPickingFormForDeliveryOrderServlet">Delivery Order</a></li>
                                <li><a href="DeliveryReceipt.jsp">Delivery Receipt</a></li>
                            </ul>
                        </li>
                        
                        <!--Vendor-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Vendor
                                <span class="caret"></span></a> 
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/EGMI/ViewSuppliersAndItemServlet">Suppliers</a></li>
                                <li><a href="/EGMI/ViewSubcontractorAndServiceServlet">Subcontractor</a></li>
                            </ul>
                        </li>
                    </ul>

                    
                    <!--MAIL-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="https://mail.google.com/">
                                <span class="glyphicon glyphicon-envelope"></span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-bell"></span><b class="caret"></b></a>
                            <ul class="dropdown-menu alert-dropdown">
                                <li><a href="#">Alert Name <span class="label label-default">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-success">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-info">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a></li>
                                <li class="divider"></li>
                                <li><a href="#">View All</a></li>
                            </ul>
                        </li>
                        
                        <!--ACCOUNT DETAILS-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-user"></span>
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="myaccount.jsp">View Account</a></li>
                                <li><a href="editaccount.jsp">Edit Account</a></li>
                                <li><a href="/EGMIInventoryManagementSystem/Logout">Log-Out</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <script src="bootstrap/js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>

    </body>

</html>
