package jp.co.aforce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Member;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Message;
import jp.co.aforce.tool.Page;


@WebServlet(urlPatterns = { "/jp.co.aforce.servlets/regist" })

public class Regist extends HttpServlet{

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException{

		PrintWriter out=response.getWriter();

		Page.header(out);

        String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");

		Member m = new Member();
		m.setLast_name(last_name);
		m.setFirst_name(first_name);
		m.setSex(sex);
		m.setBirth_year(birth_year);
		m.setBirth_month(birth_month);
		m.setBirth_day(birth_day);
		m.setJob(job);
		m.setPhone_number(phone_number);
		m.setMail_address(mail_address);

		MemberDAO dao = new MemberDAO();
		try {

			int counts = dao.search(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);
			if(counts >= 1) {
				request.setAttribute("message", Message.E_WKK0001);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);

		} else {
			try {
				dao.insert(m);
				request.setAttribute("message", Message.I_WKK0001);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
			}catch(Exception e) {
				request.setAttribute("message", Message.E_WKK0002);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
				e.printStackTrace();
			}

		}

		} catch (Exception e) {

			e.printStackTrace();
		}

        Page.footer(out);

	}

}














































