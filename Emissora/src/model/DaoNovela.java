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
			
			Class.forName("com.mysql.jbdc.Driver");		//� utilizado para carregar dinamicamente o drive do jbdc
			
			conexao = (Connection) DriverManager.getConnection(url, usuario, senha); 	//Estabelece a Conex�o com o banco de dados
			conexao.setAutoCommit(false);
			
		}catch(ClassNotFoundException e) {
			System.out.println("Classe n�o encontrada");//Caso n�o consegue carrega ro drive na mem�ria, ir� exibir essa mensagem
			//e.printStackTrace();
		}catch(SQLException e) {						//Tratamento de exce��o, caso n�o consiga estabelecer a conex�o
			System.out.println("Erro de conex�o ao BD");
		}
	}

	public void Cadastrar(Novela nov) {
		String operacao = "INSERT INTO nome(titulo, horario, capitulos) VALUES(?, ?, ?)";
		
		try {
			PreparedStatement comando = 
					(PreparedStatement) conexao.prepareStatement(operacao); //comando para poder executar, mas vai esperar voc� da o commit
			
			comando.setString(1, nov.getTitulo()); 		//Vai procurar uma interroga��o na opera��o, e vai substuir a primeira interroga��o pela varo�vel comando.
			comando.setInt(2, nov.getHorario());
			comando.setInt(3, nov.getCapitulos());
			
			comando.executeUpdate();			//Vai executar a opera��o com comando, depois ser� necess�rio confirmar
			
			conexao.commit();
			conexao.close();
		}
		catch(SQLException e) {
			System.out.println("N�o foi poss�vel inserir no banco de dados!");
		}
	}
}
