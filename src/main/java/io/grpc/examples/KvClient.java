package io.grpc.examples;

import com.google.protobuf.ByteString;
import io.grpc.Channel;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.proto.HelloRequest;
import io.grpc.examples.proto.HelloResponse;
import io.grpc.examples.proto.KeyValueServiceGrpc;
import io.grpc.examples.proto.KeyValueServiceGrpc.KeyValueServiceBlockingStub;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Performs sample work load, by creating random keys and values, retrieving them, updating them,
 * and deleting them.  A real program would actually use the values, and they wouldn't be random.
 */
final class KvClient {
  private static final Logger logger = Logger.getLogger(KvClient.class.getName());

  private final int MEAN_KEY_SIZE = 64;
  private final int MEAN_VALUE_SIZE = 65536;

  private final RandomAccessSet<ByteString> knownKeys = new RandomAccessSet<>();
  private final Channel channel;

  private long rpcCount;

  KvClient(Channel channel) {
    this.channel = channel;
  }

  long getRpcCount() {
    return rpcCount;
  }

  /**
   * Does the client work until {@code done.get()} returns true.  Callers should set done to true,
   * and wait for this method to return.
   */
  void doClientWork(AtomicBoolean done, int payload) {
    Random random = new Random();
    KeyValueServiceBlockingStub stub = KeyValueServiceGrpc.newBlockingStub(channel);

    while (!done.get()) {
      // Pick a random CRUD action to take.
      int command = 0;
      if (command == 0) {
        doHello(stub, payload);
	//rpcCount++;
        continue;
      }
      
    }
  }

  /**
   * Creates a random key and value.
   */
  private void doHello(KeyValueServiceBlockingStub stub,int payload) {
    try {
      HelloRequest.Builder hr = HelloRequest.newBuilder();
      for(int i = 0; i < payload; i++)
        hr.addName("Wyes");
      HelloResponse res = stub.sayHello(hr.build());
      //logger.log(Level.INFO, ("RPC success " + res.getName()));
      rpcCount++;
    } catch (StatusRuntimeException e) {
        logger.log(Level.INFO, "RPC failed", e);
    }
  }

}
