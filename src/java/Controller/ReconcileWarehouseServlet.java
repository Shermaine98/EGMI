package Controller;

import DAO.PurchaseOrderDAO;
import DAO.RefSupplierDAO;
import Model.PurchaseOrder;
import Model.RefSupplier;
import Model.SubconPurchaseOrder;
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
public class ReconcileWarehouseServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PurchaseOrderDAO PurchaseOrderDAO = new PurchaseOrderDAO();
        ArrayList<PurchaseOrder> wPurchaseOrderList = new  ArrayList<> ();
        
        try {
            wPurchaseOrderList = PurchaseOrderDAO.GetWarehousePurchaseOrder();
        } catch (ParseException ex) {
            Logger.getLogger(PurchaseOrderSerlvet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/ReconcileWarehouse.jsp");
        request.setAttribute("data", "null");
        request.setAttribute("warehousePurchaseOrder", wPurchaseOrderList);
        rd.forward(request, response); 
    }
}
