package jobs.string.regex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	public static List<String> getMatches(String regex, String data, int group) {
		List<String> s = new ArrayList<>();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);

		while (matcher.find())
			s.add(matcher.group(group));

		return s;
	}

}
