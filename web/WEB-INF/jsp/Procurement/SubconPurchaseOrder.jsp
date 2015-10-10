<%-- 
    Document   : Supplier Purchase Order
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
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <title>Encode Subcontractor Purchase Order</title>
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script src="bootstrap/js/jquery-ui.js"></script>

    </head>

    <body>  
        <br/><br/><br/>
    <center><h2>Encode Subcontractor Purchase Order</h2></center><br/>
    <form method="POST" action="EncodeSubcontractorPurchaseOrderServlet">
        <div align="center" class="container">
            <table class="table table-bordered" style="width:30%">
                <thead><tr>
                        <th>Purchase Order No.</th>
                        <td class="value"><input type="text" class="input" name="poNumber"/></td>
                    </tr><tr>
                        <th>Production No.</th>
                        <td><input type="text" class="input" name="itemCode"/></td>
                    </tr><tr>
                        <th>Prepared By</th>
                        <td><input type="hidden" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%></td>
                    </tr><tr>
                        <th>Date Made</th>
                        <td><input type="text" name="dateMade" class="input" readonly
                                   value=""/></td> 
                    </tr><tr>
                        <th>Delivery Date</th>
                        <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>  
                    </tr><tr>
                        <th>Vendor Type</th>
                        <td> <select name="vendorType">
                                <option value="Printing">Printing</option>
                                <option value="Washing">Washing</option>
                                <option value="Sewing">Sewing</option>
                                <option value="ALL">ALL</option>
                            </select></td>
                    </tr>
                </thead>
            </table>

            <table class="table detailsWidth table-bordered">
                <colgroup>
                    <col style="width:30%"/>
                </colgroup>
                <thead><tr>
                        <th>Subcontractor</th>
                    </tr>
                    <tr>
                        <td><input type="text" class="input" name="" value=""/></td>
                    </tr></thead>
            </table>

            <table class="table detailsWidth table-bordered">
                <colgroup>
                    <col style="width:30%"/>
                </colgroup>
                <thead><tr>
                        <th>Product Name</th> </tr>
                <td><input type="text" class="input" name="productName"/></td>
                </tr></thead>
            </table>
            <table class="table detailsWidth table-bordered">
                <thead>
                    <tr>
                        <th>S</th>
                        <th>M</th>
                        <th>L</th>
                    </tr>
                </thead>
                <tbody id="dataTable">
                    <tr>
                        
                        <td><input type="text" class="input" name="S"/></td>
                        <td class="value"><input type="text" class="input" name="M"/></td>
                        <td><input type="text" class="input" name="L"/></td>
                    </tr>

                </tbody>
            </table>
            <table class="table detailsWidth table-bordered">
                <tbody>
                    <tr>
                        <th>TOTAL:</th>
                        <td><input type="text" name="Total" class="input" value =""/></td>
                    </tr>
                </tbody>
            </table>

            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <br/><br/>
    <script>
        $(function () {
            $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat: 'yy-mm-dd'});

        });
    </script>
</body>
</html>
