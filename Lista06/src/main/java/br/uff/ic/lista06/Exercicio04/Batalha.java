/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.uff.ic.lista06.Exercicio04;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Batalha {
    
    public void ataque(Pokemon atacante, Pokemon defensor) {
        ArrayList<Ataques> moves = atacante.getAtaques();
        Ataques ataqueUtilizado = moves.get(0); //Deixei indice 0 por praticidade, mas a ideia seria pega o move do usuario
        String tipoAtaque = ataqueUtilizado.getTipo();
        String nomeAtaque = ataqueUtilizado.getNome();
        String funcaoAtaque = ataqueUtilizado.getTipoPower();
        //Caso o golpe seja de Status chamaria a funcao ataques condicoes que olharia seu efeito
        //faria um calculo com a precisao, para ver se acertou, e afetaria o pokemon defensor com a condicao
        int hpAtual = defensor.atributos.getHp();
        int forcaAtaqueUtilizado = ataqueUtilizado.getPower();
        double precisao = ataqueUtilizado.getPrecisao();
        ataqueUtilizado.setPP();
        //Aqui haveria um calculo que levatria em conta a defesa (especial ou normal, dependendo do move) do pokemon defensor e ataque do pokemon atacante mais a forca do move
        //Tambem haveria um calculo da precisao para ver se o golpe acertou
        //Caso o golpe cause algum efeito haveria um calculo com a porcentagem de ativar a condicao e afetaria o pokemon defensor
    }
    public void ataqueCondicoes (Pokemon atacante, Pokemon defensor) {
        
    }
}
