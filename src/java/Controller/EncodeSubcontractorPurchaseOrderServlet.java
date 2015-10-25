package Controller;

import DAO.SubconPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EncodeSubcontractorPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SubconPurchaseOrder SubconPurchaseOrder = new SubconPurchaseOrder();
            ArrayList<SubconPurchaseOrder> arrSubconPurchaseOrder = new ArrayList<SubconPurchaseOrder>();
            SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();

            String poNumber = request.getParameter("poNumber");
            String productionNumber = request.getParameter("productionNumber");
            String productID = request.getParameter("productID");
            String deliveryDate = request.getParameter("deliveryDate");
            String preparedBy = request.getParameter("preparedBy");
            String receivingStatus = request.getParameter("receivingStatus");
            String reconcileStatus = request.getParameter("reconcileStatus");
            String subcon = request.getParameter("subcon");
            String size = request.getParameter("sizeType");
            
            String[] checkboxCheck = request.getParameterValues("checkbox");
            String[] servicecheck = request.getParameterValues("service");

            ArrayList<String> service = new ArrayList<String>();

            for (int z = 0; z < servicecheck.length; z++) {
                if (checkboxCheck[z].equalsIgnoreCase("on")) {
                    service.add(servicecheck[z]);
                }

            }

            boolean x = false;

            for (int y = 0; y < service.size(); y++) {
                    SubconPurchaseOrder.setPoNumber(Integer.parseInt(poNumber));
                    SubconPurchaseOrder.setProductionNumber(Integer.parseInt(productionNumber));
                    SubconPurchaseOrder.setProductID(Integer.parseInt(productID));
                    SubconPurchaseOrder.setSize(size);
                    SubconPurchaseOrder.setService(service.get(y));
                    SubconPurchaseOrder.setDateMade();
                    SubconPurchaseOrder.setDeliveryDate(deliveryDate);
                    SubconPurchaseOrder.setPreparedBy(Integer.parseInt(preparedBy));
                    SubconPurchaseOrder.setReceivingStatus(receivingStatus);
                    SubconPurchaseOrder.setReconcileStatus(reconcileStatus);
                    SubconPurchaseOrder.setSubcon(Integer.parseInt(subcon));
                    if (SubconPurchaseOrderDAO.EncodeSubconPurchaseOrder(SubconPurchaseOrder)) {
                        x = true;
                        arrSubconPurchaseOrder.add(SubconPurchaseOrder);
                    } else {
                        x = false;
                    }
            }
            
            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/ViewSubconPurchaseOrder.jsp");

                request.setAttribute("arrSubconPurchaseOrder", arrSubconPurchaseOrder);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SearchProductsServlet");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
