package org.ofbiz.ignite.container;

import static org.apache.ignite.IgniteState.STOPPED;
import static org.apache.ignite.IgniteState.STOPPED_ON_SEGMENTATION;

import java.net.URL;
import java.util.concurrent.CountDownLatch;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteState;
import org.apache.ignite.Ignition;
import org.apache.ignite.IgnitionListener;
import org.apache.ignite.internal.util.typedef.F;
import org.apache.ignite.internal.util.typedef.G;
import org.ofbiz.base.container.Container;
import org.ofbiz.base.container.ContainerConfig;
import org.ofbiz.base.container.ContainerException;
import org.ofbiz.base.util.Debug;
import org.ofbiz.base.util.UtilURL;

public class IgniteClientContainer implements Container {
	public static final String module = IgniteClientContainer.class.getName();
	private static Ignite ignite;
	private String igniteConfig;
	private String name;

	@Override
	public void init(String[] args, String name, String configFile) throws ContainerException {
		this.name = name;
		// get the container config
		ContainerConfig.Container cc = ContainerConfig.getContainer(name, configFile);
		if (cc == null) {
			throw new ContainerException("No catalina-container configuration found in container config!");
		}
		this.igniteConfig = ContainerConfig.getPropertyValue(cc, "igniteConfig", "ignite-cache.xml");
	}

	@Override
	public boolean start() throws ContainerException {
		Debug.logInfo("Ignite client Container start...", module);
		Thread t = new Handle(igniteConfig);
		t.start();
		return false;
	}

	@Override
	public void stop() throws ContainerException {
		Debug.logInfo("Ignite client Container stop...", module);
		Ignition.stopAll(false);
	}

	@Override
	public String getName() {
		 return name;
	}

	public static Ignite getIgnite(){
		return ignite;
	}
	class Handle extends Thread {

		private String igniteConfig;

		public Handle(String igniteConfig) {
			this.igniteConfig = igniteConfig;
		}

		@Override
		public void run() {
			URL u = UtilURL.fromResource(this.igniteConfig);
			try {
				ignite = Ignition.start(u.openStream());

				// Exit latch for the grid loaded from the command line.
				final CountDownLatch latch = new CountDownLatch(1);

				G.addListener(new IgnitionListener() {
					@Override
					public void onStateChange(String name, IgniteState state) {
						// Skip all grids except loaded from the command line.
						if (!F.eq(ignite.name(), name))
							return;

						if (state == STOPPED || state == STOPPED_ON_SEGMENTATION)
							latch.countDown();
					}
				});
				try {
					latch.await();
				} catch (InterruptedException e) {
					Debug.logError("Start was interrupted (exiting): " + e.getMessage(), module);
				}
			} catch (Exception e) {
				Debug.logError(e, module);
			}

		}
	}
}
