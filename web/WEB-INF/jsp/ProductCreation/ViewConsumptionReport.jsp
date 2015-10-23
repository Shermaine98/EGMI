<%-- 
    Document   : ViewConsumptionReport
    Created on : 10 1, 15, 12:10:28 AM
    Author     : Geraldine
--%>

<%@page import="DAO.BillOfMaterialsDAO"%>
<%@page import="Model.ConsumptionReport"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/LevelOfAccess/LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
        <title>View Consumption Report</title>

        <script>
            $(document).ready(function () {

                $(".production").on("click", (function () {
                    var productionNumber = $(this).closest("tr").find(".productionNumber").text();
                    $.ajax({
                        url: "GetConsumptionReportServlet",
                        type: 'POST',
                        dataType: "json",
                        data: {
                            productionNumber: productionNumber
                        },
                        success: function (data) {


                            $('#consumptionReportList').empty()
                            $('#consumptionReportList').append('Production Number: ' + data[0].productionNumber + '<br/>');
                            $('#consumptionReportList').append('Product ID: ' + data[0].productID + '<br/>');
                            $('#consumptionReportList').append('Date Made: ' + data[0].dateMade + '<br/>');
                            $('#consumptionReportList').append('Prepared By: ' + data[0].preparedBy + '<br/>');
                            $('#consumptionReportList').append('Size Type: ' + data[0].SizeType + '<br/>');
                            $('#consumptionReportList').append('Size Name: ' + data[0].SizeName + '<br/>');
                            for (var i = 0; i < data.length; i++) {
                                $('#consumptionReportList').append('Volume Quantity: ' + data[i].volumeQty + '<br/>');
                            }
                            $('#consumptionReportList').append('Item Code: ' + data[0].itemCode + '<br/>');

                            $('#consumptionReportList').append('<input id="TotalS" class="transparentBg" name="TotalS" onload="calculateTotalShirt()" />');
                            //     $('#consumptionReportList').append('<tr><td>' + data[0].productionNumber + '</td><td>' + data[0].dateMade + '</td><td>' + data[0].productionNumber + '</td><td>' + data[0].preparedBy + '</td></tr>');

                        },
                        error: function (XMLHttpRequest, textStatus, exception) {
                            alert(XMLHttpRequest.responseText);
                        }
                    });
                }));
            });

            $(document).ready(function () {
                $('#view').DataTable({
                    "paging": false,
                    "info": false,
                    "dom": '<"pull-left "f>'
                });
            });
        </script>    

    </head>
    <body>
        <br/><br/><br/>
    <center> <h2>View Consumption Report</h2></center>
    <br/><br/><br/>    
    <% String data = (String) request.getAttribute("data");
        if (data.equalsIgnoreCase("ViewConsumptionReport")) {
            ArrayList<ConsumptionReport> cr = (ArrayList<ConsumptionReport>) request.getAttribute("crList"); %>
    <!--View Consumption Report-->
    <table id="view" class="table table-striped table-bordered table-hover table-responsive" style="width:80%">
        <thead>
            <tr>
                <th>Production No.</th>
                <th>Product ID</th>
                <th>Size Name</th>
                <th>Size Type</th>
                <th>Prepared By</th>
            </tr>
        </thead>

        <tbody>
            <%
                for (int i = 0; i < cr.size(); i++) {
            %>
            <tr class="production">
                <td class="productionNumber"><%= cr.get(i).getProductionNumber()%></td>
                <td><%= cr.get(i).getProductID()%></td>
                <td><%= cr.get(i).getSizeName()%></td>
                <td><%= cr.get(i).getDateMade()%></td>
                <td><%= cr.get(i).getPreparedBy()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <br/><br/>
    <!-- To get the Click row-->   
    <div class="panel panel-default col-lg-6 col-md-6 col-sm-6">
        <div class="panel-body" id="consumptionReportList">
        </div>
    </div>
    <%
    } else if (data.equalsIgnoreCase("ConsumptionReportView")) {
        ArrayList<ConsumptionReport> cr1 = (ArrayList<ConsumptionReport>) request.getAttribute("consumptionReport");
        BillOfMaterialsDAO bmDAO = new BillOfMaterialsDAO();

    %>
    <!--Consumption Report View From Encode of Bill of Materials-->

    <div align="center" class="container">
        <table class="table width35 table-bordered">
            <th>Production #</th>
            <td><%= cr1.get(0).getProductID()%></td>
            <tr>
                <th>Prepared By</th> 
                <td><%= cr1.get(0).getPreparedBy()%></td>
            </tr>
            <tr>
                <th>Date Made</th>
                <td><%=cr1.get(0).getDateMade()%></td>                 
            </tr>
        </table>

        <table class="table detailsWidth table-bordered">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <td><%=cr1.get(0).getProductID()%></td>
                    <th>Product Name</th>
                    <td><%= cr1.get(0).getProductName()%></td>
                </tr>
            </thead>
        </table>
        <%
            if (cr1.get(0).getSizeName().equalsIgnoreCase("Shirt")) {
        %>  
        <table class="table table-bordered" style="width:40%">
            <center><h2>Size Shirts</h2></center>
            <tr>  
                <%
                    for (int m = 0; m < cr1.size(); m++) {
                %>
                <th><%=cr1.get(m).getSizeType()%>"</th>
                <td class="volumeQty"><%=cr1.get(m).getVolumeQty()%>"</td>
                <th><input id="TotalS" name="TotalS" value="0" onload="calculateTotalShirt()" /></th>
            </tr>
            <%
                }
            %>

        </table>

        <%
        } else {
        %>
        <table  class="table table-bordered">
            <center><h2>Size Pants</h2></center>
            <tr>  
                <%
                    for (int m = 0; m < cr1.size(); m++) {
                %>
                <th><%=cr1.get(m).getSizeType()%></th>
                    <%
                        }

                    %>
            </tr>  <tr>
                <%for (int m = 0; m < cr1.size(); m++) {%>

                <td><%=cr1.get(m).getVolumeQty()%></td>


                <%

                    } %>
            </tr> <%
                }
            %>
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
                        ArrayList<Integer> itemCode = (ArrayList<Integer>) request.getAttribute("itemCode");
                        for (int i = 0; i < itemCode.size(); i++) {
                    %>
                    <tr>
                        <td><input type="text" class="input" name="itemCode"  value = "<%=cr1.get(i).getItemCode()%>"  readonly/></td>
                        <td><input name="itemConsumption" class="input" id="itemConsumption[]"   value="0" readonly/></td>               
                        <td><input name="totalConsumption" class="input" id="totalConsumption[]" value="0"  readonly/></td>
                    </tr> 
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                }
            %>
            <br/><br/>

    </div>
    <script>
        $("#consumptionReportList").on("load", function () {
            var totalS = 0;
            $('td.volumeQty').each(function () {
                totalS = parseInt($(this).find(".volumeQty").text());
                console.log(totalS);
            });
            //document.getElementById('TotalS').value = totalS;
            //    SolveTotal(totalS);

        });

        function calculateTotalPants() {

            var totalP = size29 + size30 + size31 + size32 + size33 + size34 + size36 + size38;
            document.getElementById('TotalP').value = totalP;
            SolveTotal(totalP);
        }
    </script>
</body>
</html>
