import logging
from concurrent import futures

import grpc

import generated.prime_numbers_pb2_grpc as pb2_grpc
import generated.prime_numbers_pb2 as pb2
from services.primes_service import get_prime_numbers


class PrimeNumbersStreamServicer(pb2_grpc.PrimeNumbersStreamerServicer):
    def get_primes(self, request, context):
        primes = get_prime_numbers(request.value)
        for number in primes:
            yield pb2.Number(value=number)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    pb2_grpc.add_PrimeNumbersStreamerServicer_to_server(
        PrimeNumbersStreamServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()
