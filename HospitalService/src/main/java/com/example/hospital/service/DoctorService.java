package com.example.hospital.service;

import com.example.hospital.entity.Doctor_details;

public interface DoctorService {

	Doctor_details approvingDoctor(int id);

	void deleteDoctor(int id);

}
