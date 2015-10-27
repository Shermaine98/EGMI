/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Reports;

import Controller.BaseServlet;
import Database.DBConnectionFactory;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


/**
 *
 * @author Geraldine
 */
public class PrintConsumption extends BaseServlet {
  
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
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
            
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            
          //watever this is
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

          //get absolute path  
            String relativeWebPath = "/Reports";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            File f = new File(absoluteDiskPath, "ConsumptionReport.jrxml");
          
            JasperReport jr = JasperCompileManager.compileReport(f.getAbsolutePath()); 
  
            Map map = new HashMap();
            map.put("prodNum", productionNumber);
            //Fill the report with parameter, connection and the stream reader   
  
           // printing
           JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
             
        
          httpServletResponse.addHeader("Content-disposition", "attachment; filename=ConsumptionReport.pdf");
          ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
          JasperExportManager.exportReportToPdfStream(jp,servletOutputStream);
          FacesContext.getCurrentInstance().responseComplete();
            
          //  JasperExportManager.exportReportToPdfFile(jp, "ConsumptionReport.pdf");
            //            JasperViewer.viewReport(jp, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}