/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Reports;

import Controller.BaseServlet;
import Controller.PurchaseOrderSerlvet;
import DAO.ConsumptionReportDAO;
import DAO.PurchaseOrderDAO;
import Database.DBConnectionFactory;
import Model.PurchaseOrder;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;


/**
 *
 * @author Geraldine
 */
public class PrintConsumption extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String relativeWebPath = "/Reports";
         String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
         
         request.setAttribute(absoluteDiskPath, absoluteDiskPath);
         
        ConsumptionReportDAO dao = new ConsumptionReportDAO();
         String productionNumber = request.getParameter("printPONumber");
        try {
            showReport(Integer.parseInt(productionNumber));
        } catch (JRException ex) {
            Logger.getLogger(PrintConsumption.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/ViewConsumptionReportServlet");
        rd.forward(request, response);
    }

 public void showReport(int productionNumber) throws JRException {           
        try {
           String relativeWebPath = "/Reports";
           String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
           File f = new File(absoluteDiskPath, "ConsumptionReport.jrxml");
            System.out.println(f);
            JasperReport jr = JasperCompileManager.compileReport(f.getAbsolutePath()); 
            
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            Map map = new HashMap();
            map.put("prodNum", productionNumber);

           // JasperReport jr = JasperCompileManager.compileReport(reportPath+"/ConsumptionReport.jrxml");
            //Fill the report with parameter, connection and the stream reader     
            JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);

            JasperExportManager.exportReportToPdfFile(jp, "/Users/shermainesy/NetBeansProjects/EGMI/web/Reports/ConsumptionReport.pdf");
            JasperViewer.viewReport(jp, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}