package com.netmind.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netmind.db.TareaDAO;
import com.netmind.db.TareaDAOImpl;
import com.netmind.db.ProyectoDAO;
import com.netmind.db.ProyectoDAOImpl;
import com.netmind.models.ProyectoB;
import com.netmind.models.TareaB;
import com.netmind.models.UsuarioB;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {
			
			ProyectoDAO pDAO = (ProyectoDAO) ProyectoDAOImpl.getInstance();
			TareaDAO tDAO = (TareaDAO) TareaDAOImpl.getInstance();

			int idP = request.getParameter("idProyecto") != null ? Integer.parseInt(request.getParameter("idProyecto"))
					: 0;

			// Obtener proyecto
			ProyectoB proyectoADevolver = pDAO.getProyecto(idP);
			request.setAttribute("getProyecto", proyectoADevolver);

			// obtener lista de tareas asociadas al proyecto
			List<TareaB> listaTareas = tDAO.getTarea(proyectoADevolver.getIdProyecto());
			request.setAttribute("getTarea", listaTareas);

			request.getRequestDispatcher("proyectos.jsp").forward(request, response);
		} else {
			misession.invalidate();
			response.sendRedirect("loginServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
