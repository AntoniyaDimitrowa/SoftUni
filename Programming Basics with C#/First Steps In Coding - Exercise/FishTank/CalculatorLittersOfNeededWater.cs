using System;

namespace FishTank
{
    internal class CalculatorLittersOfNeededWater
    {
        static double CMinDM(double a)
        {
            return a / 10;
        }
        static void Main(string[] args)
        {
            double length = double.Parse(Console.ReadLine());  
            double width = double.Parse(Console.ReadLine());  
            double height = double.Parse(Console.ReadLine());  
            double percentOfOtherThings = double.Parse(Console.ReadLine());  
            double lenghtInDM = CMinDM(length);
            double widthInDM = CMinDM(width);
            double heightInDM = CMinDM(height);
            double volumeOfFishTank = lenghtInDM * widthInDM * heightInDM;
            double litters = volumeOfFishTank - volumeOfFishTank * percentOfOtherThings / 100;
            Console.WriteLine(litters);
        }
    }
}
