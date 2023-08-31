package com.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.DoctorDAO;
import com.models.DoctorDetails;
import com.models.DoctorId;
import com.models.DoctorSlots;

@Controller
public class HospitalController {
	DoctorDAO da;

	@Autowired
	public HospitalController(DoctorDAO da) {
		this.da = da;
	}

	@RequestMapping(value = "/findslots", method = RequestMethod.GET)
	public String findSlots(DoctorId did, Model model) {
		String o = did.getDoc_id();
		int doc_id = Integer.parseInt(o.substring(24, did.getDoc_id().length()));
		ArrayList<DoctorSlots> slotDetails = da.getAllSlotsById(doc_id);
		model.addAttribute("doctorslots", slotDetails);
		System.out.println(slotDetails.size());
		return "calender";
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String home(Model model) {
		ArrayList<DoctorDetails> docDetails = da.getAllDoctors();
		model.addAttribute("doctors", docDetails);
		return "home";
	}

}
