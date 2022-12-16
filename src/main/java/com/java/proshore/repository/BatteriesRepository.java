package com.java.proshore.repository;

import java.util.List;

/**
 * @author chaturanand yadav
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.proshore.model.Batteries;

public interface BatteriesRepository extends JpaRepository<Batteries, Long> {
	
	@Query(value = "SELECT SUM(b.capacity) as SUM,AVG(b.capacity) as AVERAGE FROM Batteries b", nativeQuery = true)
	List<String> countStatistics();
}
