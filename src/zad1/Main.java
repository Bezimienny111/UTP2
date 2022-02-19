/**
 *
 *  @author Kowalski Robert S18290
 *
 */

package zad1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*<--
 *  niezbędne importy
 */
public class Main {
  public static void main(String[] args) {
    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */

	  
	  Function<String,List<String>> flines = lambdaLines -> {
		  
		  List<String> listReturned = null;
		  Charset usethis = Charset.forName("UTF-8");
		  Path linesPath = Paths.get((String) lambdaLines);
		  
		  try {
			listReturned = Files.readAllLines(linesPath, usethis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		 return listReturned;  
	  };
	  
	 Function<List<String>,String> join = lambdajoin -> {
		 String exit;
		 StringBuilder testing = new StringBuilder();
		 for(String whatever: (List<String>)lambdajoin )
			 testing.append(whatever);
		 return exit = testing.toString();
		 
	 };
	  
	 Function<String,List<Integer>> collectInts = lambdaCollectInts -> {
		ArrayList<Integer> exitNumbers = new ArrayList<Integer>();
		String patterning = "\\d+";
		Pattern pattern = Pattern.compile(patterning);
		Matcher matcher = pattern.matcher(lambdaCollectInts);
		 while (matcher.find()==true) {
			 String matched = matcher.group();
			 int adder = Integer.valueOf(matched);
			 exitNumbers.add(adder);
			 
		 }
			return exitNumbers;
	 };
	  
	 Function<List<Integer>,Integer> sum = lambdaSumints->{
		 int sumintssum = 0;
		 for (int i = 0; i<=lambdaSumints.size()-1;i++ )
			 sumintssum = (sumintssum+lambdaSumints.get(i));
	  return sumintssum;
	 };
	  
	  
	  
	  String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
	  InputConverter<String> fileConv = new InputConverter<>(fname);
	  List<String> lines = fileConv.convertBy(flines);
	  String text = fileConv.convertBy(flines, join);
	  List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
	  Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

	  System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);
    
    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
