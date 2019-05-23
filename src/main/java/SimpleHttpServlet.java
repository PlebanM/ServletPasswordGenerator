import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@WebServlet(urlPatterns = "/generator")
public class SimpleHttpServlet extends HttpServlet {

    private CreatePassword createPasswordClass;

    public SimpleHttpServlet() {
        this.createPasswordClass = new CreatePassword();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("resources/index.jsp");
    }

    protected void doPost( HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> parameterNames = request.getParameterNames();
        List<String> parametrNamesList = Collections.list(parameterNames);
        if (parametrNamesList.size()>1) {

            List<String> passwordSigns = createPasswordClass.createSignListToCreatePassword(parametrNamesList);
            Integer passwordLength = Integer.parseInt(request.getParameter("passwordLength"));

            String password = createPasswordClass.createPassword(passwordSigns, passwordLength);
            request.setAttribute("password", password);
        }else{
            String chooseOptionInfo = "CHOOSE ONE OPTION";
            request.setAttribute("passLength", request.getParameter("passwordLength"));
            request.setAttribute("WARNING", chooseOptionInfo);
        }

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/resources/index.jsp");
        requestDispatcher.forward(request, response);
    }
}