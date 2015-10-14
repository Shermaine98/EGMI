<%-- 
    Document   : DeliveryReceipt
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.ProductionInventory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.PickingForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/tableBoarder.css">
        <title>Accessories Inventory</title>
        
    </head>
    <body>  
        <br/><br/><br/>
        <form method="POST" action="">
            <div class="container">
                <div class="row">
                    <h2>Search Purchase Order Number</h2>
                    <div id="custom-search-input">
                        <div class="input-group col-md-12">
                            <input name="poNumber" type="text" class="search-query form-control" placeholder="Search" />
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-danger">
                                    <span class=" glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    <center>
        <table class="table table-bordered" style="width:30%">
            <colgroup>
                <col style="width:20%"/>
                <col style="width:80%"/>
            </colgroup>
            <thead>
            <th>Filter</th>
            <td><select name="Filter">
                    <option value="Complete">Date Made</option>
                    <option value="Product">Product Name</option>
                    <option value=""></option>
                </select></td>
            </thead>
        </table><br/>
    </center>
    <%            ArrayList<ProductionInventory> ProductionInventory = (ArrayList<ProductionInventory>) session.getAttribute("ProductionInventoryList");
    %>
    <center><h2>Accessories Inventory</h2></center>
    <div align="center" class="container">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Production Number</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%for (int i = 0; i < ProductionInventory.size(); i++) {%>
                <tr>
                    <td><%=ProductionInventory.get(i).getPoNumber()%></td>
                    <td><%=ProductionInventory.get(i).getDateUpdated() %></td>
                    <td></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <br/><br/>

        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back</button></a>
    </div>

</body>
</html>
