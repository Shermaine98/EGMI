package Controller;

import DAO.ConsumptionReportDAO;
import DAO.SubconPurchaseOrderDAO;
import Model.ConsumptionReport;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
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
public class SearchProductsServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productID = request.getParameter("query");
        String productID1 = request.getParameter("productName");
         SubconPurchaseOrderDAO DAO = new SubconPurchaseOrderDAO();
        ArrayList<ConsumptionReport> ConsumptionReportArray = new ArrayList<ConsumptionReport>();
        if (productID == null) {
            ServletContext context = getServletContext();
          
            try {
                ConsumptionReportArray = new ConsumptionReportDAO().searchConsumptionReport(productID1);
            } catch (ParseException ex) {
                Logger.getLogger(SearchProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
        Integer subconPurchaseNumber=0;
        try {
            subconPurchaseNumber = DAO.getSubconPurchaseOrderNumber();
            
        } catch (SQLException ex) {
            Logger.getLogger(SetSubPOServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Integer> itemCode1 = new ArrayList<>();
        for (int i = 0; i < ConsumptionReportArray.size(); i++) {
                if (!itemCode1.contains(ConsumptionReportArray.get(i).getItemCode())) {
                    itemCode1.add(ConsumptionReportArray.get(i).getItemCode());
                }
            }    
     
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/SubconPurchaseOrder.jsp");
       request.setAttribute("itemSize",itemCode1 );
        request.setAttribute("SubPONumber",subconPurchaseNumber );
        request.setAttribute("ConsumptionReportArray",ConsumptionReportArray );
         
            rd.forward(request, response);

        } else {
           
            try {
                ConsumptionReportArray = new ConsumptionReportDAO().searchConsumptionReport(productID);
            } catch (ParseException ex) {
                Logger.getLogger(SearchProductsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<String> productIDResult = new ArrayList<String>();
           
            for (int i = 0; i < ConsumptionReportArray.size(); i++) {
                if (!productIDResult.contains(String.valueOf(ConsumptionReportArray.get(i).getProductionNumber()))) {
                    productIDResult.add(String.valueOf(ConsumptionReportArray.get(i).getProductionNumber()));
                }
            }
            
//Create Production Number
              
        Integer subconPurchaseNumber=0;
        try {
            subconPurchaseNumber = DAO.getSubconPurchaseOrderNumber();
            
        } catch (SQLException ex) {
            Logger.getLogger(SetSubPOServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            Gson gson = new Gson();
            request.setAttribute("SubPONumber", subconPurchaseNumber);
            request.setAttribute("ConsumptionReportArray", ConsumptionReportArray);
            String json = gson.toJson(productIDResult);
            response.getWriter().write("{\"suggestions\":" + json + "}");
        }

          
    }
}
