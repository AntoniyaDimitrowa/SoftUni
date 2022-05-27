using System;

namespace _02._Bonus_Score
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int scoreAtTheBeginning = int.Parse(Console.ReadLine());
            
            double bonusPoints = 0.0;
            if (scoreAtTheBeginning <= 100)
            {
                bonusPoints = 5.0;
            } 
            else if (scoreAtTheBeginning > 1000)
            {
                bonusPoints = 0.1 * scoreAtTheBeginning;   
            }
            else
            {
                bonusPoints = 0.2*scoreAtTheBeginning;
            }
            if(scoreAtTheBeginning%2==0)
            {
                bonusPoints = bonusPoints + 1;
            }
            if(scoreAtTheBeginning % 10==5)
            {
                bonusPoints = bonusPoints + 2;
            }

            double scoreAtTheEnd = scoreAtTheBeginning + bonusPoints;
            Console.WriteLine(bonusPoints);
            Console.WriteLine(scoreAtTheEnd);
        }
    }
}
