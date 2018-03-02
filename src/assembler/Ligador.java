/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.ArrayList;

/**
 *
 * @author lorenzo
 */
public class Ligador {
    public Ligador(){}

    /**
     *
     * @return
     */
    public EntradaCarregador liga(ArrayList<EntradaLigador> entradasLigador){
        EntradaCarregador entradaCarregador = new EntradaCarregador();
        ArrayList<InstrucaoAssembler> intrucoesAssembler = new ArrayList<>();
        
        for(int i = 0; i < entradasLigador.size(); i++){
            ArrayList<InstrucaoAssembler> saida = entradasLigador.get(i).getSaida();
            for(int j = 0; j < saida.size(); j++){
                intrucoesAssembler.add(saida.get(j));
                System.out.println(saida.get(j).getOperator());
            }
        }
        
        
        //entradaCarregador.setSaida(intrucoesAssembler);
                
        return entradaCarregador;
    }
}
