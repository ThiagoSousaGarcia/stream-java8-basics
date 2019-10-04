import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String []args){
        List<Integer> inteiros = Arrays.asList(1, 2, 3);
        
        //Implementação tradicional
        for(Integer n: inteiros) {
           System.out.println("Tradicional: "+n);
        }
        
        //Implementação com expressões lambda e StreamAPI       
        inteiros.forEach(n-> System.out.println("Stream: "+ n));
        
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Joao", 32),
  	                                      new Pessoa("Antonio", 20),	 
                                          new Pessoa("Maria", 18),
                                          new Pessoa("Angela", 30));
        
        //Implementação Tradicional                              
    	Integer somaIdadeTradicional = 0;
    	for(Pessoa pessoa : pessoas){
    	    if(pessoa.getNome().startsWith("A")){
    	        somaIdadeTradicional = somaIdadeTradicional + pessoa.getIdade();
    	    }
    	}
    	
    	//Implementação com Stream API
        Integer somaIdadeStream = pessoas.stream().filter(p -> p.getNome().startsWith("A"))
    			.mapToInt(p -> p.getIdade()).sum();
    			
    	Double mediaIdadeStream = pessoas.stream().filter(p -> p.getNome().startsWith("A"))
    			.mapToInt(p -> p.getIdade()).average().getAsDouble();
      
       System.out.println("Soma idade tradicional "+ somaIdadeTradicional);
       System.out.println("Soma idade stream "+ somaIdadeStream);
       System.out.println("Média idade stream "+ mediaIdadeStream);
      
      //Convertendo Stream para coleções
      List<Pessoa> pessoasComecandoComA = pessoas.stream().filter(p -> p.getNome()
						  .startsWith("A"))
                          .collect(Collectors.toList());
      
      List<String> nomesPessoas = pessoas.stream()
                             .map(Pessoa::getNome)
                             .collect(Collectors.toList());
      
      pessoasComecandoComA.forEach(pA -> System.out.println("Pessoas começando com A: " +pA.getNome()));
      
      nomesPessoas.forEach(p -> System.out.println("Nomes das pessoas: "+ p));
      


    

     }

}
