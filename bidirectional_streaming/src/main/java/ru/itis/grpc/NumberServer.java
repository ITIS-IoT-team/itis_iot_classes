package ru.itis.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class NumberServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("server started");
        Server server = ServerBuilder.forPort(3301)
                .addService(new NumberServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
