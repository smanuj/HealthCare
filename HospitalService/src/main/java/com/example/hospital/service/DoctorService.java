package com.example.hospital.service;

import com.example.hospital.entity.DoctorDetails;

public interface DoctorService {

	DoctorDetails approvingDoctor(int id);

	void deleteDoctor(int id);

}
