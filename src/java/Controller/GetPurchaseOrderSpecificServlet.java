package Controller;

import DAO.SubconPurchaseOrderDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import static java.lang.System.out;
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
         SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();
        ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrderList = new  ArrayList<> ();
        ArrayList<SubconPurchaseOrder> subconPurchaseOrderList = new  ArrayList<> ();
       
        String poNumber = request.getParameter("productionNumber1");
         System.out.println("this"+poNumber);
        //supplier
        if(poNumber.startsWith("7")){
            System.out.println("HELOO");
            try {
                SupplierPurchaseOrderList = SupplierPurchaseOrderDAO.GetSupplierPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            request.setAttribute("data", "supplier");
            request.setAttribute("SupplierPurchaseOrderReceiving", SupplierPurchaseOrderList);
   
        }
      
         //subcon   
        else if(poNumber.startsWith("5")){
            try {
                subconPurchaseOrderList = SubconPurchaseOrderDAO.getSubconPurchaseOrder(poNumber);
            } catch (ParseException ex) {
                Logger.getLogger(GetPurchaseOrderSpecificServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
          
             request.setAttribute("data", "subcon");
            request.setAttribute("subconPurchaseOrderReceiving", subconPurchaseOrderList);
          
        }
           
    }
}
