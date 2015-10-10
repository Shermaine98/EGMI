package Controller;

import DAO.BillOfMaterialsDAO;
import DAO.ConsumptionReportDAO;
import Model.BillOfMaterials;
import com.google.gson.Gson;
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
public class SearchProductServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("query");
       
        ArrayList<BillOfMaterials> BillOfMaterialsListALL = new ArrayList<BillOfMaterials>();
        
            try {
                BillOfMaterialsListALL = new BillOfMaterialsDAO().searchProduct(productName);

            } catch (SQLException ex) {
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<String> productNameN = new ArrayList<String>();
            for (int i = 0; i < BillOfMaterialsListALL.size(); i++) {
                if (!productNameN.contains(BillOfMaterialsListALL.get(i).getProductName())) {
                    productNameN.add(BillOfMaterialsListALL.get(i).getProductName());
                }
            }
            Gson gson = new Gson();
            request.setAttribute("BillofMaterials", BillOfMaterialsListALL);
            String json = gson.toJson(productNameN);
            response.getWriter().write("{\"suggestions\":" + json + "}");
        }

    
}
