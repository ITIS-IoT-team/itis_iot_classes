import grpc

import get_root_pb2_grpc, get_root_pb2

if __name__ == '__main__':
    channel = grpc.insecure_channel('localhost:50051')
    stub = get_root_pb2_grpc.RootCalculatorStub(channel)
    while True:
        number = input('Enter number: ')
        print('SEND >> {}'.format(number))
        response = stub.calculate_root(get_root_pb2.Number(value=float(number)))
        print('RECEIVED << {}'.format(response.value))
