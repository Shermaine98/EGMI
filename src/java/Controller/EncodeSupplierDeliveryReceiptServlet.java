package Controller;


import DAO.SupplierDeliveryReceiptDAO;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class EncodeSupplierDeliveryReceiptServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SupplierDeliveryReceipt supplierDeliveryReceipt = new SupplierDeliveryReceipt();
            ArrayList<SupplierDeliveryReceipt> arrSupplierDeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();
            SupplierDeliveryReceiptDAO supplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();

            String[] drNumber = request.getParameterValues("drNumber");
            String[] poNumber = request.getParameterValues("poNumber");
            String[] itemCode = request.getParameterValues("itemCode");
            String[] dateReceived = request.getParameterValues("dateReceived");
            String[] qty = request.getParameterValues("qty");
            String[] receivedBy = request.getParameterValues("receivedBy");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] status = request.getParameterValues("status");
            
            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < drNumber.length; i++) {
                
                supplierDeliveryReceipt.setDrNumber(Integer.parseInt(drNumber[i]));
                supplierDeliveryReceipt.setPoNumber(Integer.parseInt(poNumber[i]));
                supplierDeliveryReceipt.setItemCode(Integer.parseInt(itemCode[i]));
                supplierDeliveryReceipt.setDateReceived(format.parse(dateReceived[i]));
                supplierDeliveryReceipt.setQty(Integer.parseInt(qty[i]));
                supplierDeliveryReceipt.setReceivedBy(Integer.parseInt(receivedBy[i]));
                supplierDeliveryReceipt.setApprovedBy(Integer.parseInt(approvedBy[i]));
                supplierDeliveryReceipt.setStatus(status[i]);
                
                
                if (supplierDeliveryReceiptDAO.EncodeSupplierDeliveryReceipt(supplierDeliveryReceipt)) {
                    x = true;
                    arrSupplierDeliveryReceipt.add(supplierDeliveryReceipt);
                } else {
                    x = false;
                }
            }

            if (x == true) {
               
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SupplierDeliveryReceipt.jsp");
                
                request.setAttribute("arrSupplierDeliveryReceipt", arrSupplierDeliveryReceipt);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SupplierDeliveryReceipt.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

}
