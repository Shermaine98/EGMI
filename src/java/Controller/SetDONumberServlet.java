package Controller;

import DAO.ConsumptionReportDAO;
import DAO.DeliveryOrderDAO;
import java.io.IOException;
import java.sql.SQLException;
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
public class SetDONumberServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeliveryOrderDAO DAO = new DeliveryOrderDAO();
        Integer deliveryOrderNumber=0;
        try {
            deliveryOrderNumber = DAO.getDeliveryOrderNumber();
        } catch (SQLException ex) {
            Logger.getLogger(SetDONumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Delivery/DeliveryOrder.jsp");
        request.setAttribute("data", "none");
        request.setAttribute("doNumber", deliveryOrderNumber);
        rd.forward(request, response);

    }
}
