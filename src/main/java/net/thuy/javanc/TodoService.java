package net.thuy.javanc;

import java.util.List;

import org.hibernate.hql.spi.id.cte.CteValuesListBulkIdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> listAll(String keyword) {
		if (keyword != null) {
			return todoRepository.search(keyword);
		}
		return todoRepository.findAll();
	}
	
	public void save(Todo todo) {
		todoRepository.save(todo);
	}
	
	public Todo get(Long id) {
		return todoRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

}
