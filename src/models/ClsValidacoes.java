package models;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Classe responsavel por validacoes de CPF e CNPJ
 *
 * @author Tiago Teixeira
 */
public class ClsValidacoes {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    //false CNPJ -- true CPF
    private static boolean tipoCpfCnpj;

    /**
     *  //false CNPJ -- true CPF
     * @return 
     */
    public  boolean isTipoCpfCnpj() {
        return tipoCpfCnpj;
    }
    
    //entra com uma string e valida se é valido ou nâo o CPF ou CNPJ
    public boolean isValid(String cpfCnpj) {
        return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
    }
    
    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static boolean isValidCPF(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        for (int j = 0; j < 10; j++) {
            if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf)) {
                return false;
            }
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        tipoCpfCnpj = true;
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
       
        
    }

    private static boolean isValidCNPJ(String cnpj) {
        cnpj = cnpj.trim().replace(".", "").replace("-", "");
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        tipoCpfCnpj = false;
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    
    


    /**
     * entra uma string e retira os dados em qualquer parte que esteja
     * @param dado
     * @return
     */
    public String replaceDado(String dado) {
        dado = dado.replaceAll("\\.", "");
        dado = dado.replaceAll("-", "");
        dado = dado.replaceAll("R", "");
        dado = dado.replaceAll("$", "");             
        return dado;
    }
    

   

    /**
     * entra uma string no formato BR 01/05/2010 e retorna em formato US
     * @param dataEntrada
     * @return Retorna DATA formatada em formato US 2010-05-01
     */
    public String dataFormatoUS(String dataEntrada) {
        //10-10-2010
        String dia = dataEntrada.substring(0, 2);
        String mes = dataEntrada.substring(3, 5);
        String ano = dataEntrada.substring(6);
        String dataSaida = ano + "/" + mes + "/" + dia;
        return dataSaida;
    }
    
    //

    /**
     * entra uma string no formato US 2010-05-01 e retorna em formato BR
     * @param dataEntrada
     * @return  string com data formatada em formato BR 01/05/2020
     */
    public String dataFormatoBR(String dataEntrada) {
        //2001-01-01 10-10-2010
        String ano = dataEntrada.substring(0, 4);
        String mes = dataEntrada.substring(5, 7);
        String dia = dataEntrada.substring(8);
        String dataSaida = dia + "/" + mes + "/" + ano;
        return dataSaida;
    }
    
    //entra uma string de data e retorna se e valida ou não (true ou false)
    public boolean validaDataFormatoBR(String data) {
      try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            sdf.setLenient(false);
            
            sdf.parse(data);
            
            return true;
        } catch (ParseException ex) {
            
            return false;
        }
    }

    public float formataMoeda(String arg) throws ParseException {
        //obtem um NumberFormat para o Locale default (BR)
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        //converte um número com vírgulas ex: 2,56 para double
        float number = nf.parse(arg).floatValue();
        return number;
    }

}
