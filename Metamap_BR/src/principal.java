import java.util.ArrayList;
import java.util.List;

import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.Mapping;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;

public class Principal {

	/*Um texto grande como entrada e mostrar no terminal as entidade nomeadas da area de saúde
	Mostrar exemplos medicos do twitter search
	Mostrar entidades nomeadas(possivelmente o nome conceitual ou preferido)
	Mostra a classe ligada a entidade nomeada (possivelmente o grupo semantico)
	E verificar se faz a analise sintatic
	Evitar mostrar acronimos
	Olha o javadoc com cuidado
	*/
	public static void main(String[] args) throws Exception{
		
		MetaMapApi api = new MetaMapApiImpl();
		//api.setOptions("-c");
		List<Result> resultList = api.processCitationsFromString("Had infusions of both Actemra & Rituxan and not only had strange side effects during 2nd Rituxan infusion but i died.");
	    
	    //System.out.println(resultList);
	    //System.out.println(api.getOptions());   
	    for(Result r : resultList){
	    	//System.out.println("Lista de Abreviações : "+r.getAcronymsAbbrevs());
	    	//System.out.println("Lista de Negações : "+r.getNegationList().get(0));
	    	for(Utterance ut : r.getUtteranceList()){
	    		
	    		for(PCM pcm: ut.getPCMList()){
	    			//ESTUDAR COMPOSITE PHRASE
	    		
	    			System.out.println("Phrase:" + pcm.getPhrase().getPhraseText());
	    			int cont=1;
	    			if(pcm.getMappingList().size() == 0){
	    				System.out.println("Não foi mapeado");
	    			}
	    			for(Mapping m :pcm.getMappingList()){
	    				
	    				
	    				System.out.println("MAPEAMENTO " + cont);
	    				for(Ev v : m.getEvList()){
	    					
	    					System.out.println("[Score]" +  v.getScore());
	    					System.out.println("[ID] "+v.getConceptId() +" [Conceito] " + v.getConceptName() +" [Preferido] "+ v.getPreferredName());
	    					System.out.println("[Grupos Semanticos] "+v.getSemanticTypes());
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
