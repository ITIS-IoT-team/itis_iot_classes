import random

import grpc

import standard_deviation_calculator_pb2_grpc, standard_deviation_calculator_pb2


def generate_numbers():
    for i in range(1, 10):
        number = random.randint(1, 1000)
        print('SEND >> {}'.format(number))
        yield standard_deviation_calculator_pb2.Number(value=number)


if __name__ == '__main__':
    channel = grpc.insecure_channel('localhost:50051')
    stub = standard_deviation_calculator_pb2_grpc.StandardDeviationCalculatorStub(channel)
    while True:
        response = stub.calculate_std(generate_numbers())
        print('RECEIVED << {}'.format(response.value))
