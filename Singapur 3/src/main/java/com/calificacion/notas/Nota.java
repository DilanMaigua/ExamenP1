package com.calificacion.notas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.calificacion.datos.*;
import com.calificacion.notas.usuarios;

public class Nota {
	
	
	private int id_no;
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	private int nota5;
	private int notafinal;
	private int id_us;
	
	public Nota() {
		
		
	}
	
	
	
	
	
	public int getId_no() {
		return id_no;
	}

	public void setId_no(int id_no) {
		this.id_no = id_no;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

	public int getNota4() {
		return nota4;
	}

	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}

	public int getNota5() {
		return nota5;
	}

	public void setNota5(int nota5) {
		this.nota5 = nota5;
	}

	public int getNotafinal() {
		return notafinal;
	}

	public void setNotafinal(int notafinal) {
		this.notafinal = notafinal;
	}

	public int getId_us() {
		return id_us;
	}

	public void setId_us(int id_us) {
		this.id_us = id_us;
	}
	
	
	public String ingresarNotas(int id, int nota1, int nota2,int nota3,int nota4,int nota5,int notafinal,String nombre)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement pr=null;
		String sql="INSERT INTO tb_notas (id_no,nota1,"
				+ "nota2,nota3,nota4,nota5,notafinal,nombre_us) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try{
			pr=con.getConexion().prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2,nota1);
			pr.setInt(3,nota2);
			pr.setInt(4,nota3);
			pr.setInt(5,nota4);
			pr.setInt(6,nota5);
			pr.setInt(7,notafinal);
			pr.setString(8,nombre);
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
	
	public String consultarTodo()
	{
		String sql="SELECT id_us,notafinal,tb_usuarios.nombre_us FROM tb_notas,tb_usuarios WHERE tb_notas.id_no=tb_usuarios.id_us AND tb_notas.nombre_us=tb_usuarios.nombre_us ORDER BY notafinal DESC LIMIT 10;"
				+ " ";
		Conexion con=new Conexion();
		String tabla="<table border=3><th bgcolor=\\\"#5863F8\\\" , style=\\\"border: solid 4px black; font-size: 50px;\\\">Calificacion</th>"
				+ "<th bgcolor=\\\\\\\"#5863F8\\\\\\\" , style=\\\\\\\"border: solid 4px black; font-size: 50px;\\\\\\\">Nombre</th>"
				+ "<th bgcolor=\\\"#5863F8\\\" , style=\\\"border: solid 4px black; font-size: 100px;\\\">Foto</th>";
		ResultSet rs=null;
		usuarios usu =new usuarios();
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td bgcolor=\\\\\\\"#FFFFFFF\\\\\\\" style=\\\"border: solid 4px black;\\\"><p style=\\\"color:black\\\">"+rs.getInt(2) +"</td>"
						+ "<td bgcolor=\\\\\\\"#FFFFFFF\\\\\\\" style=\\\"border: solid 4px black;\\\"><p style=\\\"color:black\\\">"+rs.getString(3) +"</td>"
						+ "<td><img width=\"100\" height=\"100\" src=\" "+usu.mostrarFoto(rs.getInt(1))+ " \"></td>"
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
	
	
	
	
	
	public int consultarmaxID()
	{
		String sql="SELECT MAX(id_no) FROM tb_notas";
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
	
	
	
}
