package io.grpc.examples;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.capnproto
//import io.grpc.test.Cap.CapData;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;




/**
 * Starts up a server and some clients, does some key value store operations, and then measures
 * how many operations were completed.
 */
public final class KvRunner {
  private static final Logger logger = Logger.getLogger(KvRunner.class.getName());
  

  private static final long DURATION_SECONDS = 60;

  private Server server;
  private ManagedChannel channel;
  KvRunner() throws Exception{
	  FileHandler handler = new FileHandler("kv_default.log", true);
	  logger.addHandler(handler);
  }
  public static void main(String []args) throws Exception {
	 //CapData.Builder cb;
	for(int i = 1; i < 1000000; i*=10){
	    KvRunner store = new KvRunner();
	    store.startServer();
	    try {
	    	store.runClient(i);
	    } finally {
	      store.stopServer();
	    }
	}
  }

  private void runClient(int payload) throws InterruptedException, IOException {
    if (channel != null) {
      throw new IllegalStateException("Already started");
    }
    channel = ManagedChannelBuilder.forTarget("dns:///localhost:" + server.getPort())
        .usePlaintext(true)
        .build();
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    try {
      AtomicBoolean done = new AtomicBoolean();
      KvClient client = new KvClient(channel);
      logger.info("Starting");
      scheduler.schedule(() -> done.set(true), DURATION_SECONDS, TimeUnit.SECONDS);
      client.doClientWork(done, payload);
      double qps = (double) client.getRpcCount() / DURATION_SECONDS;
      logger.log(Level.INFO,"Hello");
      logger.log(Level.INFO, "Did {0} RPCs/s", new Object[]{qps});
    } finally {
      scheduler.shutdownNow();
      channel.shutdownNow();
    }
  }

  private void startServer() throws IOException {
    if (server != null) {
      throw new IllegalStateException("Already started");
    }
    server = ServerBuilder.forPort(0).addService(new KvService()).build();
    server.start();
  }

  private void stopServer() throws InterruptedException {
    Server s = server;
    if (s == null) {
      throw new IllegalStateException("Already stopped");
    }
    server = null;
    s.shutdown();
    if (s.awaitTermination(1, TimeUnit.SECONDS)) {
      return;
    }
    s.shutdownNow();
    if (s.awaitTermination(1, TimeUnit.SECONDS)) {
      return;
    }
    throw new RuntimeException("Unable to shutdown server");
  }
}
