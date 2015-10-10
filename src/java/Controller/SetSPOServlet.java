package Controller;

import DAO.RefSupplierDAO;
import DAO.SupplierPurchaseOrderDAO;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class SetSPOServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefSupplierDAO refSupplierDAO = new RefSupplierDAO();
        SupplierPurchaseOrderDAO DAO = new SupplierPurchaseOrderDAO();
        Integer SupplierpurchaseOrder=0;
        ArrayList<String> supplierName = new ArrayList<>();
        try {
            SupplierpurchaseOrder = DAO.getSupplierPurchaseOrderNumber();
            supplierName = refSupplierDAO.GetSupplierName();
        } catch (SQLException ex) {
            Logger.getLogger(SetSPOServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        ServletContext context = getServletContext();

        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/SupplierPurchaseOrder.jsp");
        request.setAttribute("SPONumber",SupplierpurchaseOrder );
         request.setAttribute("supplierName",supplierName );
        rd.forward(request, response);

    }
}
