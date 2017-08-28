package Com.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Com.Util.DBConnection;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public log() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			StringBuilder sb = new StringBuilder();
			BufferedReader br = request.getReader();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			JSONObject jObj = new JSONObject(sb.toString());

			String UserName = jObj.getString("LillyId");
			String Password = jObj.getString("Password");

			Connection con = DBConnection.createConnection();
			Statement statement = null;
			ResultSet resultSet = null;
			PreparedStatement ps = null;
			statement = con.createStatement();

			PrintWriter out = response.getWriter();
			Map Status = new HashMap();

			JSONArray arr = new JSONArray();
			JSONObject obj1 = new JSONObject();
			JSONObject obj2 = new JSONObject();
			JSONObject obj4 = new JSONObject();
			JSONObject obj5 = new JSONObject();
			JSONObject obj6 = new JSONObject();

			ArrayList<String> UName = new ArrayList<String>();
			ArrayList<String> LillyId = new ArrayList<String>();

			// String uid = "136";
			String len="";
			ps = con.prepareStatement("select * from user_info where L_id=? and Password=?");
			ps.setString(1, UserName);
			ps.setString(2, Password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				len=rs.getString("U_name");
				UName.add(rs.getString("U_name"));
				LillyId.add(rs.getString("L_id"));
				
			}
			
			if(len.isEmpty()) {
				obj1.put("Message", "Invalid");
			}
			else {
			obj1.put("UserName", UName);
			obj1.put("LillyId", LillyId);
			obj1.put("Message", "Valid");
			}
			arr.put(obj1);
			obj2.put("items", obj1);
			response.getWriter().write(obj2.toString());
			response.setContentType("application/json");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
