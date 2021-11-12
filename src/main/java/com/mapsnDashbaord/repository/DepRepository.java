package com.mapsnDashbaord.repository;

import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource
@CrossOrigin("*")
public interface DepRepository extends JpaRepository<Departement, Long>{
	Departement findByCodeDep(String codeDep);
	Departement findByNameContaining(String nameDep);

	@Query("select p from Departement p " +
			//"join p.productType pt " +
			"where 1=1" +
			"and ( upper(p.name) like concat('%', upper(?1), '%') " +
			"       or upper(p.codeDep) like concat('%', upper(?1), '%') " +
			"       or upper(p.population) like concat('%', upper(?1), '%')" +
			//"       or upper(pt.name) like concat('%', upper(?1), '%')" +
			")")
	List<Departement> searchDepartement(String criteria);

}