from concurrent import futures

import grpc

import get_root_pb2_grpc, get_root_pb2


class RootCalculator(get_root_pb2_grpc.RootCalculatorServicer):
    def calculate_root(self, request, context):
        number = request.value
        return get_root_pb2.Number(value=number**0.5)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    get_root_pb2_grpc.add_RootCalculatorServicer_to_server(
        RootCalculator(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    serve()
