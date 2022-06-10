using System;

namespace P04._Walking
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int steps = 10000;
            int stepsForTheDay = 0;
            string command;
            while(true)
            {
                command = Console.ReadLine();
                if(command== "Going home")
                {
                    int stepsFromWalkingHome = int.Parse(Console.ReadLine());
                    stepsForTheDay += stepsFromWalkingHome;
                    if (steps > stepsForTheDay)
                    {
                        Console.WriteLine($"{Math.Abs(steps - stepsForTheDay)} more steps to reach goal.");
                        break;
                    }
                }
                else
                {
                    int currsteps = int.Parse(command);
                    stepsForTheDay += currsteps;
                }
                if (steps <= stepsForTheDay)
                {
                    Console.WriteLine($"Goal reached! Good job!");
                    Console.WriteLine($"{Math.Abs(steps - stepsForTheDay)} steps over the goal!");
                    break;
                }
            }
        }
    }
}
