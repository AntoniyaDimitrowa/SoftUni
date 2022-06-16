using System;

namespace P04._TrainTheTrainers
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int juryMembers = int.Parse(Console.ReadLine());
            string command;
            double sumAllGrades = 0;
            int presentationCounter = 0;
            while ((command = Console.ReadLine()) != "Finish")
            {
                presentationCounter++;
                string presentationName = command;
                double sumCurrGrade = 0;
                for (int i = 0; i < juryMembers; i++)
                {
                    sumCurrGrade += double.Parse(Console.ReadLine());
                }
                Console.WriteLine($"{presentationName} - {(sumCurrGrade / juryMembers):F2}.");
                sumAllGrades += sumCurrGrade;
            }
            double finaleScore = sumAllGrades / (juryMembers * presentationCounter);
            Console.WriteLine($"Student's final assessment is {finaleScore:F2}.");
        }
    }
}
