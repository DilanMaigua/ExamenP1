package com.calificacion.notas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.calificacion.datos.*;

public class Valoracion {

	public String ingresarValoracion(int id, int nota,String opinion, String nombre)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement pr=null;
		String sql="INSERT INTO tb_valoracion (id_va,valoracion_va,"
				+ "opinion_va,nombre_us) "
				+ "VALUES(?,?,?,?)";
		try{
			pr=con.getConexion().prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2,nota);
			pr.setString(3,opinion);
			pr.setString(4,nombre);
			if(pr.executeUpdate()==1)
			{
				result="Inserción correcta";
			}
			else
			{
				result="Error en inserción";
			}
		}
		catch(Exception ex)
		{
			result=ex.getMessage();
		}
		finally
		{
			try
			{
				pr.close();
				con.getConexion().close();
			}
			catch(Exception ex)
			{
				System.out.print(ex.getMessage());
			}
		}
		return result;
	}
		
	public int consultarmaxID()
	{
		String sql="SELECT MAX(id_va) FROM tb_valoracion";
		Conexion con=new Conexion();
		int max=0;
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				max=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return max;
	}
	
	
	public int consultarValoracion()
	{
		String sql="SELECT AVG(valoracion_va)FROM tb_valoracion";
		Conexion con=new Conexion();
		int max=0;
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				max=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return max;
	}
	
	public String consultarValoraciones()
	{
		String sql="SELECT * FROM tb_valoracion ORDER BY id_va";
		Conexion con=new Conexion();
		String tabla="<table border=2><th bgcolor=\"#5863F8\" , style=\"border: solid 4px black; font-size: 30px;\">Id</th><th bgcolor=\"#5863F8\" , style=\"border: solid 4px black; font-size: 30px;\">Nombre</th>"
				+ "<th bgcolor=\"#5863F8\" , style=\"border: solid 4px black; font-size: 30px;\">Puntuacion</th><th bgcolor=\"#5863F8\" , style=\"border: solid 4px black; font-size: 30px;\">Sugerencia</th>";
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td bgcolor=\\\"#FFFFFF\\\" style=\"border: solid 4px black;\"><p style=\"color:black\">"+rs.getInt(1)+"</p></td>"
						+ "<td bgcolor=\\\"#FFFFFF\\\" style=\"border: solid 4px black;\"><p style=\"color:black\">"+rs.getString(4)+"</p></td>"
						+"<td bgcolor=\\\"#FFFFFF\\\" style=\"border: solid 4px black;\"><p style=\"color:black\">"+rs.getInt(2)+"</p></td>"
						+ "<td bgcolor=\\\"#FFFFFF\\\" style=\"border: solid 4px black;\"><p style=\"color:black\">"+rs.getString(3)+"</p></td>"
						+ "</td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla+="</table>";
		return tabla;
	}
	
}
