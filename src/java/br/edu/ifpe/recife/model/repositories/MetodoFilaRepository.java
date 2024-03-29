/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.MetodoFila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamilly
 */
public class MetodoFilaRepository {
    private static List<MetodoFila> metodos = new ArrayList<>();
    
    public static void create(MetodoFila mf){
        metodos.add(mf);
    }
    
    public static MetodoFila read(int codigo){
        for(MetodoFila metodo : metodos){
            if(metodo.getCodigo() == codigo){
                return metodo;
            }
        }
        return null;
    }
    
    public static void update(MetodoFila mf){
        for(MetodoFila metodo : metodos){
            if(metodo.getCodigo() == mf.getCodigo()){
                metodo.setDescricaoCurta(mf.getDescricaoCurta());
                metodo.setDescricaoLonga(mf.getDescricaoLonga());
                return;
            }
        }
    }
    
    public static List<MetodoFila> readAll(){
        return metodos;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < metodos.size();i++){
            if(metodos.get(i).getCodigo() == codigo){
                metodos.remove(i);
                return;
            }
        }
    }
}
