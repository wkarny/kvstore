package io.grpc.examples;

import io.grpc.examples.proto.HelloRequest;
import io.grpc.examples.proto.HelloResponse;
import io.grpc.examples.proto.KeyValueServiceGrpc.KeyValueServiceImplBase;
import io.grpc.stub.StreamObserver;


/**
 * This is the actual server logic.  It includes a basic key value store, as well as implements
 * thread safe methods for creating, retrieving, updating, and deleting values.  (These are
 * commonly known as "CRUD" operations.)
 */
final class KvService extends KeyValueServiceImplBase {


  @Override
  public synchronized void sayHello(
      HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    //String name = request.getName();
    HelloResponse hr = HelloResponse.newBuilder().setName("Hello ").build();
    responseObserver.onNext(hr);
    responseObserver.onCompleted();
    return;
  }

}
