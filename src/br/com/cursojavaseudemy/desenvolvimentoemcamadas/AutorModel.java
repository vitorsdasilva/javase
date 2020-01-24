
package br.com.cursojavaseudemy.desenvolvimentoemcamadas;

/**
 *
 * @author Vitor
 */


//modelo abstrato de um entidade que será armazenada na tabela Autor do nosso banco de dados
public class AutorModel {
    
    private int codigo;
    private String nome;
    private String estado;

    
    public AutorModel(int codigo,String nome, String estado){
        this.codigo=codigo;
        this.nome=nome;
        this.estado=estado;
    }
    
    public AutorModel(){
       
    }
 
 
    public int getCodigo() {
        return codigo;
    }

   
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

 
    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
