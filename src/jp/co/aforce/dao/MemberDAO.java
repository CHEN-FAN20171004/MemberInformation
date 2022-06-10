package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Member;
import jp.co.aforce.tool.DateTime;

public class MemberDAO extends DAO{

	public List<Member> search(String keyword)
			throws Exception {
		List<Member> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from Member where member_id = ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Member p = new Member();
			p.setMember_id(rs.getString("member_id"));
			p.setLast_name(rs.getString("last_name"));
			p.setFirst_name(rs.getString("first_name"));
			p.setSex(rs.getString("sex"));
			p.setBirth_year(rs.getInt("birth_year"));
			p.setBirth_month(rs.getInt("birth_month"));
			p.setBirth_day(rs.getInt("birth_day"));
			p.setPhone_number(rs.getString("phone_number"));
			p.setMail_address(rs.getString("mail_address"));
			p.setJob(rs.getString("job"));
			list.add(p);
		}

		st.close();
		con.close();
		return list;
	}



	public int search(String last_name, String first_name, String sex, int birth_year,
			int birth_month, int birth_day, String job, String phone_number, String mail_address)
					throws Exception {

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select count(*) from member_info where last_name=? and first_name=? and sex=? and birth_year=? and birth_month=? and birth_day=? and job=? and phone_number=? and mail_address=? ");
		st.setString(1, last_name);
		st.setString(2, first_name);
		st.setString(3, sex);
		st.setInt(4, birth_year);
		st.setInt(5, birth_month);
		st.setInt(6, birth_day);
		st.setString(7, job);
		st.setString(8, phone_number);
		st.setString(9, mail_address);
		ResultSet rs = st.executeQuery();


		int count = 0;
		while (rs.next()) {

			count = rs.getInt("count(*)");

		}
		st.close();
		con.close();
		return count;
	}

	public int insert(Member member) throws Exception {
		Connection con = getConnection();

		DateTime dt = new DateTime();
		String member_id = "A" + dt.datetime();

		PreparedStatement st = con.prepareStatement(
				"insert into member_info values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		st.setString(1, member_id);
		st.setString(2, member.getLast_name());
		st.setString(3, member.getFirst_name());
		st.setString(4, member.getSex());
		st.setInt(5, member.getBirth_year());
		st.setInt(6, member.getBirth_month());
		st.setInt(7, member.getBirth_day());
		st.setString(9, member.getPhone_number());
		st.setString(10, member.getMail_address());
		st.setString(8, member.getJob());

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;

	}

}

























