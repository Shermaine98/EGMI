package Controller;

import DAO.PurchaseOrderDAO;
import DAO.SubconPurchaseOrderDAO;
import DAO.SupplierDeliveryReceiptDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.PurchaseOrder;
import Model.SubconPurchaseOrder;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
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
 * @author gcla109
 */
public class GetPurchaseOrderSpecificServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierPurchaseOrderDAO SupplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();
        SupplierDeliveryReceiptDAO SupplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
        SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();
        ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrderList = new ArrayList<>();
        ArrayList<SubconPurchaseOrder> subconPurchaseOrderList = new ArrayList<>();

        String poNumber = request.getParameter("hiddenValue");
        System.out.println("this" + poNumber);
        
        ArrayList<PurchaseOrder> PurchaseOrderList = new  ArrayList<> ();
        PurchaseOrderDAO PurchaseOrderDAO= new PurchaseOrderDAO();
        
        try {
            PurchaseOrderList = PurchaseOrderDAO.GetAllPurchaseOrder();
        } catch (ParseException ex) {
            Logger.getLogger(PurchaseOrderSerlvet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //supplier
        if (poNumber.startsWith("7")) {
           Integer x =0;
            try {
                x = SupplierDeliveryReceiptDAO.getSupplierDeliveryReceipt();
                SupplierPurchaseOrderList = SupplierPurchaseOrderDAO.GetSupplierPurchaseOrder(poNumber);
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/Receiving.jsp");
            request.setAttribute("drNumber", x);
            request.setAttribute("PurchaseOrderList", PurchaseOrderList);
            request.setAttribute("data", "supplier");
            request.setAttribute("SupplierPurchaseOrderReceiving", SupplierPurchaseOrderList);
            rd.forward(request, response);
            
        } //subcon   
        else if (poNumber.startsWith("5")) {
            try {
                subconPurchaseOrderList = SubconPurchaseOrderDAO.getSubconPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Procurement/Receiving.jsp");
           request.setAttribute("PurchaseOrderList", PurchaseOrderList);
           request.setAttribute("subconPurchaseOrderReceiving", subconPurchaseOrderList);
           request.setAttribute("data", "subcon");
            rd.forward(request, response);

        }

    }
}
