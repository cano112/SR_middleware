from currency_service_pb2_grpc import CurrencyServiceServicer
from currency_service_pb2 import Rate, Currency
from time import sleep
import random


class CurrencyService(CurrencyServiceServicer):

    def GetCurrencyRate(self, request, context):
        if request.currencyTo == Currency.Value('PLN'):
            usd = 3.8
            eur = 4.2
            chf = 3.5

            while True:
                rate = None
                if request.currencyFrom == Currency.Value('USD'):
                    usd = usd + random.uniform(-0.03, 0.03)
                    rate = Rate(value=usd)
                if request.currencyFrom == Currency.Value('EUR'):
                    eur = usd + random.uniform(-0.03, 0.03)
                    rate = Rate(value=eur)
                if request.currencyFrom == Currency.Value('CHF'):
                    chf = usd + random.uniform(-0.03, 0.03)
                    rate = Rate(value=chf)
                yield rate
                sleep(10)
