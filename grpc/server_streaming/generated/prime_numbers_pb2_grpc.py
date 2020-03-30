# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import generated.prime_numbers_pb2 as prime__numbers__pb2


class PrimeNumbersStreamerStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.get_primes = channel.unary_stream(
        '/PrimeNumbersStreamer/get_primes',
        request_serializer=prime__numbers__pb2.Number.SerializeToString,
        response_deserializer=prime__numbers__pb2.Number.FromString,
        )


class PrimeNumbersStreamerServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def get_primes(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_PrimeNumbersStreamerServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'get_primes': grpc.unary_stream_rpc_method_handler(
          servicer.get_primes,
          request_deserializer=prime__numbers__pb2.Number.FromString,
          response_serializer=prime__numbers__pb2.Number.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'PrimeNumbersStreamer', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))