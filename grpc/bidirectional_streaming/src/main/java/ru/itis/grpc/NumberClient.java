package ru.itis.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ru.itis.grpc.generated.Number;
import ru.itis.grpc.generated.NumberServiceGrpc;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class NumberClient {

    final String ipAddress = "localhost";
    int port = 3301;

    public static void main(String[] args) {
        System.out.println("client started");
        NumberClient client = new NumberClient();
        client.run();
    }

    private void run() {
        System.out.println("creating client with port: " + port + ", ip: " + ipAddress);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ipAddress, port)
                .usePlaintext()
                .build();
        
        findMax(channel);
        
        System.out.println("client shutdown");
        channel.shutdown();
    }

    private void findMax(ManagedChannel channel) {
        NumberServiceGrpc.NumberServiceStub asyncStub = NumberServiceGrpc.newStub(channel);
        CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<Number> requestObserver = asyncStub.max(new StreamObserver<Number>() {
            @Override
            public void onNext(Number greetEveryoneResponse) {
                System.out.println("Got message from server: " + greetEveryoneResponse.getValue());
            }

            @Override
            public void onError(Throwable throwable) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished finding max");
                finishLatch.countDown();
            }
        });

        Arrays.asList(10, 5, 70, 30, 55).forEach(
                value -> {
                    System.out.println("Sending " + value);
                    requestObserver.onNext(Number.newBuilder()
                            .setValue(value)
                            .build());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        requestObserver.onCompleted();

        try {
            finishLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
