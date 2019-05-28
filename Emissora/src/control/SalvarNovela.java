package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoNovela;
import model.Novela;

@WebServlet("/SalvarNovela")
public class SalvarNovela extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		int horario = Integer.parseInt(request.getParameter("horario"));
		int capitulos = Integer.parseInt(request.getParameter("capitulos"));

		Novela nov = new Novela(titulo, horario, capitulos);
		DaoNovela daonov = new DaoNovela();

		daonov.Cadastrar(nov);

		RequestDispatcher desp = request.getRequestDispatcher("confirmacao.jsp");
		desp.forward(request, response);
	}

}