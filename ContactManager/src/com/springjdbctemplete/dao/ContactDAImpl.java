package com.springjdbctemplete.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbctemplete.model.Contact;

public class ContactDAImpl implements ContactDAO {

	private JdbcTemplate jdbctemplate;

	public ContactDAImpl(DataSource datasource) {
		this.jdbctemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int save(Contact contact) {
		String sql = "INSERT INTO contact (name,email,address,phone) values (?,?,?,?)";
		return jdbctemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE contact SET name=?,email=?,address=?,phone=? WHERE contact_id= ?";
		return jdbctemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(),
				contact.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * from contact where contact_id= " + id;

		ResultSetExtractor<Contact> resultextractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");

					return null;// new Contact(id, name, email, address, phone);
				}
				return null;
			}
		};

		return jdbctemplate.query(sql, resultextractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE from contact where contact_id= " + id;
		return jdbctemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * from contact";

		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact ct = new Contact();
				ct.setId(rs.getInt("contact_id"));
				ct.setName(rs.getString("name"));
				ct.setEmail(rs.getString("email"));
				ct.setAddress(rs.getString("address"));
				ct.setPhone(rs.getString("phone"));

				return ct;

				// Another way
				// Integer id = rs.getInt("contact_id");
				// String name = rs.getString("name");
				// String email = rs.getString("email");
				// String address = rs.getString("address");
				// String phone = rs.getString("phone");
				// return new Contact(id, name, email, address, phone);

			}
		};

		return jdbctemplate.query(sql, rowMapper);
	}

}
