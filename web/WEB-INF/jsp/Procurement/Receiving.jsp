<%-- 
    Document   : Bill of Materials
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--Bootstrap core CSS-->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <link rel="stylesheet" type="text/css" href="bootstrap/searchInput.css">
        <title>Receiving</title>
    
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Receiving</h2></center>
    <div class="container">
        <div class="row" align="center">
           
            <div id="custom-search-input">
                <div class="input-group col-md-12 width35" >
                    <input type="text" class="search-query form-control" placeholder="Search Purchase Order" />
                    <span class="input-group-btn">
                        <button class="btn btn-danger" type="button">
                            <span class=" glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <br/><br/>
    <div align="center">
    
    </div>
    <br/><br/>
    <%
    ArrayList <SupplierPurchaseOrder> arraySupplier = (ArrayList<SupplierPurchaseOrder>) session.getAttribute("SuppliersAndItems");
            %>
    <div align="center" class="container">
        <table id="dataTable" class="table table-bordered" style="width:80%">
            <thead>
                <tr>
                    <th>Purchase Order Number</th>
                    <th>Purchase Order Type</th>
                    <th>Inventory Type</th>
                    <th>Status</th>
                    <th>Vendor</th>
                    <th>Date Made</th>
                    <th>Delivery Date</th>
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
                </tr>
            </tbody>
        </table>

        <br/><br/>
        <br/><br/>
        <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Create">
        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
    </div>
<!--
     <br/>
  
    <center><h2>Encode Supplier Purchase Order</h2></center>
    <form method="POST" action="EncodeSupplierPurchaseOrderServlet">
        <div align="center" class="container width35">
            <table class="table table-bordered">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Purchase Order number</th>
                        <td class="value"><input type="text" class="input" readonly name="poNumber" value="AUTO"/></td>
                    </tr>
                    <tr>
                        <th>Prepared By</th>
                        <td><input type="text" class="input" name="preparedBy" readonly value="AUTO"/></td>
                    </tr>
                    <tr>
                        <th>Date Made</th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="AUTO"/></td>  
                    </tr>
                    <tr>
                        <th>Delivery </th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="datepicker" /></td>                 
                    </tr>
                    <tr>
                        <th>Date Made</th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="auto" /></td>                 
                    </tr>
                </thead>
            </table>
            <h2>Search Product</h2>
            <div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input type="text" class="  search-query form-control" placeholder="Search" />
                    <span class="input-group-btn">
                        <button class="btn btn-danger" type="button">
                            <span class=" glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </div>
            <br/><br/>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th></th>
                        <th>Item Code</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Total Quantity Price</th>
                        <th>Quantity Received</th>
                    </tr>
                </thead>
                <tbody id="dataTable">
                    <tr>
                        <td><input type="checkbox" name="chk" /></td>
                        <td><input type="text" class="input" name="itemCode" value="dropdown or search"/></td>
                        <td><input type="text" class="input" name="unitPrice"/></td>
                        <td><input type="text" class="input" name="qty"/></td>
                        <td><input type="text" class="input" name="Total Price" value ="unitPrice*Qty"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th>TOTAL:</th>
                        <td><input type="text" class="input" name="Total" value ="TOTAL"/></td>
                    </tr>
                </tbody>
            </table>
            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>

<--
    <br/>
 
    <center><h2>Encode Supplier Purchase Order</h2></center>
    <form method="POST" action="EncodeSubcontractorPurchaseOrderServlet">
        <div align="center" class="container">
            <table class="table table-bordered width35">
                <thead>
                    <tr>
                        <th>Purchase Order number</th>
                        <td class="value"><input type="text" class="input" name="poNumber" /></td>
                    </tr>
                    <tr>
                        <th>Production Number</th>
                        <td><input type="text" class="input" name="itemCode" /></td>
                    </tr>
                    <tr>
                        <th>Prepared By</th>
                        <td><input type="text" class="input" name="preparedBy" /></td>
                    </tr>

                    <tr>
                        <th>Delivery Date</th>
                        <td><input type="text" class="input" name="deliveryDate" /></td>
                    </tr>
                    <tr>
                        <th>Vendor Type</th>
                        <td> <select name="vendorType">
                                <option value="Complete">All the Vendor Types</option>
                                <option value=""></option>
                                <option value=""></option>
                            </select></td>
                    </tr>
                </thead>
            </table>
            <table class="table table-bordered width35">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Subcontractor</th>
                        <td><input type="text" class="input" name="deliveryDate" value="fast search but filtred by vendor type"/></td>
                    </tr>
                </thead>
            </table>
            <table class="table table-bordered width35">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <td><input type="text" class="input" name="productName"/></td>
                    </tr>
                </thead>
            </table>
            <center> <h2>Encode Supplier Purchase Order</h2> </center>
            <table class="table table-bordered width35">
                <thead>
                    <tr>
                        <th>S</th>
                        <th>M</th>
                        <th>L</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody id="dataTable">
                    <tr>
                        <td><input type="text" class="input" name="S" size="12" /></td>
                        <td class="value"><input type="text" class="input" name="M" size="12"/></td>
                        <td><input type="text" class="input" name="L" size="12"/></td>
                        <td><input type="text" class="input" name="qty" size="12"/></td>
                        <td><input type="text" class="input" name="total" size="12"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th>TOTAL:</th>
                        <td><input type="text" class="input" name="Total" size="12" value ="TOTAL"/></td>
                    </tr>
                </tbody>

            </table>

            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
-->
<script>  </script>
</body>

</html>
