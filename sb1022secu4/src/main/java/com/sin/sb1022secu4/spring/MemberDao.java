package com.sin.sb1022secu4.spring;



import com.sin.sb1022secu4.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getString("ROLE"),
								rs.getTimestamp("REGDATE").toLocalDateTime()
								);
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email);

		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, USERNAME ,REGDATE,ROLE) " +
						"values (?, ?, ?, ?,?)",
						new String[] { "ID" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getUsername());
				pstmt.setTimestamp(4,
						Timestamp.valueOf(member.getRegdate()));
				pstmt.setString(5, member.getRole());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getUsername(), member.getPassword(), member.getEmail());
	}

//	public List<Member2> selectAll() {
//		List<Member2> results = jdbcTemplate.query("select * from MEMBER",
//				(ResultSet rs, int rowNum) -> {
//					Member2 member = new Member2(
//							rs.getString("EMAIL"),
//							rs.getString("PASSWORD"),
//							rs.getString("NAME"),
//							rs.getTimestamp("REGDATE").toLocalDateTime());
//					member.setId(rs.getLong("ID"));
//					return member;
//				});
//		return results;
//	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}

}
