package multi.thread.entity.persiter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jbaba
 *
 */
public class Persister {

	@SuppressWarnings("rawtypes")
	List entity = new ArrayList<>();
	
	public Persister() {
	}

	@SuppressWarnings("unchecked")
	public void add(Object obj){
		entity.add(obj);
	}
	
	public void insert(){
		
	}
	
}
