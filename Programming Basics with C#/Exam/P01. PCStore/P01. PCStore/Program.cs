using System;

namespace P01._PCStore
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double processorPriceUSD = double.Parse(Console.ReadLine());
            double videoCardPriceUSD = double.Parse(Console.ReadLine());
            double priceUSDOfRAMMemoryUSD = double.Parse(Console.ReadLine());
            int numberOfRAM = int.Parse(Console.ReadLine());
            double discount = double.Parse(Console.ReadLine());

            double processorPriceBGN = processorPriceUSD * 1.57;
            double videoCardPriceBGN = videoCardPriceUSD * 1.57;
            double priceUSDOfRAMMemoryBGN = priceUSDOfRAMMemoryUSD * 1.57;

            double totalPriceOfRAM = numberOfRAM * priceUSDOfRAMMemoryBGN;
            double processorPriceAfterDiscount = processorPriceBGN - processorPriceBGN * discount;
            double videoCardPriceAfterDiscount = videoCardPriceBGN - videoCardPriceBGN * discount;

            double totalPrice = totalPriceOfRAM + videoCardPriceAfterDiscount + processorPriceAfterDiscount;
            Console.WriteLine($"Money needed - {totalPrice:F2} leva.");
        }
    }
}
