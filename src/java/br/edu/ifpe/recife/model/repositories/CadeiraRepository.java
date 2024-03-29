/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Cadeira;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamilly
 */
public class CadeiraRepository {
    private static List<Cadeira> cadeiras = new ArrayList<>();
    
    public static void create(Cadeira c){
        cadeiras.add(c);
    }
    
    public static Cadeira read(int codigo){
        for(Cadeira cadeira : cadeiras){
            if(cadeira.getCodigo() == codigo){
                return cadeira;
            }
        }
        return null;
    }
    
    public static void update(Cadeira cad){
        for(Cadeira cadeira: cadeiras){
            if(cadeira.getCodigo() == cad.getCodigo()){
                cadeira.setNome(cad.getNome());
                cadeira.setCodigo(cad.getCodigo());
                cadeira.setAno(cad.getAno());
                cadeira.setSemestre(cad.getSemestre());
                cadeira.setDescricao(cad.getDescricao());
                return;
            }
        }
    }
    
    public static List<Cadeira> readAll(){
        return cadeiras;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < cadeiras.size();i++){
            if(cadeiras.get(i).getCodigo() == codigo){
                cadeiras.remove(i);
                return;
            }
        }
    }
}
