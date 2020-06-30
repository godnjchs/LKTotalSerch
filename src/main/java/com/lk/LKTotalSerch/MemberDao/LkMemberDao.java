package com.lk.LKTotalSerch.MemberDao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lk.LKTotalSerch.domain.LKMemberVo;

public class LkMemberDao {
	
	JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(LKMemberVo vo) {
		jdbcTemplate.update("insert into lkmember values(?,?,?,sysdate)",vo.getUserId(),vo.getPwd(),vo.getName());
	}
	
}
