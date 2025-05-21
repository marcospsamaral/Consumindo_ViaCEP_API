package br.com.alura.buscacep.principal;

import br.com.alura.buscacep.modulos.Endereco;
import br.com.alura.buscacep.modulos.EnderecoViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String leitura = scanner.nextLine();
        List<Endereco> enderecos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+leitura+"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            EnderecoViaCep enderecoViaCep = gson.fromJson(response.body(), EnderecoViaCep.class);
            System.out.println(enderecoViaCep);
            Endereco endereco = new Endereco(enderecoViaCep);
            enderecos.add(endereco);

        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println(enderecos);
        FileWriter enderecoJSON = new FileWriter("endereco.json");
        enderecoJSON.write(gson.toJson(enderecos));
        enderecoJSON.close();
    }
}
