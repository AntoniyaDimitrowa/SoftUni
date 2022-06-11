using System;

namespace _08._TennisRanklist
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfTournaments = int.Parse(Console.ReadLine());
            int pointsInTheBegining = int.Parse(Console.ReadLine());
            int totalPoints = pointsInTheBegining;
            int numberOfWins = 0;
            for (int i = 1; i <= numberOfTournaments; i++)
            {
                string tournamentStage = Console.ReadLine();
                if (tournamentStage == "W")
                {
                    totalPoints = totalPoints + 2000;
                    numberOfWins++;
                }
                if (tournamentStage == "F")
                {
                    totalPoints = totalPoints + 1200;
                }
                if (tournamentStage == "SF")
                {
                    totalPoints = totalPoints + 720;
                }
            }
            double averagePoints = (totalPoints - pointsInTheBegining) / (numberOfTournaments * 1.0);
            double average = Math.Floor(averagePoints);

            Console.WriteLine($"Final points: {totalPoints}");
            Console.WriteLine($"Average points: {average}");
            Console.WriteLine($"{((numberOfWins * 1.0) / numberOfTournaments) * 100:F2}%");
        }
    }
}
