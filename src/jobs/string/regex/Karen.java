package jobs.string.regex;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Karen {

	public static String regexV = "(\\w+\\s\\w+(\\s|\\.?|\\,?))(.+);(\\w+);(\\w+)";
	public static Map<String, List<String>> m = new HashMap<>();

	public static void main(String[] args) {

		String fileName = "C://Dados//Joabe.csv";

		try (Stream<String> stream = Files.lines(Paths.get(fileName), Charset.defaultCharset())) {
			stream.forEach(Karen::lal);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(m.get("HUGHES TELECOMUNICACOES"));
		System.out.println(m);
		System.out.println(m.size());

	}

	public static void lal(String a) {
		Pattern pattern = Pattern.compile(regexV);
		Matcher matcher = pattern.matcher(a.toUpperCase());
		// System.out.println(a.toUpperCase());
		while (matcher.find()) {
			List<String> l = m.get(matcher.group(1));
			List<String> aux = new ArrayList<>();
			// String [] aaa = ;

			if (l == null) {
				aux.add(matcher.group(4));
				m.put(matcher.group(1).trim(), aux);
			} else {
				l.add(matcher.group(4));
				m.put(matcher.group(1).trim(), l);
			}

		}

	}

}
