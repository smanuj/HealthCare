package com.example.hospital.service;

import com.example.hospital.entity.Nurse_details;

public interface NurseService {

	Nurse_details approvingNurse(int id);

	void deleteNurse(int id);

}
