package Controller;

import DAO.BillOfMaterialsDAO;
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
public class SetProductServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     
        String productName1 = request.getParameter("productName1");

        ArrayList<BillOfMaterials> BillOfMaterialsListALL = new ArrayList<BillOfMaterials>();
 
            ServletContext context = getServletContext();
            try {
                BillOfMaterialsListALL = new BillOfMaterialsDAO().searchProduct(productName1);
            } catch (SQLException ex) {
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
  request.setAttribute("data", "success");
            request.setAttribute("BillOfMaterialsConsumption", BillOfMaterialsListALL);
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/ProductCreation/ConsumptionReport.jsp");
            rd.forward(request, response);

       

    }
}
