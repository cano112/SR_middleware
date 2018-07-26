package pl.edu.agh.wiet.sr.banking.generated;

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
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: currency_service.proto")
public final class CurrencyServiceGrpc {

  private CurrencyServiceGrpc() {}

  public static final String SERVICE_NAME = "CurrencyService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCurrencyRateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest,
      pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> METHOD_GET_CURRENCY_RATE = getGetCurrencyRateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest,
      pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> getGetCurrencyRateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest,
      pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> getGetCurrencyRateMethod() {
    return getGetCurrencyRateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest,
      pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> getGetCurrencyRateMethodHelper() {
    io.grpc.MethodDescriptor<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest, pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> getGetCurrencyRateMethod;
    if ((getGetCurrencyRateMethod = CurrencyServiceGrpc.getGetCurrencyRateMethod) == null) {
      synchronized (CurrencyServiceGrpc.class) {
        if ((getGetCurrencyRateMethod = CurrencyServiceGrpc.getGetCurrencyRateMethod) == null) {
          CurrencyServiceGrpc.getGetCurrencyRateMethod = getGetCurrencyRateMethod = 
              io.grpc.MethodDescriptor.<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest, pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CurrencyService", "GetCurrencyRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrencyServiceMethodDescriptorSupplier("GetCurrencyRate"))
                  .build();
          }
        }
     }
     return getGetCurrencyRateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrencyServiceStub newStub(io.grpc.Channel channel) {
    return new CurrencyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrencyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurrencyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrencyServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrencyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrencyRate(pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest request,
        io.grpc.stub.StreamObserver<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrencyRateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrencyRateMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest,
                pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate>(
                  this, METHODID_GET_CURRENCY_RATE)))
          .build();
    }
  }

  /**
   */
  public static final class CurrencyServiceStub extends io.grpc.stub.AbstractStub<CurrencyServiceStub> {
    private CurrencyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrencyRate(pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest request,
        io.grpc.stub.StreamObserver<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCurrencyRateMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CurrencyServiceBlockingStub extends io.grpc.stub.AbstractStub<CurrencyServiceBlockingStub> {
    private CurrencyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate> getCurrencyRate(
        pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCurrencyRateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CurrencyServiceFutureStub extends io.grpc.stub.AbstractStub<CurrencyServiceFutureStub> {
    private CurrencyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_CURRENCY_RATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrencyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrencyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENCY_RATE:
          serviceImpl.getCurrencyRate((pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.CurrencyRequest) request,
              (io.grpc.stub.StreamObserver<pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.Rate>) responseObserver);
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

  private static abstract class CurrencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurrencyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pl.edu.agh.wiet.sr.banking.generated.CurrencyServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurrencyService");
    }
  }

  private static final class CurrencyServiceFileDescriptorSupplier
      extends CurrencyServiceBaseDescriptorSupplier {
    CurrencyServiceFileDescriptorSupplier() {}
  }

  private static final class CurrencyServiceMethodDescriptorSupplier
      extends CurrencyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurrencyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CurrencyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrencyServiceFileDescriptorSupplier())
              .addMethod(getGetCurrencyRateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
