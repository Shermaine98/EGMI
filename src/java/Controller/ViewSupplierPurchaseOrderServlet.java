package Controller;

import DAO.RefSubconDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.RefSubcon;
import Model.SupplierPurchaseOrder;
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
 * @author gcla109
 */
public class ViewSupplierPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierPurchaseOrderDAO SupplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();
        ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrderList = new  ArrayList<> ();
       
        try {
            SupplierPurchaseOrderList = SupplierPurchaseOrderDAO.GetAllSupplierPurchaseOrder();
        } catch (ParseException ex) {
            Logger.getLogger(ViewSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/ViewSupplierPurhcaseOrder.jsp");
        request.setAttribute("SupplierPurchaseOrderList", SupplierPurchaseOrderList);
        rd.forward(request, response); 
    }
}
