1. Create WebApp using IntellIj
https://medium.com/@yuntianhe/create-a-web-project-with-maven-spring-mvc-b859503f74d7

2. web deployment descriptor
https://www.mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/


3. welcome-file-list in web.xml - starting point for your application

4. RequestDispatcher
RequestDispatcher - Dispatches requests from one servlet to another
        //RequestDispatcher - Dispatches requests from one servlet to another
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/goodbye");

        //include method - includes response from all servlets
        //requestDispatcher.include(req, resp);

        //forward method - kills response from previous servlets
        requestDispatcher.forward(req,resp);

        //sendRedirect - hard redirect - Generates a brand new request
        resp.sendRedirect("http://www.google.com");

5. WAR - <packaging>war</packaging>

6. Servlet Context - Shared by all servlets
    <context-param>
        <param-name>email</param-name>
        <param-value>magic@gmail.com</param-value>
    </context-param>

7. Servlet Config - per servlet
    <servlet>
        <!--Instantiate after receiving the first request-->
        <servlet-name>goodbyeservlet</servlet-name>
        <servlet-class>com.nsv.jsmbaba.servlets.GoodByeServlet</servlet-class>
        <!--servlet config param-->
        <init-param>
            <param-name>specificemail</param-name>
            <param-value>specificemailvalue</param-value>
        </init-param>
    </servlet>


public class GoodByeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //ServletContext - Shared
        String servletContextInitParam = getServletContext().getInitParameter("email");
        //ServletConfig - Specific to servlet
        String specificemail = getServletConfig().getInitParameter("specificemail");
        PrintWriter writer = resp.getWriter();
        writer.println("GoodBye EasyPay App. servletContextInitParam="+servletContextInitParam+"\n"+"specificemail="+specificemail);
    }