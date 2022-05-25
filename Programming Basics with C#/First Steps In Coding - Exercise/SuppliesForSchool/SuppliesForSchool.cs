using System;

namespace SuppliesForSchool
{
    internal class SuppliesForSchool
    {
        static void Main(string[] args)
        {
            int numberOfPackagesOfChemicals = int.Parse(Console.ReadLine());
            int numberOfPackagesOfMarkers = int.Parse(Console.ReadLine());
            int litersOfBoardCleaner = int.Parse(Console.ReadLine());
            int percentageOfDiscount = int.Parse(Console.ReadLine());

            double sum = numberOfPackagesOfChemicals * 5.8 + numberOfPackagesOfMarkers * 7.2 + litersOfBoardCleaner * 1.2;
            double finaleSum = sum - sum * percentageOfDiscount / 100;
            Console.WriteLine(finaleSum);
        
        
        }
    }
}
