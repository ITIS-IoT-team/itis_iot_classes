import sys

import grpc

from generated.prime_numbers_pb2 import Number
from generated.prime_numbers_pb2_grpc import PrimeNumbersStreamerStub


def parse_args():
    args = sys.argv
    if len(args) < 2:
        raise Exception('No numbers provided')
    try:
        number = int(sys.argv[1])
    except ValueError:
        raise Exception('{} - Not a number'.format(sys.argv[1]))
    return number


if __name__ == '__main__':
    channel = grpc.insecure_channel('localhost:50051')
    stub = PrimeNumbersStreamerStub(channel)
    number = parse_args()
    print(', '.join([str(number.value) for number in stub.get_primes(Number(value=number))]))
