package com.mapsnDashbaord.repository;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Commun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource
@CrossOrigin("*")
public interface ICommunRepository extends JpaRepository<Commun, Long> {
	Commun findByCodeCom(String codeCom);
	Commun findByName(String nameCom);

	@Query("select p from Commun p " +
			//"join p.productType pt " +
			"where 1=1" +
			"and ( upper(p.name) like concat('%', upper(?1), '%') " +
			"       or upper(p.codeCom) like concat('%', upper(?1), '%') " +
			"       or upper(p.population) like concat('%', upper(?1), '%')" +
			//"       or upper(pt.name) like concat('%', upper(?1), '%')" +
			")")
	List<Commun> searchCommun(String criteria);

}
