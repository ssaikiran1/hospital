package com.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.models.DoctorDetails;
import com.models.DoctorMapper;
import com.models.DoctorSlots;
import com.models.DoctorSlotsMapper;

public class DoctorDAOImp implements DoctorDAO {
	JdbcTemplate jdbcTemplate;

	@Autowired
	public DoctorDAOImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_GET_DOCTORS = "select * from doctor_details";
	private final String SQL_GET_SLOTS = "select * from slot_details where s_status='Open' and s_docid=?";

	@Override
	public ArrayList<DoctorDetails> getAllDoctors() {

		return (ArrayList<DoctorDetails>) jdbcTemplate.query(SQL_GET_DOCTORS, new DoctorMapper());
	}

	@Override
	public ArrayList<DoctorSlots> getAllSlotsById(int doc_id) {
		// TODO Auto-generated method stub

		return (ArrayList<DoctorSlots>) jdbcTemplate.query(SQL_GET_SLOTS, new Object[] { doc_id },
				new DoctorSlotsMapper());
	}

}
