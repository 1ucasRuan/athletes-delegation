/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlar;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import projeto_delegacao.Atleta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Controla_atleta {
    
    //private ArrayList<Atleta> atletas = new ArrayList<>();
    
    ArrayList<Atleta> atletas = new ArrayList<>();
    ObjectOutputStream file ;
    ObjectInputStream objLeitura ;
    FileInputStream arquivoLeitura;
  
    public void gravarDados(){
        try{
            file = new ObjectOutputStream(new FileOutputStream("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\projeto_delegacao\\Delegacao.dat"));
        for(int i = 0; i < atletas.size(); i++){
            file.writeObject(atletas.get(i));
        }
        JOptionPane.showMessageDialog(null, "Dados salvo com sucesso!");
        } catch (IOException e) {
        System.out.println(e);
        }        
    }
    public void recuperarDados(){
        
        try{
            boolean exists = (new File("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\projeto_delegacao\\Delegacao.dat")).exists();
            if(!exists){
                file = new ObjectOutputStream(new FileOutputStream("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\projeto_delegacao\\Delegacao.dat"));              
            }else{                
                arquivoLeitura = new FileInputStream("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\projeto_delegacao\\Delegacao.dat");
                objLeitura = new ObjectInputStream(arquivoLeitura);
                Object obj;
                while((obj = objLeitura.readObject())!=null){                  
                    if(obj instanceof Atleta n){
                        atletas.add(n);
                    }
                }                
            }
        }catch(EOFException e){
            System.out.println(e);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controla_atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");							
	}else{
            JOptionPane.showMessageDialog(null, "Dados RECUPERADOS com sucesso!");
	}
    }
    
    public ArrayList<Atleta> listarTodos(){
        //recuperarDados();
        if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");							
	}else{
            JOptionPane.showMessageDialog(null, "Dados encontrados!");
	}
        return atletas;
    }        
        
    public boolean salvarAtleta(Atleta n) {        
        if(n != null){
            atletas.add(n);
            return true;
        }else{
            return false;
        }     
    }
    
    public void limparAtletas(){
        if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entre com atletas primeiramente");					
	}else{
            atletas.clear();
            JOptionPane.showMessageDialog(null, "Dados LIMPOS com sucesso!");
        }	
    }
    
    public String numeroCadastrados(){
        return atletas.size() + "";
    }
   
    /*public void printar(){
        
	String dados = "";
	for (int i = 0; i < atletas.size(); i++) {
            dados += atletas.get(i).toString() + "\n";
        }
	if (atletas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entre com atletas primeiramente");				
	}else{
            JOptionPane.showMessageDialog(null, dados);
        }
        
    }*/
}
