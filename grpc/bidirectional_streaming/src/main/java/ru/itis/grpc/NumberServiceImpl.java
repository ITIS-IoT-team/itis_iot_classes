package ru.itis.grpc;

import io.grpc.stub.StreamObserver;
import ru.itis.grpc.generated.Number;
import ru.itis.grpc.generated.NumberServiceGrpc;

public class NumberServiceImpl extends NumberServiceGrpc.NumberServiceImplBase {

    @Override
    public StreamObserver<Number> max(StreamObserver<Number> responseObserver) {

        return new StreamObserver<Number>() {

            private Double maxValue = Double.MIN_VALUE;

            /**
             * Поиск максимума, отправляем набор чисел, и с каждым запросом получаем новый максимум
             */
            @Override
            public void onNext(Number value) {

                maxValue = Math.max(maxValue, value.getValue());

                Number number = Number.newBuilder()
                        .setValue(maxValue)
                        .build();

                responseObserver.onNext(number);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

}
