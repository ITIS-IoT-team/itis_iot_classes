package ru.itis.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: max_search.proto")
public final class NumberServiceGrpc {

  private NumberServiceGrpc() {}

  public static final String SERVICE_NAME = "NumberService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Number,
          Number> getMaxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Max",
      requestType = Number.class,
      responseType = Number.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<Number,
          Number> getMaxMethod() {
    io.grpc.MethodDescriptor<Number, Number> getMaxMethod;
    if ((getMaxMethod = NumberServiceGrpc.getMaxMethod) == null) {
      synchronized (NumberServiceGrpc.class) {
        if ((getMaxMethod = NumberServiceGrpc.getMaxMethod) == null) {
          NumberServiceGrpc.getMaxMethod = getMaxMethod =
              io.grpc.MethodDescriptor.<Number, Number>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Max"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Number.getDefaultInstance()))
              .setSchemaDescriptor(new NumberServiceMethodDescriptorSupplier("Max"))
              .build();
        }
      }
    }
    return getMaxMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NumberServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NumberServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NumberServiceStub>() {
        @java.lang.Override
        public NumberServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NumberServiceStub(channel, callOptions);
        }
      };
    return NumberServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NumberServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NumberServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NumberServiceBlockingStub>() {
        @java.lang.Override
        public NumberServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NumberServiceBlockingStub(channel, callOptions);
        }
      };
    return NumberServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NumberServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NumberServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NumberServiceFutureStub>() {
        @java.lang.Override
        public NumberServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NumberServiceFutureStub(channel, callOptions);
        }
      };
    return NumberServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NumberServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<Number> max(
        io.grpc.stub.StreamObserver<Number> responseObserver) {
      return asyncUnimplementedStreamingCall(getMaxMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMaxMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                      Number,
                      Number>(
                  this, METHODID_MAX)))
          .build();
    }
  }

  /**
   */
  public static final class NumberServiceStub extends io.grpc.stub.AbstractAsyncStub<NumberServiceStub> {
    private NumberServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NumberServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Number> max(
        io.grpc.stub.StreamObserver<Number> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMaxMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class NumberServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NumberServiceBlockingStub> {
    private NumberServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NumberServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class NumberServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NumberServiceFutureStub> {
    private NumberServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NumberServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NumberServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MAX = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NumberServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NumberServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.max(
              (io.grpc.stub.StreamObserver<Number>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NumberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NumberServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MaxSearch.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NumberService");
    }
  }

  private static final class NumberServiceFileDescriptorSupplier
      extends NumberServiceBaseDescriptorSupplier {
    NumberServiceFileDescriptorSupplier() {}
  }

  private static final class NumberServiceMethodDescriptorSupplier
      extends NumberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NumberServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NumberServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NumberServiceFileDescriptorSupplier())
              .addMethod(getMaxMethod())
              .build();
        }
      }
    }
    return result;
  }
}
