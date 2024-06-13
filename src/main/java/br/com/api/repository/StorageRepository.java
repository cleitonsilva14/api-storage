package br.com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long>{

	
	Optional<ImageData> findByName(String fileName);
	
	@Query(value="SELECT name FROM tb_image_data;", nativeQuery=true)
	List<String> findAllByName();
	
}
