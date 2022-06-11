using System;

namespace Repainting
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int amountOfNylon = int.Parse(Console.ReadLine());
            int amountOfPaint = int.Parse(Console.ReadLine());
            int amountOfPaintThinner = int.Parse(Console.ReadLine());
            int hoursOfWorking = int.Parse(Console.ReadLine());
            double sumOfPriceForNylon = (amountOfNylon + 2) * 1.50;
            double sumOfPriceForPaint = (amountOfPaint + amountOfPaint * 0.1) * 14.50;
            double sumOfMaterials = sumOfPriceForNylon + sumOfPriceForPaint + amountOfPaintThinner * 5.0 + 0.4;
            double sumOfPriceForWorkers = (sumOfMaterials * 0.3) * hoursOfWorking;
            double finaleSum = sumOfMaterials + sumOfPriceForWorkers;
            Console.WriteLine(finaleSum);
        }
    }
}
