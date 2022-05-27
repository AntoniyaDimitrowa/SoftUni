using System;

namespace _06._World_Swimming_Record
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double record = double.Parse(Console.ReadLine());
            double distance = double.Parse(Console.ReadLine());
            double timeForOneMeter = double.Parse(Console.ReadLine());
            double timesDelayed = Math.Floor(distance / 15);
            double totalIvansTime = distance* timeForOneMeter + timesDelayed*12.5;

            if(totalIvansTime < record)
            {
                Console.WriteLine($" Yes, he succeeded! The new world record is {totalIvansTime:F2} seconds.");
            }
            else
            {
                Console.WriteLine($"No, he failed! He was {totalIvansTime  - record:F2} seconds slower.");
            }
        }
    }
}
