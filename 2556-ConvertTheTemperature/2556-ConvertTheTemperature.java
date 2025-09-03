// Last updated: 9/3/2025, 10:46:42 AM
class Solution {
    public double[] convertTemperature(double celsius) {
       double kelvin= celsius + 273.15;
       double  fahrenheit=celsius * 1.80 + 32.00;
       double [] result = {Math.round(kelvin * 100000.0) / 100000.0, Math.round(fahrenheit * 100000.0) / 100000.0};
      return result;

    
    }
}