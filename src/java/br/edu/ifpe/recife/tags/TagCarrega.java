package br.edu.ifpe.recife.tags;

import br.edu.ifpe.recife.model.repositories.CadeiraRepository;
import br.edu.ifpe.recife.model.repositories.EstudanteRepository;
import br.edu.ifpe.recife.model.repositories.MetodoFilaRepository;
import br.edu.ifpe.recife.model.repositories.ProfessorRepository;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author jamilly
 */
public class TagCarrega extends SimpleTagSupport {
    private String entidade;
    private String var;
    private String escopo;
    private String codigo;
        
    @Override
    public void doTag() throws JspException, IOException {
        Object result = null;
        
        switch (entidade.toLowerCase()) {
            case "professor":
                result = (codigo == null || codigo.isEmpty()) ? ProfessorRepository.readAll() : ProfessorRepository.read(Integer.parseInt(codigo));
                break;
            case "cadeira":
                result = (codigo == null || codigo.isEmpty()) ? CadeiraRepository.readAll() : CadeiraRepository.read(Integer.parseInt(codigo));
                break;
            case "estudante":
                result = (codigo == null || codigo.isEmpty()) ? EstudanteRepository.readAll() : EstudanteRepository.read(Integer.parseInt(codigo));
                break;
            case "metodofila":
                result = (codigo == null || codigo.isEmpty()) ? MetodoFilaRepository.readAll() : MetodoFilaRepository.read(Integer.parseInt(codigo));
                break;
            default:
                throw new JspException("Entidade não reconhecida: " + entidade);
        }

        if (result != null) {
            int scope = getScope(escopo);
            getJspContext().setAttribute(var, result, scope);
        }
    }

    private int getScope(String escopo) {
        switch (escopo.toLowerCase()) {
            case "pagina":
                return PageContext.PAGE_SCOPE;
            case "requisicao":
                return PageContext.REQUEST_SCOPE;
            case "sessao":
                return PageContext.SESSION_SCOPE;
            case "aplicacao":
                return PageContext.APPLICATION_SCOPE;
            default:
                return PageContext.PAGE_SCOPE;
        }
    }
    
    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
