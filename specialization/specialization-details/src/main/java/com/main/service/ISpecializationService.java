package com.main.service;

import java.util.List;

import com.main.entity.Specialization;

public interface ISpecializationService {

	Specialization addSpecialization(Specialization specialization);

	List<Specialization> getAllDetails();

	Specialization getOne(Integer id);

	void remove(Integer id);

	boolean isExistsSpecialization(String code);
}
