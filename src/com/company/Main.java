package com.company;

import org.json.JSONArray;

import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception {
        getUser();

    }

    public static void getUser() throws Exception {
        ConexaoMysql conn = new ConexaoMysql(); // instancia nova conexão
        conn.conectarMySQL(); // inicia conexão
        String query = "SELECT * FROM teste"; // query no banco
        ResultSet rs = conn.execute(query); // realiza query

        JSONArray result = Converter.convertToJSON(rs); // converte para JSON

        /*while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            System.out.println(user.getName());
        }*/

        System.out.println(result);

        conn.FecharConexao();
    }
}