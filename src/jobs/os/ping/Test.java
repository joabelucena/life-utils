package jobs.os.ping;
import java.net.InetAddress;

class Test extends Thread {
	public int index;
	public int milis;
	public int ARR_IP;
	public int ARR_ESTADO;

	Test() {
	}

	public void run() {
		try {
			Ping.IPS[index][ARR_ESTADO] = (InetAddress.getByName(Ping.IPS[index][ARR_IP]).isReachable(milis) ? "OK"
					: "NOK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getIndex() {
		return index;
	}

	public Test setIndex(int index) {
		this.index = index;
		return this;
	}

	public int getMilis() {
		return milis;
	}

	public Test setMilis(int milis) {
		this.milis = milis;
		return this;
	}

	public int getARR_IP() {
		return ARR_IP;
	}

	public Test setARR_IP(int aRR_IP) {
		ARR_IP = aRR_IP;
		return this;
	}

	public int getARR_ESTADO() {
		return ARR_ESTADO;
	}

	public Test setARR_ESTADO(int aRR_ESTADO) {
		ARR_ESTADO = aRR_ESTADO;
		return this;
	}
}