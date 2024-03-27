package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Estudante;
import java.util.List;

/**
 *
 * @author jamilly
 */
public class EstudanteRepository {
    
    private static List<Estudante> estudantes;
    
    public static void create(Estudante e){
        estudantes.add(e);
    }
    
    public static Estudante read(int codigo){
        for(Estudante estudante : estudantes){
            if(estudante.getCodigo() == codigo){
                return estudante;
            }
        }
        return null;
    }
    
    public static void update(){
        
    }
    public static void delete(){
        
    }
}
