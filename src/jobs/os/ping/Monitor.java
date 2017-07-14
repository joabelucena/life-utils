package jobs.os.ping;
class Monitor implements Runnable {
	Monitor() {
	}

	public void run() {
		try {
			Ping.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
