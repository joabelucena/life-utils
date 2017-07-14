package jobs.string.regex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PogMain {

	public static void main(String[] args) {
		String s = "BAR.C01.Digitais.CmdLigaLoc.Value or BAR.C01.Digitais.CmdDesLoc.Value or (BAR.C01.Digitais.MolaCarr.Value=0) or (BAR.C01.Digitais.SupBob1.Value=0) or (BAR.C01.Digitais.SupBob2.Value=0) or BAR.C01.Digitais.ResetBlqBot.Value";
		String regex ="((BAR)(.+?))(.Value(=\\d)?)";
		
		System.out.println(s.replaceAll(regex, "IIF($1.Quality < 192, 0, $0)"));
		System.out.println(s);
		
	}
	
	
	

	public static List<String> getMatches(String regex, String data, int group) {
		List<String> s = new ArrayList<>();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);

		while (matcher.find())
			s.add(matcher.group(group));

		return s;
	}

}
