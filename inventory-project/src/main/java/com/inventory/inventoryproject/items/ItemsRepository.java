package com.inventory.inventoryproject.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

	@Query("SELECT s FROM Items s WHERE s.name = ?1")
	Optional<Items> findItemsByName (String name);
}
