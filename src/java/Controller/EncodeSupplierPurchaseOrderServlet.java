package Controller;

import DAO.SupplierPurchaseOrderDAO;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
public class EncodeSupplierPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SupplierPurchaseOrder supplierPurchaseOrder = new SupplierPurchaseOrder();
            ArrayList<SupplierPurchaseOrder> arrSupplierPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();
            SupplierPurchaseOrderDAO supplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();

            String poNumber = request.getParameter("poNumber");
            String[] itemCode = request.getParameterValues("itemCode");
            String supplier = request.getParameter("supplierId");
            String[] volumeQty = request.getParameterValues("volumeQty");
            String deliveryDate = request.getParameter("deliveryDate");
            String preparedBy =  request.getParameter("preparedBy");
            String[] receivingStatus = request.getParameterValues("receivingStatus");
            String[] reconcileStatus = request.getParameterValues("reconcileStatus");
            String[] note = request.getParameterValues("note");
            
        
            boolean x = false;
            for (int i = 0; i < itemCode.length; i++) {
                
                supplierPurchaseOrder.setPoNumber(Integer.parseInt(poNumber));
                supplierPurchaseOrder.setItemCode(Integer.parseInt(itemCode[i]));
                supplierPurchaseOrder.setSupplier(Integer.parseInt(supplier));
                supplierPurchaseOrder.setVolumeQty(Double.parseDouble(volumeQty[i]));
                supplierPurchaseOrder.setDateMade();
                supplierPurchaseOrder.setDeliveryDate(deliveryDate);
                supplierPurchaseOrder.setPreparedBy(Integer.parseInt(preparedBy));
                supplierPurchaseOrder.setReceivingStatus(receivingStatus[i]);
                supplierPurchaseOrder.setReconcileStatus(reconcileStatus[i]);
                supplierPurchaseOrder.setNote(note[i]);
                
                

                if (supplierPurchaseOrderDAO.EncodeSupplierPurchaseOrder(supplierPurchaseOrder)) {
                    x = true;
                    arrSupplierPurchaseOrder.add(supplierPurchaseOrder);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/ViewSupplierPurhcaseOrder.jsp");
             
                request.setAttribute("arrSupplierPurchaseOrder", arrSupplierPurchaseOrder);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/SupplierPurchaseOrder.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
