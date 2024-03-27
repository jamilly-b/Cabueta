package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Estudante;
import java.util.List;

/**
 *
 * @author jamilly
 */
<<<<<<< HEAD

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
    
    public static void update(Estudante e){
        for(Estudante estudante: estudantes){
            if(estudante.getCodigo() == e.getCodigo()){
                estudante.setNome(e.getNome());
                estudante.setEmail(e.getEmail());
                estudante.setSenha(e.getSenha());
                estudante.setAnoEntrada(e.getAnoEntrada());
                return;
            }
        }
    }
    
    public static List<Estudante> readAll(){
        return estudantes;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < estudantes.size();i++){
            if(estudantes.get(i).getCodigo()==codigo){
                estudantes.remove(i);
                estudantes.remove(estudantes.get(i));
                return;
            }
        }
=======
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
        
>>>>>>> origin/main
    }
}
