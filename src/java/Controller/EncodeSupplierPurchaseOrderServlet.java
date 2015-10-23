package Controller;

import DAO.SupplierPurchaseOrderDAO;
import Model.SupplierPurchaseOrder;
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
public class EncodeSupplierPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SupplierPurchaseOrder supplierPurchaseOrder = new SupplierPurchaseOrder();
            ArrayList<SupplierPurchaseOrder> arrSupplierPurchaseOrder = new ArrayList<SupplierPurchaseOrder>();
            SupplierPurchaseOrderDAO supplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();

            String[] poNumber = request.getParameterValues("poNumber");
            String[] itemCode = request.getParameterValues("itemCode");
            String[] inventoryType = request.getParameterValues("inventoryType");
            String[] supplier = request.getParameterValues("supplier");
            String[] volumeQty = request.getParameterValues("volumeQty");
            String[] unitPrice = request.getParameterValues("unitPrice");
            String[] deliveryDate = request.getParameterValues("deliveryDate");
            String[] preparedBy =  request.getParameterValues("preparedBy");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] receivingStatus = request.getParameterValues("receivingStatus");
            String[] reconcileStatus = request.getParameterValues("reconcileStatus");
            String[] note = request.getParameterValues("note");
            
            
            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < poNumber.length; i++) {
                
                supplierPurchaseOrder.setPoNumber(Integer.parseInt(poNumber[i]));
                supplierPurchaseOrder.setItemCode(Integer.parseInt(itemCode[i]));
                supplierPurchaseOrder.setInventoryType(inventoryType[i]);
                supplierPurchaseOrder.setSupplier(Integer.parseInt(supplier[i]));
                supplierPurchaseOrder.setVolumeQty(Double.parseDouble(volumeQty[i]));
                supplierPurchaseOrder.setUnitPrice(Double.parseDouble(unitPrice[i]));
                supplierPurchaseOrder.setDateMade();
                supplierPurchaseOrder.setDeliveryDate(format.parse(deliveryDate[i]));
                supplierPurchaseOrder.setPreparedBy(Integer.parseInt(preparedBy[i]));
                supplierPurchaseOrder.setApprovedBy(Integer.parseInt(approvedBy[i]));
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
                RequestDispatcher rd = context.getRequestDispatcher("/ViewSupplierPurchase.jsp");
             
                request.setAttribute("arrSupplierPurchaseOrder", arrSupplierPurchaseOrder);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SupplierPurchaseOrder.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
