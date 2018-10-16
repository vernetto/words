package org.pierre.words;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ScansRepository extends CrudRepository<Scans, Integer> {
	List<Scans> findByFilename(String fileName);

}
