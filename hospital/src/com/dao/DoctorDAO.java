package com.dao;

import java.util.ArrayList;

import com.models.DoctorDetails;
import com.models.DoctorSlots;

public interface DoctorDAO {
	ArrayList<DoctorDetails> getAllDoctors();

	ArrayList<DoctorSlots> getAllSlotsById(int doc_id);
}
