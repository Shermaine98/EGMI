package Controller;

import DAO.RefSupplierDAO;
import Model.RefSupplier;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gcla109
 */
public class ViewSuppliersAndItemServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefSupplierDAO RefSupplierDAO = new RefSupplierDAO();
        ArrayList<RefSupplier> RefSupplierList = new  ArrayList<RefSupplier> ();
       
        RefSupplierList = RefSupplierDAO.MonitorRefSupplier();
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/SuppliersAndItems.jsp");
        request.setAttribute("RefSupplierList", RefSupplierList);
        rd.forward(request, response); 
    }
}
