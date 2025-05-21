package br.com.alura.buscacep.modulos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void salvaJson(Endereco endereco){
        Gson enderecoJson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        try {
            System.out.println("\n" + enderecoJson.toJson(endereco) + "\n");

            FileWriter enderecoJsonDoc = new FileWriter("endereco.json");
            enderecoJsonDoc.write(enderecoJson.toJson(endereco));
            enderecoJsonDoc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
