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
			ProyectoDAO mDAO=(ProyectoDAO)ProyectoDAOImpl.getInstance();
			List<ProyectoB> listaProyectos = mDAO.getProyecto();
			request.setAttribute("getUserProyecto", listaProyectos);

			request.getRequestDispatcher("proyectos.jsp").forward(request, response);
		} else {
			misession.invalidate();
			response.sendRedirect("loginServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {

			int userproyecto = request.getParameter("userproyecto") != null
					? Integer.parseInt(request.getParameter("userproyecto")) : 0;
		
			if (userproyecto > 0) {

				UsuarioB elUsuario = (UsuarioB) misession.getAttribute("usuario");
				ProyectoDAO pDAO=(ProyectoDAO)ProyectoDAOImpl.getInstance();
				TareaDAO tDAO=(TareaDAO)TareaDAOImpl.getInstance();
				
				ProyectoB unProy= pDAO.getProyecto(userproyecto);

//				TareaB nuevaTarea = new TareaB(idTarea, nombreTarea, descTarea, responsable, usuariosImp);

//				if (!tDAO.insertTarea(nuevaTarea)) {
//					request.setAttribute("error", "No se ha podido terminar el proceso :-(. Vuelve a intentarlo...");
//					doGet(request, response);
//				} else {
//					request.getRequestDispatcher("lista_maquillajes").forward(request, response);
//				}
				
			} else {
				request.setAttribute("error", "Selecciona un cosm�tico e indica una cantidad igual o mayor a uno");
				doGet(request, response);
			}
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

}