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
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <title>Encode Consumption Report</title>
    </head>


    <body>  
        <br/>
        <div align="center">
            <h2>Encode Bill of Materials</h2>
            <form method="POST" action="SetProductServlet">
                <input class="search" name="productName1" id="productName1" onkeydown="autoComplete();" placeholder="Search Item"/>
                <input type="hidden" name="productName1" id="productName1" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                <input type="submit" class="btn btn-danger" value="Search"/>
                <br/><br/>
            </form>
        </div>
        
        <%        String data = (String) request.getAttribute("data");
            if (data.equals("success")) {
                ArrayList<BillOfMaterials> billOfMaterialspID = (ArrayList<BillOfMaterials>) request.getAttribute("BillOfMaterialsConsumption");
                Integer n = (Integer) request.getAttribute("CRPRNumber");

        %>

        <br/>
        <div align="center" class="container">
            <h2>Encode Consumption Report</h2>
            <form method="POST" action="EncodeConsumptionReportServlet">

                <table class="table table-bordered">
                    <th>Production #</th>
                    <td class="value"><input type="text" name="productionNumber" value="<%=n%>" readonly/></td>
                    <tr>
                        <th>Prepared By</th> 
                        <td><input type="hidden" name="preparedBy" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%> <%= user.getLastName()%></td>
                    </tr>
                    <tr>
                        <th>Date Made</th>
                        <td><input type="text" name="dateMade"  readonly value="<% ConsumptionReport x = new ConsumptionReport();
                        x.setDateMade();%><%=x.getDateMade()%>"/></td>                 
                    </tr>
                </table>
                <%
                    if (billOfMaterialspID.get(0).getSizeName().equalsIgnoreCase("Shirt")) {
                %>  
                <table class="table table-bordered" style="width:40%">
                    <h2>Size Shirts</h2>
                    <tr>
                        <th><input name="sizeType" type="text" value="S" readonly /></th>
                        <th><input name="sizeType" type="text" value="M" readonly /></th>
                        <th><input name="sizeType" type="text" value="L" readonly /></th>
                        <th><input name="sizeType" type="text" value="XL" readonly /></th>
                        <th>Total</th>
                    </tr>
                    <tr>
                    <input type="hidden" name="sizeName"  value="<%= billOfMaterialspID.get(0).getSizeName()%>" />
                    <td><input type="number" name="volumeQty" id="sizeS" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
                    <td><input type="number" name="volumeQty" id="sizeM"  onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
                    <td><input type="number" name="volumeQty" id="sizeL" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0"  /></td>
                    <td><input type="number" name="volumeQty" id="sizeXL" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalShirt();" value="0" /></td>
                    <td><input name="TotalS" id="TotalS" readonly /></td>
                    </tr>
                </table>

                <%
                } else {
                %>
                <table class="table table-bordered">
                    <center><h2>Size Pants</h2></center>
                    <tr>
                        <th><input name="sizeType" type="text" value="29" readonly /></th>
                        <th><input name="sizeType" type="text" value="30" readonly /></th>
                        <th><input name="sizeType" type="text" value="31" readonly /></th>
                        <th><input name="sizeType" type="text" value="32" readonly /></th>
                        <th><input name="sizeType" type="text" value="33" readonly /></th>
                        <th><input name="sizeType" type="text" value="34" readonly /></th>
                        <th><input name="sizeType" type="text" value="36" readonly /></th>
                        <th><input name="sizeType" type="text" value="38" readonly /></th>
                        <th>TOTAL</th>
                    </tr>
                    <tr>
                    <input type="hidden" name="sizeName"  value="<%=billOfMaterialspID.get(0).getSizeName()%>" />
                    <td><input type="number" name="volumeQty"  id="size29" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size30" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size31" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size32" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size33" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size34" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size36" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="volumeQty" id="size38" onkeypress="return event.charCode >= 48 && event.charCode <= 57" onChange="calculateTotalPants();" value="0"/></td>
                    <td><input type="number" name="TotalP" id="TotalP"  value="0" readonly /></td>
                    </tr>
                </table>
                <%
                    }
                %>
                <center><h1>Bill of Materials</h1></center>
                <table class="table table-bordered">
                    <colgroup>
                        <col style="width:50%"/>
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <td><input type="text" name="productID" value="<%=billOfMaterialspID.get(0).getProductID()%>" readonly/></td>
                            <th>Product Name</th>
                            <td><input type="text" name="ProductName" value="<%=billOfMaterialspID.get(0).getProductName()%>" readonly/></td>
                        </tr>
                    </thead>
                </table>
                <table id="dataTable3" class="table table-bordered">
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
                            <td><input type="text" name="itemCode"  value = "<%=billOfMaterialspID.get(i).getItemCode()%>"  readonly/></td>
                            <td><input type="text" name="itemConsumption" id="itemConsumption[]"   value="<%=billOfMaterialspID.get(i).getItemConsumption()%>" readonly/></td>               
                            <td><input type="text" name="totalConsumption" id="totalConsumption[]" value="0"  readonly/></td>
                        </tr> 
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <br/><br/>
                <input type="submit" class="btn btn-danger" value="Submit"/>
                <a href="\..\..\Accounts\Homepage.jsp"><button type="button" class="btn btn-danger" >Cancel</button></a>

            </form>
        </div>
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
                    var Total2 = 0;
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
        <br/><br/>
    </body>
</html>
