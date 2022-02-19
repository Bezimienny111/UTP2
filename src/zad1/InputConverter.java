package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;



public class InputConverter<KA> {
	
	private KA Me;
	private List Kai;
	
	
	public InputConverter(KA ha){
		this.Me = ha;
		
	}
	
		public <KA,M> M convertBy(Function... in) {
			Kai = new ArrayList();
			
			
			if (in.length == 1) 
				Kai.add(in[0].apply(Me));
			else {
				Kai.add(in[0].apply(Me));
				for (int i=1; i<=(in.length-1);i++) {
					Kai.add(in[i].apply(Kai.get(i-1)));
		}
			}	
				
		return (M) Kai.get(Kai.size()-1);
	}

}
