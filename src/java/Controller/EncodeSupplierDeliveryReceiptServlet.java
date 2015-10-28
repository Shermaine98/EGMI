package Controller;

import DAO.SupplierDeliveryReceiptDAO;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.sql.SQLException;
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
        SupplierDeliveryReceipt supplierDeliveryReceipt = new SupplierDeliveryReceipt();
        ArrayList<SupplierDeliveryReceipt> arrSupplierDeliveryReceipt = new ArrayList<SupplierDeliveryReceipt>();
        SupplierDeliveryReceiptDAO supplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String drNumber = request.getParameter("drNumber");
        String poNumber = request.getParameter("poNumber");
        String receivedBy = request.getParameter("receivedBy");

        String[] orderedqty = request.getParameterValues("qty");
        String[] status = request.getParameterValues("status");
        String[] itemCode = request.getParameterValues("itemCode");
        String[] rejectQty = request.getParameterValues("rejectQty");
        String[] receivedQty = request.getParameterValues("receivedQty");
        String[] notes = request.getParameterValues("notes");

        boolean x = false;
        boolean drExist = false;
        try {
            drExist = supplierDeliveryReceiptDAO.check(poNumber);
        } catch (SQLException ex) {
            Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (drExist) {
            ArrayList<SupplierDeliveryReceipt> check = new ArrayList<SupplierDeliveryReceipt>();
            try {
                check = supplierDeliveryReceiptDAO.GetDeliveryReceipt(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int y = 0; y < itemCode.length; y++) {
                if (Integer.parseInt(itemCode[y]) == (check.get(y).getItemCode())) {
                    double totalReceived = check.get(y).getReceivedQty() + Double.parseDouble(receivedQty[y]);
                    double currentQty = Double.parseDouble(orderedqty[y]) - totalReceived;
                    if (currentQty == 0) {
                        status[y] = "complete";
                        receivedQty[y] = String.valueOf(totalReceived);
                        //completed
                    } else if (currentQty == Double.parseDouble(orderedqty[y])) {
                        //pending
                        status[y] = "pending";
                        receivedQty[y] = String.valueOf(totalReceived);
                    } else {
                        //partial
                        status[y] = "partial";
                        receivedQty[y] = String.valueOf(totalReceived);
                    }

                }

                for (int i = 0; i < itemCode.length; i++) {

                    supplierDeliveryReceipt.setDrNumber(check.get(y).getDrNumber());
                    supplierDeliveryReceipt.setPoNumber(Integer.parseInt(poNumber));
                    supplierDeliveryReceipt.setItemCode(Integer.parseInt(itemCode[i]));
                    supplierDeliveryReceipt.setReceivedBy(Integer.parseInt(receivedBy));
                    supplierDeliveryReceipt.setStatus(status[i]);
                    supplierDeliveryReceipt.setNotes(notes[i]);
                    supplierDeliveryReceipt.setReceivedQty(Double.parseDouble(receivedQty[i]));
                    supplierDeliveryReceipt.setRejectedQty(Double.parseDouble(rejectQty[i]));
                    try {
                        supplierDeliveryReceipt.setDateReceived();
                    } catch (ParseException ex) {
                        Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (supplierDeliveryReceiptDAO.UpdateSupplierDeliveryReceipt(supplierDeliveryReceipt)) {
                        x = true;
                        arrSupplierDeliveryReceipt.add(supplierDeliveryReceipt);
                    } else {
                        x = false;
                    }
                }
            }
        } else {

            //change status           
            for (int y = 0; y < itemCode.length; y++) {
                double currentQty = Double.parseDouble(orderedqty[y]) - Double.parseDouble(receivedQty[y]);
                if (currentQty == 0) {
                    status[y] = "complete";

                    //completed
                } else if (currentQty == Double.parseDouble(orderedqty[y])) {
                    //pending
                    status[y] = "pending";
                } else {
                    //partial
                    status[y] = "partial";
                }
            }

            for (int i = 0; i < itemCode.length; i++) {
                supplierDeliveryReceipt.setDrNumber(Integer.parseInt(drNumber));
                supplierDeliveryReceipt.setPoNumber(Integer.parseInt(poNumber));
                supplierDeliveryReceipt.setItemCode(Integer.parseInt(itemCode[i]));
                supplierDeliveryReceipt.setReceivedBy(Integer.parseInt(receivedBy));
                supplierDeliveryReceipt.setStatus(status[i]);
                supplierDeliveryReceipt.setNotes(notes[i]);
                try {
                    supplierDeliveryReceipt.setDateReceived();
                } catch (ParseException ex) {
                    Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                supplierDeliveryReceipt.setReceivedQty(Double.parseDouble(receivedQty[i]));
                supplierDeliveryReceipt.setRejectedQty(Double.parseDouble(rejectQty[i]));

                if (supplierDeliveryReceiptDAO.EncodeSupplierDeliveryReceipt(supplierDeliveryReceipt)) {
                    x = true;
                    arrSupplierDeliveryReceipt.add(supplierDeliveryReceipt);
                } else {
                    x = false;
                }
            }

        }

        if (x == true) {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/PurchaseOrderSerlvet");
            request.setAttribute("arrSupplierDeliveryReceipt", arrSupplierDeliveryReceipt);
            rd.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/Accounts/Homepage.jsp");
            rd.forward(request, response);

        }

    }
}
