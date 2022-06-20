using System;

namespace P04._ComputerFirm
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int computerModelsNumber = int.Parse(Console.ReadLine());
            int ratingsSum = 0;
            double totalSales = 0;
            for (int i = 1; i <= computerModelsNumber; i++)
            {
                int number = int.Parse(Console.ReadLine());
                int rating = number % 10;
                int possibleSales = number / 10;
                double currSales = 0;

                switch (rating)
                {
                    case 2:
                        currSales = 0;
                        break;
                    case 3:
                        currSales = possibleSales * 0.50;
                        break;
                    case 4:
                        currSales = possibleSales * 0.70;
                        break;
                    case 5:
                        currSales = possibleSales * 0.85;
                        break;
                    case 6:
                        currSales = possibleSales;
                        break;
                }
                totalSales += currSales;
                ratingsSum += rating;
            }
            double averageRating = ratingsSum * 1.0 / computerModelsNumber;
            Console.WriteLine($"{totalSales:F2}");
            Console.WriteLine($"{averageRating:F2}");
        }
    }
}
