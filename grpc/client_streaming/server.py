from concurrent import futures

import grpc

import standard_deviation_calculator_pb2_grpc, standard_deviation_calculator_pb2


class StandardDeviationCalculator(standard_deviation_calculator_pb2_grpc.StandardDeviationCalculatorServicer):
    def calculate_std(self, request_iterator, context):
        count = 0
        sum = 0
        square_sum = 0
        for number in request_iterator:
            count += 1
            sum += number.value
            square_sum += number.value ** 2
        std = ((square_sum / count) - (sum / count) ** 2) ** 0.5
        return standard_deviation_calculator_pb2.Number(value=std)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    standard_deviation_calculator_pb2_grpc.add_StandardDeviationCalculatorServicer_to_server(
        StandardDeviationCalculator(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    serve()
