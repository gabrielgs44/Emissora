package model;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DaoNovela {
	private Connection conexao;

	public DaoNovela() {
		String url = "jbdc:mysql://localhost/emissora"; //Caminho para o banco de dados
		String usuario = "root";						//Usuario
		String senha = "123456";						//Senha do Banco
		
		try {
			
			Class.forName("com.mysql.jbdc.Driver");		//É utilizado para carregar dinamicamente o drive do jbdc
			
			conexao = (Connection) DriverManager.getConnection(url, usuario, senha); 	//Estabelece a Conexão com o banco de dados
			conexao.setAutoCommit(false);
			
		}catch(ClassNotFoundException e) {
			System.out.println("Classe não encontrada");//Caso não consegue carrega ro drive na memória, irá exibir essa mensagem
			//e.printStackTrace();
		}catch(SQLException e) {						//Tratamento de exceção, caso não consiga estabelecer a conexão
			System.out.println("Erro de conexão ao BD");
		}
	}

	public void Cadastrar(Novela nov) {
		String operacao = "INSERT INTO nome(titulo, horario, capitulos) VALUES(?, ?, ?)";
		
		try {
			PreparedStatement comando = 
					(PreparedStatement) conexao.prepareStatement(operacao); //comando para poder executar, mas vai esperar você da o commit
			
			comando.setString(1, nov.getTitulo()); 		//Vai procurar uma interrogação na operação, e vai substuir a primeira interrogação pela varoável comando.
			comando.setInt(2, nov.getHorario());
			comando.setInt(3, nov.getCapitulos());
			
			comando.executeUpdate();			//Vai executar a operação com comando, depois será necessário confirmar
			
			conexao.commit();
			conexao.close();
		}
		catch(SQLException e) {
			System.out.println("Não foi possível inserir no banco de dados!");
		}
	}
}
