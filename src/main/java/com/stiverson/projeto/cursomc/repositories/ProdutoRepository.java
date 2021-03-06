package com.stiverson.projeto.cursomc.repositories;




import java.util.List;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stiverson.projeto.cursomc.domain.Categoria;
import com.stiverson.projeto.cursomc.domain.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto ,Integer> {

	
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome ,List<Categoria> categorias , Pageable pageRequest);
}
