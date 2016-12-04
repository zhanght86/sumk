package org.test.soa.server;

import org.I0Itec.zkclient.ZkServer;
import org.junit.Test;
import org.yx.log.Log;
import org.yx.main.Bootstrap;

public class SOAServer {

	public static void startZKServer() {
		String temp = System.getProperty("java.io.tmpdir");
		ZkServer zk = new ZkServer(temp, temp, zkClient -> {
		});
		zk.start();
	}

	@Test
	public void test() throws InterruptedException {
		startZKServer();
		try {
			System.setProperty("nohttp", "true");
			Bootstrap.main(null);
		} catch (Exception e) {
			Log.printStack(e);
		}
		Thread.currentThread().join();
	}

}
