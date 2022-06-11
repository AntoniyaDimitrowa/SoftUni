using System;

namespace _06._Oscars
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string actorName = Console.ReadLine();
            double pointsFromTheAcademy = double.Parse(Console.ReadLine());
            int NumberOfEvaluators = int.Parse(Console.ReadLine());
            double totalPoints = pointsFromTheAcademy;
            for (int i = 1; i <= NumberOfEvaluators; i++)
            {
                string evaluatorName = Console.ReadLine();
                double pointsFromEvaluator = double.Parse(Console.ReadLine());
                double totalPointsFromEvaluator = (evaluatorName.Length * pointsFromEvaluator) / 2;
                totalPoints = totalPoints + totalPointsFromEvaluator;
                if (totalPoints > 1250.5)
                {
                    Console.WriteLine($"Congratulations, {actorName} got a nominee for leading role with {totalPoints:F1}!");
                    break;
                }
            }
            if (totalPoints < 1250.5)
            {
                Console.WriteLine($"Sorry, {actorName} you need {(1250.5 - totalPoints):F1} more!");
            }
        }
    }
}
