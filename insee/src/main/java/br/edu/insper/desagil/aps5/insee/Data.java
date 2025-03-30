package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia {
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer,Integer> limites;

    public Data (){
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        limites = new HashMap<Integer,Integer>();
        limites.put(1, 31);
        limites.put(2, 28);
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia(){
        return dia;
    }

    public void atualiza(int ano, int mes, int dia) {
        if (ano < 1970) {
            this.ano = 1970;
        } else {
            this.ano = ano;
        }

        if (mes < 1) {
            this.mes = 1;
        } else if (mes>12) {
            this.mes = 12;
        }else{
            this.mes = mes;
        }

        int limite = limites.get(mes);
        if (dia < 1){
            this.dia = 1;
        }else if(dia > limite){
            this.dia = limite;
        }else {
            this.dia = dia;
        }
    }

    @Override
    public int comoInteiro(){
        int total = (ano - 1970)*365;
        for (int m = 1;m<mes;m++){
            total += limites.get(m);
        }
        total += dia -1;
        return total;
    }
}
