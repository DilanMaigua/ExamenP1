package com.calificacion.notas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.calificacion.datos.Conexion;

public class usuarios {
		private int id_us;
		private String nombre;
		
		public usuarios() {
			
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public int getId_us() {
			return id_us;
		}
		
		public void setId_us(int id_us) {
			this.id_us = id_us;
		}
		
		public String consultarUsuarios()
		{
			String sql="SELECT * FROM tb_usuarios ORDER BY id_us";
			Conexion con=new Conexion();
			String tabla="<table border=2><th>Id</th><th>Nombre</th>";
			ResultSet rs=null;
			rs=con.Consulta(sql);
			try {
				while(rs.next())
				{
					tabla+="<tr><td>"+rs.getInt(1)+"</td>"
							+ "<td>"+rs.getString(2)+"</td>"
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
		public String ingresarUsuario(int id,String nombre,String foto)
		{
			String result="";
			Conexion con=new Conexion();
			PreparedStatement pr=null;
			String sql="INSERT INTO tb_usuarios (id_us,nombre_us,foto_us) "
					+ "VALUES(?,?,?)";
			byte[] byteArr = foto.getBytes();
			try{
				pr=con.getConexion().prepareStatement(sql);
				pr.setInt(1,id);
				pr.setString(2, nombre);
				pr.setBytes(3, byteArr);
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
			
		public String mostrarFoto(int foto_id) {
			String fo = "";
			String sql = "select encode(foto_us, 'escape') from tb_usuarios where id_us="+ foto_id+";";
			ResultSet rs = null;
			Conexion con = new Conexion();
			try {
				rs = con.Consulta(sql);
				while (rs.next()) {
					fo += rs.getString(1);
				}
			} catch (SQLException e) {
				System.out.print(e.getMessage());
			}
			return fo;
		}
		
		public String mostrarUsuarios()
		{
			String combo="<select name=cmbUsuarios>";
			String sql="SELECT * FROM tb_usuarios";
			ResultSet rs=null;
			Conexion con=new Conexion();
			try
			{
				rs=con.Consulta(sql);
				while(rs.next())
				{
					combo+="<option value="+rs.getString(2)+ ">"+rs.getString(2)+"</option>";
				}
				combo+="</select>";
			}
			catch(SQLException e)
			{
				System.out.print(e.getMessage());
			}
			return combo;
		}
		
		
}
