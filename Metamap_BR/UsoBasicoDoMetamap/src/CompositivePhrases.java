import java.util.List;

import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;

public class CompositivePhrases {
	public static void main(String[] args) throws Exception{
		//No iterativo por padrão o compositive phrases é 4
		//no programa java se nada for dito é zero
		//Como quero comparar com o iterativo seto o valor para 4
		
		MetaMapApi api = new MetaMapApiImpl();
		api.setOptions("-Q 4");
		//System.out.println(api.getOptions());
	    List<Result> resultList = api.processCitationsFromString("Don't forget to get a diabetes screening ");
	    for(Result r : resultList){
	    	for(Utterance ut : r.getUtteranceList()){
	    		
	    		for(PCM pcm: ut.getPCMList()){
	    		
	    			System.out.println("Phrase:" + pcm.getPhrase().getPhraseText());
	    			int cont=1;
	    			if(pcm.getMappingList().size() == 0){
	    				System.out.println("Não foi mapeado");
	    			}
	    			for(Mapping m :pcm.getMappingList()){
	    				
	    				
	    				System.out.println("MAPEAMENTO " + cont);
	    				for(Ev v : m.getEvList()){
	    					
	    					
	    					System.out.println("[Score]" +  v.getScore() + " [ID] "+v.getConceptId() +" [Conceito] " + v.getConceptName() +" [Preferido] "+ v.getPreferredName());
	    					//System.out.println("[Semantico] "+v.getSemanticTypes() +" [Source] " + v.getSources() );
	    					
	    					System.out.println();
	    				}
	    				cont++;
	    			}
	    			System.out.println("------------------------------------");
    				
	    			
	    		}
	    	}
	    }
	    
	    
	}

}
