package jobs.os.ping;
import java.io.IOException;
import java.net.UnknownHostException;

public class Ping {
	public static final int ARR_ESTACAO = 0;
	public static final int ARR_CLP1 = 1;
	public static final int ARR_CLP2 = 2;
	public static final int ARR_GTW = 3;
	public static final int ARR_CLP1_ESTADO = 4;
	public static final int ARR_CLP2_ESTADO = 5;
	public static final int ARR_GTW_ESTADO = 6;
	public static String[][] IPS = { { "POR", "10.22.0.1", "10.22.0.2", "10.22.0.254", "-", "-", "-" },
			{ "WLU", "10.22.6.1", "10.22.6.2", "10.22.6.254", "-", "-", "-" },
			{ "BCA", "10.22.8.1", "10.22.8.2", "10.22.8.254", "-", "-", "-" },
			{ "NSL", "10.22.10.1", "10.22.10.2", "10.22.10.254", "-", "-", "-" },
			{ "JMO", "10.22.13.1", "10.22.13.2", "10.22.13.254", "-", "-", "-" },
			{ "AEM", "10.22.15.1", "10.22.15.2", "10.22.15.254", "-", "-", "-" },
			{ "MMO", "10.22.17.1", "10.22.17.2", "10.22.17.254", "-", "-", "-" },
			{ "BAR", "10.22.18.1", "10.22.18.2", "10.22.18.254", "-", "-", "-" },

	};
	public static final int MILIS = 100;
	public static final int REFRESH_RATE = 500;

	public Ping() {
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Thread(new Monitor()).start();
		try {
			for (;;) {
				testIp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testIp() throws UnknownHostException, IOException, InterruptedException {
		for (int i = 0; i < IPS.length; i++) {
			new Test().setMilis(100).setIndex(i).setARR_IP(1).setARR_ESTADO(4).start();
			new Test().setMilis(100).setIndex(i).setARR_IP(2).setARR_ESTADO(5).start();
			new Test().setMilis(100).setIndex(i).setARR_IP(3).setARR_ESTADO(6).start();

			Thread.sleep(100L);
		}
	}

	static void print() throws IOException, InterruptedException {
		for (;;) {
			StringBuffer sb = new StringBuffer();

			sb.append("Iniciando teste de comunicação para 100 milisegundos...\n\n");
			sb.append("Estação \t IP1 \t\t IP2 \t\t GTW \t\t| CLP1\t| CLP2\t| GTW\t| \n");
			sb.append("-----------------------------------------------------------------------------------------\n");

			for (int i = 0; i < IPS.length; i++) {
				sb.append(IPS[i][0] + "\t\t");

				sb.append(IPS[i][1]).append("\t");
				sb.append(IPS[i][2]).append("\t");
				sb.append(IPS[i][3]).append("\t| ");

				sb.append(IPS[i][4] + "\t| ");
				sb.append(IPS[i][5] + "\t| ");
				sb.append(IPS[i][6] + "\t| ");

				sb.append("\n");
			}

			sb.append("\nPressione Ctrl + C para encerrar...");

			new ProcessBuilder(new String[] { "cmd", "/c", "cls" }).inheritIO().start().waitFor();

			System.out.println(sb);

			Thread.sleep(500L);
		}
	}
}
