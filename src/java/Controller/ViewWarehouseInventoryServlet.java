/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.WarehouseInventoryDAO;
import Model.WarehouseInventory;
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
public class ViewWarehouseInventoryServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WarehouseInventoryDAO WarehouseInventoryDAO = new WarehouseInventoryDAO();
        ArrayList<WarehouseInventory> WarehouseInventoryList = new  ArrayList<> ();
        try {
            WarehouseInventoryList = WarehouseInventoryDAO.GetWarehouseInventory();
        } catch (ParseException ex) {
            Logger.getLogger(ViewWarehouseInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/jsp/Inventory/WarehouseInventory.jsp");
        request.setAttribute("WarehouseInventoryList", WarehouseInventoryList);
        rd.forward(request, response); 
    }


}
