package Controller;

import DAO.PurchaseOrderDAO;
import DAO.SubconPurchaseOrderDAO;
import DAO.SupplierDeliveryReceiptDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.PurchaseOrder;
import Model.SubconPurchaseOrder;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
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
public class GetPurchaseOrderReconcileServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierPurchaseOrderDAO SupplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();
        SupplierDeliveryReceiptDAO SupplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
        SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();
        
        ArrayList<PurchaseOrder> PurchaseOrderList = new  ArrayList<> ();
        PurchaseOrderDAO PurchaseOrderDAO= new PurchaseOrderDAO();
        
        ArrayList<SupplierPurchaseOrder> supplierInventorylist = new ArrayList<>();
        ArrayList<SubconPurchaseOrder> subconInventorylist = new ArrayList<>();
        
        String inventoryType = request.getParameter("inventoryType");
        String poNumber = request.getParameter("hiddenValue");
        System.out.println("this" + poNumber);
        
        //accessories
        if (inventoryType.equalsIgnoreCase("accessories")) {
            try {
                PurchaseOrderList = PurchaseOrderDAO.GetAccessoriesPurchaseOrder();
                supplierInventorylist = SupplierPurchaseOrderDAO.GetSupplierPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/ReconcileAccessoriesInventory.jsp");
            request.setAttribute("accessoriesPurchaseOrder", PurchaseOrderList);
         
            request.setAttribute("accessoriesPurchaseOrderList", supplierInventorylist);
            rd.forward(request, response);
            
        } //production   
        else if (inventoryType.equalsIgnoreCase("production")) {
            try {
               PurchaseOrderList = PurchaseOrderDAO.GetProductionPurchaseOrder();
              //  cutting = SubconPurchaseOrderDAO.getSubconPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/ReconcileProductionInventory.jsp");
           request.setAttribute("productionPurchaseOrder", PurchaseOrderList);
          // request.setAttribute("subconPurchaseOrderReconcile", subconPurchaseOrderList);
      
            rd.forward(request, response);

        }
//     //warehouse      
        else if (inventoryType.equalsIgnoreCase("warehouse")) {
            try {
                PurchaseOrderList = PurchaseOrderDAO.GetWarehousePurchaseOrder();
                subconInventorylist = SubconPurchaseOrderDAO.getSubconPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/ReconcileWarehouseInventory.jsp");
           request.setAttribute("warehousePurchaseOrder", PurchaseOrderList);
           request.setAttribute("warehousePurchaseOrderList", subconInventorylist);
        
            rd.forward(request, response);

        }

    }
}
