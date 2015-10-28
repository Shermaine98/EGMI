/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DeliveryReceiptDAO;
import DAO.SupplierDeliveryReceiptDAO;
import Model.DeliveryReceipt;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shermainesy
 */
public class GetDRForCuttingReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierDeliveryReceiptDAO DeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
        ArrayList<SupplierDeliveryReceipt> DeliveryReceiptList = new  ArrayList<> ();
        
        try {
            DeliveryReceiptList = DeliveryReceiptDAO.GetDeliveryReceiptForCuttingReport();
        } catch (ParseException ex) {
            Logger.getLogger(PurchaseOrderSerlvet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/CuttingReport.jsp");
        request.setAttribute("data", "null");
        request.setAttribute("DeliveryReceiptListCuttingReport", DeliveryReceiptList);
        rd.forward(request, response); 
    }
}
