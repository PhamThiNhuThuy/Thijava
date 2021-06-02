package net.thuy.javanc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	@Query("SELECT p FROM Todo p WHERE CONCAT(p.tieude) LIKE %?1%")
    public List<Todo> search(String keyword);
	
}
