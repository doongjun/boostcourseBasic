package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class Sum10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sum10() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int total = 0;
		for(int i=1; i<=10; i++) {
			total += i;
		}
		
		out.println("<html>");
		out.println("<head><title>sum10</title></head>");
		out.println("<body>");
		out.println("1부터 10까지 합 : ");
		out.println(total);
		out.println("</body>");
		out.println("</html>");
	}

}
