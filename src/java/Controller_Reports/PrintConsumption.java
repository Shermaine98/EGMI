/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Reports;

import Controller.BaseServlet;
import Database.DBConnectionFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

        try {
            String productionNumber = request.getParameter("printPONumber");
            showReport(Integer.parseInt(productionNumber), response);

            String pdfFileName = "C:\\Users\\Geraldine\\Desktop\\EGMI\\web\\Reports\\ProcurementReports\\ConsumptionReport.pdf";
            File pdfFile = new File(pdfFileName);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=ConsumptionReport.pdf");
            response.setContentLength((int) pdfFile.length());

            FileInputStream fileInputStream = new FileInputStream(pdfFile);
            OutputStream responseOutputStream = response.getOutputStream();
            int bytes;
            while ((bytes = fileInputStream.read()) != -1) {
                responseOutputStream.write(bytes);
            }
            
//            ServletContext context = getServletContext();
//            RequestDispatcher rd = context.getRequestDispatcher("/Reports/ProcurementReports/ConsumptionReport.jsp");
//            rd.forward(request, response);
        } catch (JRException ex) {
            Logger.getLogger(PrintConsumption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showReport(int productionNumber, HttpServletResponse response) throws JRException {
        try {

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            response.setContentType("application/pdf");

            //get absolute path  
            String relativeWebPath = "/Reports";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            File f = new File(absoluteDiskPath, "ConsumptionReport.jrxml");

            JasperReport jr = JasperCompileManager.compileReport(f.getAbsolutePath());

            //Fill the report with parameter, connection and the stream reader   
            Map map = new HashMap();
            map.put("prodNum", productionNumber);

            // printing
            JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
            JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Geraldine\\Desktop\\EGMI\\web\\Reports\\ProcurementReports\\ConsumptionReport.pdf");
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
