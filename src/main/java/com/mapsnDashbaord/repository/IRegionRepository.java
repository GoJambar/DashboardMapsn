package com.mapsnDashbaord.repository;

import java.util.List;

import com.mapsnDashbaord.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource
@CrossOrigin("*")
public interface IRegionRepository extends JpaRepository<Region, Long> {
	Region findByCodeRegion(String codeRegion);
	List<Region> findByNameContains(String regionName);
	 @Query("select p from Region p " +
	            //"join p.productType pt " +
	            "where 1=1" +
	            "and ( upper(p.name) like concat('%', upper(?1), '%') " +
	            "       or upper(p.codeRegion) like concat('%', upper(?1), '%') " +
	            "       or upper(p.population) like concat('%', upper(?1), '%')" +
	            //"       or upper(pt.name) like concat('%', upper(?1), '%')" +
	            ")")
	    List<Region> searchRegion(String criteria);
}


