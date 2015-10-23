package Controller;

import DAO.ConsumptionReportDAO;
import Model.ConsumptionReport;
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
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class EncodeConsumptionReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        boolean x = false;
        ConsumptionReport consumptionReport = new ConsumptionReport();
        ArrayList<ConsumptionReport> ConsumptionReportArray = new ArrayList<>();
        ConsumptionReportDAO consumptionReportDAO = new ConsumptionReportDAO();
        ArrayList<ConsumptionReport> ConsumptionReportView = new ArrayList<>();
        ArrayList<Integer> itemCode1 = new ArrayList<>();
        String ProductionNumber = request.getParameter("productionNumber");
        String preparedBy = request.getParameter("preparedBy");
        String sizeName = request.getParameter("sizeName");
        String productID = request.getParameter("productID");
        String[] volumeQuantity = request.getParameterValues("volumeQty");
        String[] itemCode = request.getParameterValues("itemCode");
        String[] sizeType = request.getParameterValues("sizeType");

        for (int i = 0; i < itemCode.length; i++) {
            for (int y = 0; y < sizeType.length; y++) {

                consumptionReport.setProductionNumber(Integer.parseInt(ProductionNumber));
                consumptionReport.setPreparedBy(Integer.parseInt(preparedBy));
                consumptionReport.setProductID(Integer.parseInt(productID));
                consumptionReport.setItemCode(Integer.parseInt(itemCode[i]));
                try {
                    consumptionReport.setDateMade();
                } catch (ParseException ex) {
                    Logger.getLogger(EncodeConsumptionReportServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                consumptionReport.setSizeName(sizeName);
                consumptionReport.setSizeType(sizeType[y]);
                consumptionReport.setVolumeQty(Integer.parseInt(volumeQuantity[y]));

                if (consumptionReportDAO.EncodeConsumptionReport(consumptionReport)) {
                    x = true;
                    ConsumptionReportArray.add(consumptionReport);

                } else {
                    x = false;
                }
            }
        }
        if (x) {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/ProductCreation/ViewConsumptionReport.jsp");
            try {
                ConsumptionReportView = consumptionReportDAO.GetConsumptionReportList(Integer.parseInt(ProductionNumber));
            } catch (ParseException ex) {
                Logger.getLogger(EncodeConsumptionReportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < ConsumptionReportView.size(); i++) {
                if (!itemCode1.contains(ConsumptionReportView.get(i).getItemCode())) {
                    itemCode1.add(ConsumptionReportView.get(i).getItemCode());
                }
            }
            
            request.setAttribute("data", "ConsumptionReportView");
            request.setAttribute("itemCode", itemCode1 );
            request.setAttribute("consumptionReportView", ConsumptionReportView);
            request.setAttribute("consumptionReport", ConsumptionReportArray);
            rd.forward(request, response);
        } else {
            ServletContext context = getServletContext();
           
            RequestDispatcher rd = context.getRequestDispatcher("/SearchProductServlet");
            rd.forward(request, response);
        }

    }

}
