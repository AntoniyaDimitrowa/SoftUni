using System;

namespace Repainting
{
    internal class Repainting
    {
        static void Main(string[] args)
        {
            int amountOfNylon = int.Parse(Console.ReadLine());
            int amountOfPaint = int.Parse(Console.ReadLine());
            int amountOfPaintThinner = int.Parse(Console.ReadLine());
            int hoursOfWorking = int.Parse(Console.ReadLine());
            double sumOfPriceForNylon = (amountOfNylon + 2) * 1.50;
            //Console.WriteLine(sumOfPriceForNylon);
            double sumOfPriceForPaint = (amountOfPaint + amountOfPaint * 0.1) * 14.50;
            //Console.WriteLine(sumOfPriceForPaint);
            double sumOfMaterials = sumOfPriceForNylon + sumOfPriceForPaint + amountOfPaintThinner * 5.0 + 0.4;
            //Console.WriteLine(sumOfMaterials);
            double sumOfPriceForWorkers = (sumOfMaterials * 0.3) * hoursOfWorking;
            //Console.WriteLine(sumOfPriceForWorkers);
            double finaleSum = sumOfMaterials + sumOfPriceForWorkers;
            Console.WriteLine(finaleSum);
        }
    }
}
