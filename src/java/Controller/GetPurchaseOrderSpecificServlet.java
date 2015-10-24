package Controller;

import DAO.SubconPurchaseOrderDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class GetPurchaseOrderSpecificServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
      response.setContentType("text/html;charset=UTF-8");
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doPost(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          SupplierPurchaseOrderDAO SupplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();
         SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();
         ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrderList = new  ArrayList<SupplierPurchaseOrder> ();
         ArrayList<SubconPurchaseOrder> subconPurchaseOrderList = new  ArrayList<SubconPurchaseOrder> ();
        
         
         System.out.println("PUMASOK");
         String poNumber = request.getParameter("purchaseOrderNum");
         System.out.println("this" + poNumber);
       
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
            response.setCharacterEncoding("UTF-8"); 
            response.getWriter().print("supplier");
            response.getWriter().print(SupplierPurchaseOrderList);
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
            response.setCharacterEncoding("UTF-8"); 
            response.getWriter().print("subcon");
            response.getWriter().print(subconPurchaseOrderList);
          
        }
           
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
