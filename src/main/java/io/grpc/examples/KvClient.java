package io.grpc.examples;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.Random;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.capnproto.StructList;

import com.google.protobuf.ByteString;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.proto.HelloRequest;
import io.grpc.examples.proto.HelloResponse;
import io.grpc.examples.proto.KeyValueServiceGrpc;
import io.grpc.examples.proto.KeyValueServiceGrpc.KeyValueServiceBlockingStub;

import io.grpc.test.Cap.CapData;

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
 * @throws IOException 
   */
  void doClientWork(AtomicBoolean done, int payload) throws IOException {
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
 * @throws IOException 
   */
  private void doHello(KeyValueServiceBlockingStub stub,int payload) throws IOException {
    try {
      ByteArrayOutputStream os = new ByteArrayOutputStream(); 
      HelloRequest.Builder hr = HelloRequest.newBuilder();
      org.capnproto.MessageBuilder message = new org.capnproto.MessageBuilder();
      CapData.Builder cap = message.initRoot(CapData.factory);
      org.capnproto.TextList.Builder p = cap.initNum(payload);
      for(int i = 0; i < payload; i++)
    	  p.set(i, new org.capnproto.Text.Reader("Hello"));;
      org.capnproto.SerializePacked.writeToUnbuffered(Channels.newChannel(os),message);
      hr.setData(ByteString.copyFrom(os.toByteArray()));
      HelloResponse res = stub.sayHello(hr.build());
      //logger.log(Level.INFO, ("RPC success " + res.getName()));
      rpcCount++;
    } catch (StatusRuntimeException e) {
        logger.log(Level.INFO, "RPC failed", e);
    }
  }

}
