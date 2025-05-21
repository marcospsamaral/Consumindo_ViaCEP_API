package br.com.alura.buscacep.principal;

import br.com.alura.buscacep.modulos.ConsultaCep;
import br.com.alura.buscacep.modulos.Endereco;
import br.com.alura.buscacep.modulos.GeradorDeArquivo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu CEP: ");
        String leitura = scanner.nextLine().replaceAll("\\s-", "");


        try {
            ConsultaCep consulta = new ConsultaCep();
            Endereco novoEndereco = consulta.buscaEndereco(leitura);
            GeradorDeArquivo enderecoJson = new GeradorDeArquivo();
            enderecoJson.salvaJson(novoEndereco);

        } catch (JsonSyntaxException e){
            System.out.println("Digite um cep válido: " + e);
        }




    }
}
