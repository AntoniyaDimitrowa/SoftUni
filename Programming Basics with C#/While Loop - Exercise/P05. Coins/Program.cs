using System;

namespace P05._Coins
{
    internal class Program
    {
        static void Main(string[] args)
        {
            decimal change = decimal.Parse(Console.ReadLine());
            int coinsCounter = 0;
            while(change > 0.00m)
            {
                if(change>=2.00m)
                {
                    change = change - 2.00m;
                }
                else if (change >= 1.00m)
                {
                    change = change - 1;
                }
                else if(change>=0.50m)
                {
                    change = change - 0.50m; 
                }
                else if (change >= 0.20m)
                {
                    change = change - 0.20m;
                }
                else if (change >= 0.10m)
                {
                    change = change - 0.10m;
                }
                else if (change >= 0.05m)
                {
                    change = change - 0.05m;
                }
                else if (change >= 0.02m)
                {
                    change = change - 0.02m;
                }
                else if (change >= 0.01m)
                {
                    change = change - 0.1m;
                }
                coinsCounter++;
            }
            Console.WriteLine(coinsCounter);
        }
    }
}
