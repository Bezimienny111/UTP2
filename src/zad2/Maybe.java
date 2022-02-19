package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

	private T me;
	private T ki;
	
	public Maybe() {
		super();
	}
	
	
	public Maybe(T ha) {
		super();
		this.me = ha;
	}
	
	public static <T> Maybe<T> of(T whatever) {
		Maybe<T> made = new Maybe<T>(whatever);
		return made;
	}
	
	
	public void ifPresent(Consumer<T> cons) {
		if (me != ki)
			cons.accept((T) me);	
	}
	
	public <ME> Maybe<ME> map(Function<T, ME> func) {
			if(me!=ki) {
				ME returning = func.apply(me);
			return new Maybe<ME>(returning);
			}
			return new Maybe<ME>();
			
	}
	
	public T get() {
		if(me==ki) 
			throw new NoSuchElementException(" maybe is empty");
		return me;
		
	}
		
	
	public boolean isPresent() {
		if(me!=ki)
			return true;
		return false;
	}
	
	public T orElse(T defVal) {
		if (isPresent())
			return me;
		return defVal;
	}
	
	public Maybe<T> filter(Predicate<T> pred) {
		if(!pred.test(me))
		return new Maybe<T>();
		return this;
		
	}
	
	
	public String toString() {
		
		if (me != ki)
		return "Maybe has value " + me;
		return "Maybe is emtpy "; 
	}
	
}
