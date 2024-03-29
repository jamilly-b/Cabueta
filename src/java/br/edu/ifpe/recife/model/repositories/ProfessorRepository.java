/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamilly
 */
public class ProfessorRepository {
    
    private static List<Professor> professores = new ArrayList<>();
    
    public static void create(Professor p){
        professores.add(p);
    }
    
    public static Professor read(int codigo){
        for(Professor professor : professores){
            if(professor.getCodigo() == codigo){
                return professor;
            }
        }
        return null;
    }
    
    public static void update(Professor p){
        for(Professor prof: professores){
            if(prof.getCodigo() == p.getCodigo()){
                prof.setNome(p.getNome());
                prof.setEmail(p.getEmail());
                prof.setSenha(p.getSenha());
                return;
            }
        }
    }
    
    public static List<Professor> readAll(){
        return professores;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < professores.size(); i++){
            if(professores.get(i).getCodigo() == codigo){
                professores.remove(i);
            }
        }
    }
}
