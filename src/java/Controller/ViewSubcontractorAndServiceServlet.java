package Controller;

import DAO.RefSubconDAO;
import Model.RefSubcon;
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
public class ViewSubcontractorAndServiceServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefSubconDAO RefSubconDAO = new RefSubconDAO();
        ArrayList<RefSubcon> RefSubconList = new  ArrayList<RefSubcon> ();
       
        RefSubconList = RefSubconDAO.MonitorRefSubcon();
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/SubcontractorsAndService.jsp");
        request.setAttribute("RefSubconList", RefSubconList);
        rd.forward(request, response); 
    }
}
