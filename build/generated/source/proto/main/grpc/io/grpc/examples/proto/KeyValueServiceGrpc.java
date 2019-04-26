package io.grpc.examples.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: kvstore.proto")
public final class KeyValueServiceGrpc {

  private KeyValueServiceGrpc() {}

  public static final String SERVICE_NAME = "io.grpc.KeyValueService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSayHelloMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.proto.HelloRequest,
      io.grpc.examples.proto.HelloResponse> METHOD_SAY_HELLO = getSayHelloMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.proto.HelloRequest,
      io.grpc.examples.proto.HelloResponse> getSayHelloMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.proto.HelloRequest,
      io.grpc.examples.proto.HelloResponse> getSayHelloMethod() {
    return getSayHelloMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.proto.HelloRequest,
      io.grpc.examples.proto.HelloResponse> getSayHelloMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.proto.HelloRequest, io.grpc.examples.proto.HelloResponse> getSayHelloMethod;
    if ((getSayHelloMethod = KeyValueServiceGrpc.getSayHelloMethod) == null) {
      synchronized (KeyValueServiceGrpc.class) {
        if ((getSayHelloMethod = KeyValueServiceGrpc.getSayHelloMethod) == null) {
          KeyValueServiceGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.proto.HelloRequest, io.grpc.examples.proto.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "io.grpc.KeyValueService", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.proto.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.proto.HelloResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new KeyValueServiceMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KeyValueServiceStub newStub(io.grpc.Channel channel) {
    return new KeyValueServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyValueServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new KeyValueServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KeyValueServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new KeyValueServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class KeyValueServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(io.grpc.examples.proto.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.proto.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.proto.HelloRequest,
                io.grpc.examples.proto.HelloResponse>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class KeyValueServiceStub extends io.grpc.stub.AbstractStub<KeyValueServiceStub> {
    private KeyValueServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(io.grpc.examples.proto.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.proto.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KeyValueServiceBlockingStub extends io.grpc.stub.AbstractStub<KeyValueServiceBlockingStub> {
    private KeyValueServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.proto.HelloResponse sayHello(io.grpc.examples.proto.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KeyValueServiceFutureStub extends io.grpc.stub.AbstractStub<KeyValueServiceFutureStub> {
    private KeyValueServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyValueServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KeyValueServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.proto.HelloResponse> sayHello(
        io.grpc.examples.proto.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KeyValueServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KeyValueServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((io.grpc.examples.proto.HelloRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.proto.HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class KeyValueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyValueServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.proto.KeyValues.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyValueService");
    }
  }

  private static final class KeyValueServiceFileDescriptorSupplier
      extends KeyValueServiceBaseDescriptorSupplier {
    KeyValueServiceFileDescriptorSupplier() {}
  }

  private static final class KeyValueServiceMethodDescriptorSupplier
      extends KeyValueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KeyValueServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (KeyValueServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KeyValueServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
