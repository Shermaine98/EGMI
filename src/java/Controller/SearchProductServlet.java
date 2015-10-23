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
        String productName1 = request.getParameter("productName1");

        ArrayList<BillOfMaterials> BillOfMaterialsListALL = new ArrayList<BillOfMaterials>();
        if (productName == null) {
            ServletContext context = getServletContext();
            try {
                BillOfMaterialsListALL = new BillOfMaterialsDAO().searchProduct(productName1);
            } catch (SQLException ex) {
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConsumptionReportDAO DAO = new ConsumptionReportDAO();
            Integer numberCR = 0;
            try {
                numberCR = DAO.getProductionNumber();

            } catch (SQLException ex) {
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("CRPRNumber", numberCR);
            request.setAttribute("BillofMaterials", BillOfMaterialsListALL);
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/ProductCreation/ConsumptionReport.jsp");
            rd.forward(request, response);

        } else {
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
            //Create Production Number
            ConsumptionReportDAO DAO = new ConsumptionReportDAO();
            Integer numberCR = 0;
            try {
                numberCR = DAO.getProductionNumber();

            } catch (SQLException ex) {
                Logger.getLogger(SearchProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Gson gson = new Gson();
            request.setAttribute("CRPRNumber", numberCR);
            request.setAttribute("BillofMaterials", BillOfMaterialsListALL);
            String json = gson.toJson(productNameN);
            response.getWriter().write("{\"suggestions\":" + json + "}");
        }

    }
}
