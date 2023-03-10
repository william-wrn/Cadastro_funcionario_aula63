package br.edu.unoesc.cadastro_funcionario.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.edu.unoesc.cadastro_funcionario.dto.FuncionarioDTO;
import br.edu.unoesc.cadastro_funcionario.model.Funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {
    void popularInicial();

    Funcionario incluir(Funcionario funcionario);
    Funcionario alterar(Long id,Funcionario funcionario);
    void excluir(Long id);

    List<Funcionario> listar();
    Page<FuncionarioDTO> listarPaginado(Pageable pagina);
    Page<Funcionario> buscaPaginaPorNome(String nome,Integer pagina, Integer tamPagina,String campo, String direcao);

    Funcionario buscar(Long id);
    Funcionario buscarPorId(Long id);
    Optional<Funcionario> porId(Long id);

    List<Funcionario> buscarPorNome(String nome);
    List<Funcionario> buscarPorFaixaSalarial(BigDecimal salarioMinimo, BigDecimal salarioMaximo);
    List<Funcionario> buscaePossuiDependentes(Integer numDep);

}
