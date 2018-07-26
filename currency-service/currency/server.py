from concurrent import futures
from currency.service import CurrencyService
from time import sleep
from currency_service_pb2_grpc import add_CurrencyServiceServicer_to_server

import grpc


def main():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    add_CurrencyServiceServicer_to_server(CurrencyService(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    print("Currency server running...")
    while True:
        sleep(1000)


if __name__ == "__main__":
    main()
