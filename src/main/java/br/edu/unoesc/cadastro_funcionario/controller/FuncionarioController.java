package br.edu.unoesc.cadastro_funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.unoesc.cadastro_funcionario.model.Funcionario;
import br.edu.unoesc.cadastro_funcionario.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
	private FuncionarioService servico;

    @GetMapping("/paginas")
	public String listarPagina(@RequestParam(value = "nome",defaultValue = "") String nome,
                                @RequestParam(value = "pagina",defaultValue = "0") Integer pagina,
                                @RequestParam(value = "tamPagina",defaultValue = "5") Integer tamPagina,
                                @RequestParam(value = "ordenacao",defaultValue = "nome") String campo,
                                @RequestParam(value = "direcao",defaultValue = "ASC") String direcao,
                                ModelMap modelo) {
        Page<Funcionario> buscaPagina = servico.buscaPaginaPorNome(nome, pagina, tamPagina, campo, direcao);
        modelo.addAttribute("pagina",buscaPagina);
        modelo.addAttribute("numRegistros",buscaPagina.getNumberOfElements());
        modelo.addAttribute("nome",nome);
        modelo.addAttribute("tamanhoPagina",tamPagina);
        modelo.addAttribute("campoOrdenacao",campo);
        modelo.addAttribute("direcaoOrdenacao",direcao);
        modelo.addAttribute("direcaoReversa",direcao.equals("ASC") ? "DESC" : "ASC");
        return "paginacao";
	}
}
