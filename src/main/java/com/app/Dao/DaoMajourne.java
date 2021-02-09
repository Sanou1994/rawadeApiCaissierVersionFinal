package com.app.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.metier.entities.Majournee;

@Repository
public interface DaoMajourne extends JpaRepository<Majournee,Integer> {
	Majournee findByIdUAndIdAndStatus(int id,int date ,int idU);
	List<Majournee> findById(int userId);
	List<Majournee> findByIdAndIdUAndStatus(int date ,int idU,int status);
}