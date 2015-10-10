package Controller;

import DAO.BillOfMaterialsDAO;
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
public class SetPIDServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BillOfMaterialsDAO DAO = new BillOfMaterialsDAO();
        Integer productnumber=0;
        try {
            productnumber = DAO.getProductNumber();
        } catch (SQLException ex) {
            Logger.getLogger(SetPIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/ProductCreation/BillOFMaterials.jsp");
        request.setAttribute("BoMPrNumber", productnumber);
        rd.forward(request, response);

    }
}
