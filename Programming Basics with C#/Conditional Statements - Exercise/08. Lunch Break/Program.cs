using System;

namespace _08._Lunch_Break
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string seriesTitle = Console.ReadLine();
            int episodeDuration = int.Parse(Console.ReadLine());
            int breakDuration = int.Parse(Console.ReadLine());

            double timeForLunch = 0.125 * breakDuration;
            double doNothingTime = 0.25 * breakDuration;
            double timeLeftForSeries = breakDuration - timeForLunch - doNothingTime;
            
            if(episodeDuration<=timeLeftForSeries)
            {
                Console.WriteLine($"You have enough time to watch {seriesTitle} and left with {Math.Ceiling(timeLeftForSeries - episodeDuration)} minutes free time.");
            }
            else
            {
                Console.WriteLine($"You don't have enough time to watch {seriesTitle}, you need {Math.Ceiling(episodeDuration- timeLeftForSeries)} more minutes.");
            }
        }
    }
}
