/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SubconPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shermainesy
 */
public class ViewSubconPurchaseOrderServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();
        ArrayList<SubconPurchaseOrder> SubconPurchaseOrderList = new  ArrayList<SubconPurchaseOrder> ();
        try {
            SubconPurchaseOrderList = SubconPurchaseOrderDAO.MonitorSubconPurchaseOrder();
        } catch (ParseException ex) {
            Logger.getLogger(ViewSubconPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/ViewSubconPurchaseOrder.jsp");
        request.setAttribute("SubconPurchaseOrderList", SubconPurchaseOrderList);
        rd.forward(request, response); 
    }

}
