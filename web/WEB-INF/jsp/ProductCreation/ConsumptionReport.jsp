<%-- 
    Document   : EncodeConsumptionReport
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.BillOfMaterials"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.ConsumptionReport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <title>Encode Consumption Report</title>
    </head>
    <body>  
    <center><h2>Encode Bill of Materials</h2></center>
    <div align="center">
        <form method="POST" action="SetProductServlet">
            <input type="text" style="width:35%; height:35px" name="productName1" id="productName1" onkeydown="autoComplete();" placeholder="Search Item"/>
            <input type="hidden" name="productName1" id="productName1" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Search"/>
            <br/><br/>
        </form>
    </div>
    <%        
        String data = (String) request.getAttribute("data");
        if(data.equals("success")){
        ArrayList<BillOfMaterials> billOfMaterialspID = (ArrayList<BillOfMaterials>) request.getAttribute("BillOfMaterialsConsumption");
        Integer n = (Integer) request.getAttribute("CRPRNumber");
        
    %>

    <br/>
    <center><h2>Encode Consumption Report</h2></center>
    <form method="POST" action="EncodeConsumptionReportServlet">
        <div align="center" class="container">
            <table class="table width35 table-bordered">
                <th>Production #</th>
                <td class="value"><input type="text" class="input" name="productionNumber" value="<%=n%>"/></td>
                <tr>
                    <th>Prepared By</th> 
                    <td><input type="hidden" name="preparedBy" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%> <%= user.getLastName()%></td>
                </tr>
                <tr>
                    <th>Date Made</th>
                    <td><input type="text" class="input" name="dateMade"  readonly value="<% ConsumptionReport x = new ConsumptionReport();
                        x.setDateMade();%><%=x.getDateMade()%>"/></td>                 
                </tr>
            </table>
            <%
                if (billOfMaterialspID.get(0).getSizeName().equalsIgnoreCase("Shirt")) {
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
                <input type="hidden" name="sizeName"  value="<%= billOfMaterialspID.get(0).getSizeName()%>" />
                <td><input type="number" class="input" name="volumeQty" id="sizeS" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
                <td><input type="number" class="input" name="volumeQty" id="sizeM"  onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
                <td><input type="number" class="input" name="volumeQty" id="sizeL" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0"  /></td>
                <td><input type="number" class="input" name="volumeQty" id="sizeXL" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
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
                <input type="hidden" name="sizeName"  value="<%=billOfMaterialspID.get(0).getSizeName()%>" />
                <td><input type="number" class="input" name="volumeQty"  id="size29" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size30" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size31" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size32" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size33" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size34" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size36" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="volumeQty" id="size38" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                <td><input type="number" class="input" name="TotalP" id="TotalP"  value="0" readonly /></td>
                </tr>
            </table>
            <%
                }
            %>
            <center><h1>Bill of Materials</h1></center>
            <table class="table detailsWidth table-bordered">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <td><input  name="productID" class="input" value="<%=billOfMaterialspID.get(0).getProductID()%>"/></td>
                        <th>Product Name</th>
                        <td><input name="ProductName" class="input" value="<%=billOfMaterialspID.get(0).getProductName()%>"/></td>
                    </tr>
                </thead>
            </table>
            <table  id="dataTable3" class="table detailsWidth table-bordered">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Consumption Per Unit</th>
                        <th>Total Consumption</th>
                    </tr>
                </thead>
                <tbody >
                    <%
                        for (int i = 0; i < billOfMaterialspID.size(); i++) {
                    %>
                    <tr>
                        <td><input type="text" class="input" name="itemCode"  value = "<%=billOfMaterialspID.get(i).getItemCode()%>"  readonly/></td>
                        <td><input name="itemConsumption" class="input" id="itemConsumption[]"   value="<%=billOfMaterialspID.get(i).getItemConsumption()%>" readonly/></td>               
                        <td><input name="totalConsumption" class="input" id="totalConsumption[]" value="0"  readonly/></td>
                    </tr> 
                    <%
                        }
                    %>
                </tbody>
            </table>
            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit"/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger" >Cancel</button></a>
        </div>
    </form>
    <%
        }
    %>      

    <script>

        function autoComplete() {
            $("#productName1").devbridgeAutocomplete({
                serviceUrl: 'SearchProductServlet',
                type: 'POST',
                showNoSuggestionNotice: true,
                noSuggestionNotice: 'No Exsiting Item',
            });
        }
        ;
        function calculateTotalShirt() {
            var sizeS = parseInt(document.getElementById('sizeS').value);
            var sizeM = parseInt(document.getElementById('sizeM').value);
            var sizeL = parseInt(document.getElementById('sizeL').value);
            var sizeXL = parseInt(document.getElementById('sizeXL').value);
            var totalS = sizeS + sizeM + sizeL + sizeXL;
            document.getElementById('TotalS').value = totalS;
            SolveTotal(totalS);
        }
        function calculateTotalPants() {
            var size29 = parseInt(document.getElementById('size29').value);
            var size30 = parseInt(document.getElementById('size30').value);
            var size31 = parseInt(document.getElementById('size31').value);
            var size32 = parseInt(document.getElementById('size32').value);
            var size33 = parseInt(document.getElementById('size33').value);
            var size34 = parseInt(document.getElementById('size34').value);
            var size36 = parseInt(document.getElementById('size36').value);
            var size38 = parseInt(document.getElementById('size38').value);

            var totalP = size29 + size30 + size31 + size32 + size33 + size34 + size36 + size38;
            document.getElementById('TotalP').value = totalP;
            SolveTotal(totalP);
        }

        function SolveTotal(Total) {
            $("#dataTable3 tbody tr").each(function () {
                var Total2 =0;
                var $this = $(this);
                var CPU = parseInt($this.find('[id="itemConsumption\\[\\]"]').val());
                Total2 = (CPU * Total);
                $this.find('[id="totalConsumption\\[\\]"]').val(Total2);
            });
            return false;
        }
        
        
        $('form').on('focus', 'input[type=number]', function (e) {
            $(this).on('mousewheel.disableScroll', function (e) {
                e.preventDefault();
            });
        });
        $('form').on('blur', 'input[type=number]', function (e) {
            $(this).off('mousewheel.disableScroll');
        });


    </script>              
</body>
</html>
