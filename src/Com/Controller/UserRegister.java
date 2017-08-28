package Com.Controller;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import Com.Util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			StringBuilder sb = new StringBuilder();
			BufferedReader br = request.getReader();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			JSONObject jObj = new JSONObject(sb.toString());

			String LillyId = jObj.getString("LillyId");
			String Password = jObj.getString("Password");
			String UserName = jObj.getString("Name");
			String Question = jObj.getString("Question");
			String Answer = jObj.getString("Answer");
			
			System.out.println("LIllyid "+LillyId+" pass "+Password+" uname "+UserName+" Que "+Question+" Ans "+Answer);

			PrintWriter out = response.getWriter();
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			System.out.println("Check");

			String uid = null;
			ps1 = con.prepareStatement("select * from user_info where L_id=?");
			ps1.setString(1, LillyId);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				response.getWriter().write("Already");
				System.out.println("Alrady");
			} else {
				ps = con.prepareStatement("insert into user_info(U_name,L_id,Password,Question,Answer) values(?,?,?,?,?)");
				ps.setString(1, UserName);
				ps.setString(2, LillyId);
				ps.setString(3, Password);
				ps.setString(4, Question);
				ps.setString(5, Answer);

				int i = ps.executeUpdate();

				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");

				if (i > 0) {

					response.getWriter().write("Successs");
			
				} else {
					response.getWriter().write("not been inserted");
					System.out.println("not success");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
