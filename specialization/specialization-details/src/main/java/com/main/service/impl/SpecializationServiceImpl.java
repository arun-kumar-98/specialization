package com.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Specialization;
import com.main.repository.ISpecializationRepository;
import com.main.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private ISpecializationRepository specializationRepository;

	@Override
	public Specialization addSpecialization(Specialization specialization) {
		return specializationRepository.save(specialization);
	}

	@Override
	public List<Specialization> getAllDetails() {

		return specializationRepository.findAll();
	}

	@Override
	public Specialization getOne(Integer id) {
		Optional<Specialization> optional = specializationRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void remove(Integer id) {
		specializationRepository.deleteById(id);
	}

	@Override
	public Specialization updateSpecialization(Specialization specialization) {

		Specialization specialization2 = specializationRepository.save(specialization);
		return specialization2;

	}

	@Override
	public boolean isExistsSpecialization(String code) {
		Integer count = specializationRepository.getSpecCodeCount(code);
		boolean exists = count > 0 ? true : false;
		return exists;
	}
}
