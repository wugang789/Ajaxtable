package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import util.DbUtil;

/**
 * Servlet implementation class findProvinces
 */
public class findProvinces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public findProvinces() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		String SQL = "select provinceName from province";
		System.out.println(SQL);
		Connection conn = null;
		PreparedStatement prs;
		JSONArray json;
		try {
			conn = DbUtil.getconn();
			prs = conn.prepareStatement(SQL);
			System.out.println(SQL);
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("provinceName"));
			}
			json = new JSONArray().fromObject(list);
			System.out.println(json.toString());
			System.out.println(list);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
