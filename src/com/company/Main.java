package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception {
        ConexaoMysql conn = new ConexaoMysql();
        conn.conectarMySQL();
        String query = "SELECT * FROM teste";
        ResultSet rs = conn.execute(query);

        ObjectMapper objectMapper = new ObjectMapper();

        JSONArray result = new JSONArray();

        result = Converter.convertToJSON(rs);

        User user = objectMapper.readValue(result.toString(), User.class);

        System.out.println("nome " + user.getName());

        conn.FecharConexao();
    }
}