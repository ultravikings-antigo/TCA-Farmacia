package sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static int MAX_CONNECTIONS=5;
    private static ConnectionCreator instance = new ConnectionCreator();

    private static String ENDERECO_SERVIDOR = "infoprojetos.com.br:3132";
    private static String NOME_BANCO = "info18_gustavo";

    private static String USER="info18_gustavo";
    private static String PASSWORD="gustavo85071119";

    private static String STRING_CONEXAO ="jdbc:mysql://"+ENDERECO_SERVIDOR+"/"+NOME_BANCO; //porta 31 32;

    private static Connection[] connections;

    private ConnectionCreator (){
        connections = new Connection[MAX_CONNECTIONS];
    }

    public static Connection getConnection() throws SQLException {
        for (int i=0; i<MAX_CONNECTIONS; i++){
            if (connections[i] == null || connections[i].isClosed()){
                connections[i] = DriverManager.getConnection(STRING_CONEXAO,USER,PASSWORD);

                return connections[i];
            }
        }

        throw new SQLException("Muitas conexoes abertas");
    }
}
