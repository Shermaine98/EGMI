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
public class ViewConsumptionReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsumptionReportDAO DAO = new ConsumptionReportDAO();
        ArrayList<ConsumptionReport> crList = new ArrayList();

        try {
            crList = DAO.GetConsumptionReportListGroupBy();
        } catch (ParseException ex) {
            Logger.getLogger(ViewConsumptionReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/ProductCreation/ViewConsumptionReport.jsp");
        request.setAttribute("data", "ViewConsumptionReport");
        request.setAttribute("crList", crList);
        rd.forward(request, response);
             
       
    }
}
