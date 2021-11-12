package com.mapsnDashbaord.repository;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface IArrondissementRepository extends JpaRepository<Arrondissement, Long> {
	Arrondissement findByCodeAr(String codeAr);
	Arrondissement findByName (String nameAr);
	@Query("select p from Arrondissement p " +
			//"join p.productType pt " +
			"where 1=1" +
			"and ( upper(p.name) like concat('%', upper(?1), '%') " +
			"       or upper(p.codeAr) like concat('%', upper(?1), '%') " +
			"       or upper(p.population) like concat('%', upper(?1), '%')" +
			//"       or upper(pt.name) like concat('%', upper(?1), '%')" +
			")")
	List<Arrondissement> searchArrondissement(String criteria);

}
