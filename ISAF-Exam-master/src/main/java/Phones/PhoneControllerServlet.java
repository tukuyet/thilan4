package Phones;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/PhoneServlet")
public class PhoneControllerServlet extends HttpServlet {
    private static final long serialVersionUID =  1L;
    private PhoneDbUtil phoneDbUtil;
    @Resource(name="jdbc/phone")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            phoneDbUtil = new PhoneDbUtil(dataSource);
        }catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null){
                theCommand = "list";
            }
            switch (theCommand){
                case "ADD":
                    addPhone(request, response);
                    break;
                default:
                    listPhone(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void listPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Phone> phones = phoneDbUtil.getPhoneList();
        request.setAttribute("PHONE_LIST", phones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listphones.jsp");
        dispatcher.forward(request, response);
    }

    public void addPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phoneName = request.getParameter("phoneName");
        String brand =  request.getParameter("brand");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Phone thePhone = new Phone(phoneName, brand, price, description);
        phoneDbUtil.addPhone(thePhone);
        response.sendRedirect(request.getContextPath() + "/PhoneServlet");
    }

}
