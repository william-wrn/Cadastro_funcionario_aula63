package br.edu.unoesc.cadastro_funcionario.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.cadastro_funcionario.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    public List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    @Query("Select f from Funcionario f where f.salario BETWEEN :salarioMenor AND :salarioMaior")
	public List<Funcionario> findSalarioEntre(@Param("salarioMenor") BigDecimal salarioMenor,
                                                @Param("salarioMaior") BigDecimal salarioMaior);
    
    public Page<Funcionario> findByNomeContainingIgnoreCase(String nome, Pageable pagina);

    @Query("Select f from Funcionario f where f.numDep >= 1")
	public List<Funcionario> findSeDependentes();
}
