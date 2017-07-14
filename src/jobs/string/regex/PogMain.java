package jobs.string.regex;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PogMain {
	
	public static String regexV = "((BAR\\.)(.+?))(.Value(=\\\\d)?)";

	public static void main(String[] args) {
		
		String fileName = "C://Dados//BAR.csv";

		try (Stream<String> stream = Files.lines(Paths.get(fileName),Charset.defaultCharset())) {
			stream.forEach(PogMain::lal);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void lal(String a) {
		System.out.println(a.replaceAll(regexV, "IIF($1.Quality < 192, 0, $0)"));
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
