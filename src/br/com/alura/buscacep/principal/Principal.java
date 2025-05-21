package br.com.alura.buscacep.principal;

import br.com.alura.buscacep.modulos.ConsultaCep;
import br.com.alura.buscacep.modulos.Endereco;
import br.com.alura.buscacep.modulos.GeradorDeArquivo;
import com.google.gson.JsonSyntaxException;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaCep consulta = new ConsultaCep();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu CEP: ");
        String leitura = scanner.nextLine().replaceAll("\\s-", "");

        try {
            Endereco novoEndereco = consulta.buscaEndereco(leitura);
            GeradorDeArquivo enderecoJson = new GeradorDeArquivo();
            enderecoJson.salvaJson(novoEndereco);

        } catch (JsonSyntaxException e){
            System.out.println("Digite um cep válido: " + e);
        }




    }
}
