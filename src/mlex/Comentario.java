package mlex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Comentario extends FileHandler
{
	private Date data;
	private float nota;
	private String texto;
	private String path = "./etc/";
	private String absolutePath;

	public String getAbsolutePath()
	{
		return this.absolutePath;
	}
	public String getTexto() 
	{
		return this.texto;
	}

	public float getNota() 
	{
		return this.nota;
	}
	
	public Date getData() 
	{
		return this.data;
	}
	
	public String getPath() 
	{
		return this.path;
	}
	
	public Comentario(String s, int idJogo) 
	{
		this.data = new Date();
<<<<<<< HEAD
		this.nota = 0;
=======
		this.nota = -1;
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		this.texto = s;
		this.path = path + Integer.toString(idJogo) + "comentario.txt";
		this.absolutePath =  Integer.toString(idJogo) + "comentario.txt";
	}
	
	
	public Comentario(String s, int idJogo, float n) 
	{
		this.data = new Date();
		this.texto = s;
		this.nota = n;
		this.path = path + Integer.toString(idJogo) + "comentario.txt";
		this.absolutePath =  Integer.toString(idJogo) + "comentario.txt";

	}
	
	public void salvaComentario() 
	{
		
		File f = new File(this.getPath());
		
		//se arquivo nao existe
		if(!f.exists()) 
		{
			try {
				String txt = "" + this.getData();
				f.createNewFile();
	
				
				FileWriter fw = new FileWriter (f.getPath());
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(this.getTexto());
				bw.newLine();
<<<<<<< HEAD
				bw.write(Float.toString(this.getNota()));
				bw.newLine();
=======
				
				if(this.getNota() != -1) 
				{
					bw.write(Float.toString(this.getNota()));
					bw.newLine();
				}
				
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
				bw.write(txt);
				bw.newLine();
				
				bw.close();
			}
			catch(IOException e)
			{
				
			}
		}
		//se arquivo ja existe e nao eh diretorio
		else if (f.exists() && !f.isDirectory()) 
		{
			//salva comentario em fim de arquivo 
			try {
				PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter(this.getPath(),true)));
				
				out.println();
				out.println(this.getTexto());
				out.println(Double.toString(this.getNota()));
				out.println(this.getData());

				out.close();
			}
			catch(IOException e){
				
			}
		}
	}
	
	
	public void exibeComentarios() 
	{
<<<<<<< HEAD
		String fpath = this.path;
		
		try {
			BufferedReader br = new BufferedReader( new FileReader(fpath));
			String ln = null;
			while ((ln = br.readLine()) != null) {
				System.out.println(ln);
			}
			br.close();
			
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
		 String fpath = this.path;
		 File f = new File(fpath);
		 if (!(f.exists())) 
		 {
			 System.out.println("Arquivo de comentarios nao existe.");
		 }
		 else 
		 {
			try {
				BufferedReader br = new BufferedReader( new FileReader(fpath));
				String ln = null;
				while ((ln = br.readLine()) != null) {
					System.out.println(ln);
				}
				br.close();
				
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
>>>>>>> b123bcf3ffaa971e7c57fec27830b941ca79cbe3
		
	}
	
	public void removeComentarios()
	{
		File f = new File(this.path);
		if(f.delete()) {
			System.out.println("Comentarios deletados com sucesso");
		}
		else {
			System.out.println("Arquivo n�o existe");
		}
		
	}
	
	

	
	
}