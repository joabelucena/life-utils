package jobs.string.regex;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReplaceFromFile {

	/*
	 * ((BAR)(?=[^\s=]*=)([^\s=]*\.)(Value=\d+))
	 * ((bar\.)(([^\s]*?)(SupBob1|SupBob2|MolaCarr)([^\s]*?))(\.value=\d+))
	 * Value: ((bar)([^\s]*?)(value=\d+))
	 * 
	 * Regex:
	 * Match all (Value or Value=0): ((BAR\.)(.+?))(.Value(=\d)?)
	 * 
	 * Match only Value=0)
	 * 1) ((bar\.)([^\s]*?)(\.value=\d+)) (General, Slower)
	 * 2) ((bar\.)(([^\s]*?)(SupBob1|SupBob2|MolaCarr)([^\s]*?))(\.value=\d+)) (Restricts Specific Alarms)
	 * 3) ((BAR)(?=[^\s=]*=)([^\s=]*\.)(Value=\d+)) (General, Quicker)
	 */
	public static String regexV = "((BAR\\.)(.+?))(.Value(=\\d)?)";

	public static String SourceFileName = "C://Dados//BAR.csv";
	public static String DestinationFileName = "C://Dados//BAR_out.csv";

	public static void main(String[] args) throws IOException {

		try (Stream<String> stream = Files.lines(Paths.get(SourceFileName), Charset.defaultCharset());
				BufferedWriter writer = Files.newBufferedWriter(Paths.get(DestinationFileName))) {

			stream.forEach(a -> {
				try {
					String rpl = a;
					
					System.out.println(a);
					
					writer.write(a.replaceAll(regexV, "IIF($1.Quality < 192, 0, $0)"));
					writer.newLine();
//					System.out.println(a.replaceAll(regexV, "IIF($1.Quality < 192, 0, $0)"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
