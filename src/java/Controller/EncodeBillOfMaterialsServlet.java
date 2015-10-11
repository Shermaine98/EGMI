package Controller;

import DAO.BillOfMaterialsDAO;
import Model.BillOfMaterials;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author 
 *
 */
public class EncodeBillOfMaterialsServlet extends BaseServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BillOfMaterials billOfMaterials = new BillOfMaterials();
        ArrayList<BillOfMaterials> arrBillOfMaterials = new ArrayList<>();
        BillOfMaterialsDAO billOfMaterialsDAO = new BillOfMaterialsDAO();

        String productID = request.getParameter("productIDModal");
        String productName = request.getParameter("productNameModal");
        String sizeName = request.getParameter("sizeTypeModal");
        String[] itemCode = request.getParameterValues("itemCodeModal");
        String[] itemConsumption = request.getParameterValues("itemConsumptionModal");
        String[] unitMeasurement = request.getParameterValues("unitMeasurementModal");

        boolean x = false;
        for (int i = 0; i < itemCode.length; i++) {
            billOfMaterials.setProductID(Integer.parseInt(productID));
            billOfMaterials.setItemCode(Integer.parseInt(itemCode[i]));
            billOfMaterials.setProductName(productName);
            billOfMaterials.setItemConsumption(Double.parseDouble(itemConsumption[i]));
            billOfMaterials.setUnitMeasurement(unitMeasurement[i]);
            billOfMaterials.setSizeName(sizeName);

            if (billOfMaterialsDAO.EncodeBillOfMaterials(billOfMaterials)) {
                x = true;
                arrBillOfMaterials.add(billOfMaterials);
            } else {
                x = false;
            }
        }
      
        if (x == true) {
           
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("SetPDIDServlet");
            request.setAttribute("BillofMaterials", arrBillOfMaterials);
            rd.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/Accounts/Homepage.jsp");
            rd.forward(request, response);

        }

    }

}
