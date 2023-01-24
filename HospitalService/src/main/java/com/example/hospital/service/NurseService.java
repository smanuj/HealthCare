package com.example.hospital.service;

import com.example.hospital.entity.NurseDetails;

public interface NurseService {

	NurseDetails approvingNurse(int id);

	void deleteNurse(int id);

}
