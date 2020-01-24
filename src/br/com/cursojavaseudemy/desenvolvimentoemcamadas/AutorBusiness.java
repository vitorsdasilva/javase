
package br.com.cursojavaseudemy.desenvolvimentoemcamadas;

/**
 *
 * @author e333832
 */
public class AutorBusiness {
    
    AutorDAO objAutorDAO;
    
    public AutorBusiness(){
        objAutorDAO = new AutorDAO();
    }
    
    /*
        validarDados verifica se o usuario preecheu todos os campos nao nulos.
    */
    
    private void validarDados(AutorModel objAutorModel) throws Exception{
        
        if(objAutorModel.getNome()==null || objAutorModel.getNome().equals("")){
           throw new Exception ("O campo nome e obrigatorio");
        }
    }
    
    public void adicionarAutor(AutorModel objAutorModel) throws Exception{
        validarDados(objAutorModel);
        objAutorDAO.adicionar(objAutorModel);
    }
    
    public void consultarAutor(AutorModel objAutorModel){
        
        //AutorModel objAutorModel2= new AutorModel();
        //objAutorModel = 
        objAutorDAO.consultar(objAutorModel);
        
        // FUNCIONANDO ATÉ AQUI!
        System.out.println("Passando na Model, nomeObj:" + objAutorModel.getNome());
       
        
       
        
    }
    
}
