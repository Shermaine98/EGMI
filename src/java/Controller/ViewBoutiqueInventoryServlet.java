/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BoutiqueInventoryDAO;
import Model.BoutiqueInventory;
import java.io.IOException;
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
 * @author shermainesy
 */
public class ViewBoutiqueInventoryServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoutiqueInventoryDAO BoutiqueInventoryDAO = new BoutiqueInventoryDAO();
        ArrayList<BoutiqueInventory> BoutiqueInventoryList = new  ArrayList<> ();
        try {
            BoutiqueInventoryList = BoutiqueInventoryDAO.GetBoutiqueInventory();
        } catch (ParseException ex) {
            Logger.getLogger(ViewWarehouseInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/BoutiqueInventory.jsp");
        request.setAttribute("BoutiqueInventoryList", BoutiqueInventoryList);
        rd.forward(request, response); 
    }


}
