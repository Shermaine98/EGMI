<%-- 
    Document   : Supplier Purchase Order
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.ConsumptionReport"%>
<%@page import="Model.BillOfMaterials"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.SupplierPurchaseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/deleteRow.js"></script>
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script src="bootstrap/js/jquery-ui.js"></script>
        <script src="js/searchSubcon.js"></script>
        <title>Encode Subcontractor Purchase Order</title>
        <script>
            $(document).ready(function () {
                var subPONumber = '${SubPONumber}';
                document.getElementById('poNumber').value = subPONumber;

            });

        </script>
    </head>

    <body>  
        <br/><br/><br/>
    <center><h2>Encode Subcontractor Purchase Order</h2></center><br/>
    <!--Search product-->
    <form action="SearchProductsServlet" method="POST" >
        <div align="center">
            <div class="input-group"></div>
            <input type="text" style="width:35%; height:35px" name="productName" id="productName" onkeydown="autoComplete();" placeholder="Search Item"/>
            <input type="hidden" name="productName1" id="productName1" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
            <span class="input-group-btn"><input type="submit" class="btn btn-danger" value="Search"/></span>
            <br/><br/>   
        </div> 
    </form>
    <%        ArrayList<ConsumptionReport> consumptionReport = (ArrayList<ConsumptionReport>) request.getAttribute("ConsumptionReportArray");
        ArrayList<String> itemsize = (ArrayList<String>) request.getAttribute("itemSize");
        if (!consumptionReport.isEmpty()) {
    %>
    <div align="center" class="container">
        <form method="POST" action="EncodeSubcontractorPurchaseOrderServlet">
            <!--Search Subcon-->
            <div align="center">
                <input type="text" style="width:35%; height:35px" name="subconName" id="subconName" onkeypress="autoCompleteSubcon();" placeholder="Search Subcon"/>
                <input type="hidden" name="subcon" id="subcon" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                <br/><br/>   
            </div>  
            <table class="table table-bordered" style="width:30%">
                <thead><tr>
                        <th>Purchase Order No.</th>
                        <td class="value"><input type="text" class="input" name="poNumber" id="poNumber"/></td>
                    </tr><tr>
                        <th>Production No.</th>
                        <td><input type="text" class="input" name="itemCode" value="<%= consumptionReport.get(0).getProductionNumber()%>"/></td>
                    </tr><tr>
                        <th>Prepared By</th>
                        <td><input type="hidden" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%></td>
                    </tr><tr>
                    </tr><tr>
                        <th>Delivery Date</th>
                        <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>  
                    </tr><tr>
                    </tr>
                </thead>
            </table>

            <!--Search product result-->  
            <table class="table table-bordered" style="width:30%">
                <thead><tr>
                        <th>Product Name </th>
                        <td class="value"><input type="hidden" class="input" name="productID" id="productID" value="<%= consumptionReport.get(0).getProductID()%>"/><input type="text" class="input" name="ProductName" id="ProductName" value="<%= consumptionReport.get(0).getProductName()%>"/></td>
                    </tr>
                </thead>
            </table>   
            <%
                if (consumptionReport.get(0).getSizeName().equalsIgnoreCase("Shirt")) {
            %>  
            <table class="table table-bordered" style="width:40%">
                <center><h2>Size Shirts</h2></center>
                <tr>
                    <th><input name="sizeType" class="input" value="S" readonly/></th>
                    <th><input name="sizeType" class="input" value="M" readonly/></th>
                    <th><input name="sizeType" class="input" value="L" readonly/></th>
                    <th><input name="sizeType" class="input" value="XL" readonly/></th>
                    <th>Total</th>
                </tr>
                <tr>
                <input type="hidden" name="sizeName"  value="<%= consumptionReport.get(0).getSizeName()%>" />
                <%
                    for (int i = 0; i < consumptionReport.size(); i++) {
                        if (consumptionReport.get(i).getSizeType().equalsIgnoreCase("S")) {
                %>
                <td><input type="number" class="input" name="volumeQty" id="sizeS" value="<%= consumptionReport.get(i).getVolumeQty()%>"/></td>       
                    <%
                    } else if (consumptionReport.get(i).getSizeType().equalsIgnoreCase("M")) {
                    %>   
                <td><input type="number" class="input" name="volumeQty" id="sizeM"value="<%= consumptionReport.get(i).getVolumeQty()%>"/></td>
                    <%
                    } else if (consumptionReport.get(i).getSizeType().equalsIgnoreCase("L")) {
                    %>   
                <td><input type="number" class="input" name="volumeQty" id="sizeL"value="<%= consumptionReport.get(i).getVolumeQty()%>"/></td>
                    <%
                    } else if (consumptionReport.get(i).getSizeType().equalsIgnoreCase("XL")) {
                    %>   
                <td><input type="number" class="input" name="volumeQty" id="sizeXL"value="<%= consumptionReport.get(i).getVolumeQty()%>"/></td>   
                    <%
                            }
                        }
                    %>
                <td><input name="TotalS" class="input" id="TotalS" readonly/></td>
                </tr>
            </table>

            <%
            } else {
            %>
            <table  class="table table-bordered">
                <center><h2>Size Pants</h2></center>
                <tr>
                    <th><input name="sizeType" class="input" value="29"/></th>
                    <th><input name="sizeType" class="input" value="30"/></th>
                    <th><input name="sizeType" class="input" value="31"/></th>
                    <th><input name="sizeType" class="input" value="32"/></th>
                    <th><input name="sizeType" class="input" value="33"/></th>
                    <th><input name="sizeType" class="input" value="34"/></th>
                    <th><input name="sizeType" class="input" value="36"/></th>
                    <th><input name="sizeType" class="input" value="38"/></th>
                    <th>TOTAL</th>
                </tr>
                <tr>
                <input type="hidden" name="sizeName"  value="<%=consumptionReport.get(0).getSizeName()%>" />
                <td><input type="number" class="input" name="volumeQty"  id="size29" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size30" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size31" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size32" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size33" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size34" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size36" /></td>
                <td><input type="number" class="input" name="volumeQty" id="size38" /></td>
                <td><input type="number" class="input" name="TotalP" id="TotalP"  value="0" readonly /></td>
                </tr>
            </table>
            <%
                }
            %>


            <!--Result of Search-->    
            <table id="dataSubconService" class="table table-bordered">
                <!--                <thead>Service<thead>
                                <tbody>Printing</tbody>
                -->
            </table>
            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>


            <%
                }
            %>
        </form>
    </div>
    <br/><br/>
    <script>
        $(function () {
            $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat: 'yy-mm-dd'});

        });

        function autoComplete() {
            $("#productName").devbridgeAutocomplete({
                serviceUrl: 'SearchProductsServlet',
                type: 'POST',
                showNoSuggestionNotice: true,
                noSuggestionNotice: 'No Exsiting Product'
            });
        }
    </script>
</body>
</html>
