# Last updated: 9/3/2025, 10:46:36 AM
class Solution:
    def convertTemperature(self, celsius: float) -> List[float]:
         kelvin= celsius + 273.15;
         fahrenheit=celsius * 1.80 + 32.00;
         return [round(kelvin, 5), round(fahrenheit, 5)]
        