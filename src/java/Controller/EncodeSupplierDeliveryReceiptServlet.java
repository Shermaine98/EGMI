package Controller;


import DAO.SupplierDeliveryReceiptDAO;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class EncodeSupplierDeliveryReceiptServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SupplierDeliveryReceipt supplierDeliveryReceipt = new SupplierDeliveryReceipt();
            ArrayList<SupplierDeliveryReceipt> arrSupplierDeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();
            SupplierDeliveryReceiptDAO supplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           
            String drNumber = request.getParameter("drNumber");
            String poNumber = request.getParameter("poNumber");
            String receivedBy = request.getParameter("receivedBy");
           
            String [] status = request.getParameterValues("status");
            String [] itemCode = request.getParameterValues("itemCode");
            String [] rejectQty = request.getParameterValues("rejectQty");
            String [] receivedQty = request.getParameterValues("receivedQty");
            String [] notes = request.getParameterValues("notes");
            
        //    Date[] dateReceived = format.parse(request.getParameterValues("dateReceived"));
            
            
             Date[] dateReceived = new Date [itemCode.length];
            
            for(int y=0; y <itemCode.length;y++){
                 if(!status[y].equalsIgnoreCase("completed")){
                     dateReceived[y] = format.parse("9999-99-99");
                 }
                 else{
                     supplierDeliveryReceipt.setDateReceived();
                    dateReceived[y] = supplierDeliveryReceipt.getDateReceived();
                 }
            }
            boolean x = false;

           
            
            for (int i = 0; i < itemCode.length; i++) {
                
                supplierDeliveryReceipt.setDrNumber(Integer.parseInt(drNumber));
                supplierDeliveryReceipt.setPoNumber(Integer.parseInt(poNumber));
                supplierDeliveryReceipt.setItemCode(Integer.parseInt(itemCode[i]));
                supplierDeliveryReceipt.setDateReceived(dateReceived[i]);
                
                supplierDeliveryReceipt.setReceivedBy(Integer.parseInt(receivedBy));
                supplierDeliveryReceipt.setStatus(status[i]);
                supplierDeliveryReceipt.setNotes(notes[i]);
                supplierDeliveryReceipt.setReceivedQty(Double.parseDouble(receivedQty[i]));
                supplierDeliveryReceipt.setRejectedQty(Double.parseDouble(rejectQty[i]));
                
                
                if (supplierDeliveryReceiptDAO.EncodeSupplierDeliveryReceipt(supplierDeliveryReceipt)) {
                    x = true;
                    arrSupplierDeliveryReceipt.add(supplierDeliveryReceipt);
                } else {
                    x = false;
                }
            }

            if (x == true) {
               
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/Receving.jsp");
                
                request.setAttribute("arrSupplierDeliveryReceipt", arrSupplierDeliveryReceipt);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Accounts/Homepage.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

}
