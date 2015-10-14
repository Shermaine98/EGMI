package Controller;

import DAO.ConsumptionReportDAO;
import DAO.DeliveryReceiptDAO;
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
public class SetDRNumberServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeliveryReceiptDAO DAO = new DeliveryReceiptDAO();
        Integer deliveryReceiptNumber=0;
        try {
            deliveryReceiptNumber = DAO.getDeliveryReceiptNumber();
        } catch (SQLException ex) {
            Logger.getLogger(SetDRNumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Delivery/DeliveryReceipt.jsp");
        request.setAttribute("drNumber", deliveryReceiptNumber);
        rd.forward(request, response);

    }
}
