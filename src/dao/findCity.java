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

@SuppressWarnings("serial")
public class findCity extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		String provincename = req.getParameter("provinceName");
		System.out.println(provincename + "??????????????????????//");
		String newname = new String(provincename.getBytes("ISO8859-1"), "GBK");
		System.out.println(">>>>>>>>>>>>>>" + newname);
		String SQL = "select cityName from city where province_id=(select id from province where provinceName=?)";
		Connection conn = null;
		PreparedStatement prs = null;
		JSONArray json;
		try {
			conn = DbUtil.getconn();
			prs = conn.prepareStatement(SQL);
			System.out.println(">>>>>>>>>>>>>>" + newname + SQL);
			prs.setString(1, newname);
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				System.out.println(">>>>");
				list.add(rs.getString("cityName"));
			}
			json = new JSONArray().fromObject(list);
			System.out.println(list);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
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
