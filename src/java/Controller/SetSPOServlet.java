package Controller;

import DAO.BillOfMaterialsDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.BillOfMaterials;
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
 * @author gcla109
 */
public class SetSPOServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        SupplierPurchaseOrderDAO DAO = new SupplierPurchaseOrderDAO();
        Integer spoNumber=0;
        try {
            spoNumber = DAO.getSupplierNumber();
        } catch (SQLException ex) {
            Logger.getLogger(SetPIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/SupplierPurchaseOrder.jsp");
        request.setAttribute("SPONumber", spoNumber);
        rd.forward(request, response);

       

    }
}
