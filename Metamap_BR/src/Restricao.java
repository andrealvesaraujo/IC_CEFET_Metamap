import java.util.List;

import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;
//Verificar negações
//Ve essa ligação nos vocabularios Concept Relations 
public class Restricao {
	public static void main(String[] args) throws Exception{
		MetaMapApi api = new MetaMapApiImpl();
		
		
		
		//api.setOptions("-k qnco");
		//Tem que pertencer a esse tipo semantico
		//api.setOptions("-J sosy");
		//Exclui esse vocabulario do mapeamento 
		//api.setOptions("-e COSTAR");
		//Restringir vocabulario
		//api.setOptions("-R NCI,MTH");
		//Faz os dois
		//api.setOptions("-J sosy -R NCI,MTH");
		
		List<Result> resultList = api.processCitationsFromString("Flu headache is the worst! No pain killer worked!");
	    
	    //System.out.println(api.getOptions());   
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
	    					
	    					System.out.println("[Score]" + v.getScore());
	    					System.out.println("[ID] "+v.getConceptId() + " [Nome do conceito] " + v.getConceptName() +" [String UMLS] "+ v.getPreferredName());
	    					System.out.println("[Tipo Semantico] "+v.getSemanticTypes());
	    					System.out.println("[Fontes] " + v.getSources());
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
