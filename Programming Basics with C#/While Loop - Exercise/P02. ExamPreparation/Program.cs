using System;

namespace P02._ExamPreparation
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numberOfBadGrades = int.Parse(Console.ReadLine());
            int sum = 0;
            int counterOfBadGrades = 0;
            int counterOfAllGrades = 0;
            string name = "";
            string command;
            while(true)
            {
                command = Console.ReadLine();
                if (command == "Enough")
                {
                    break;
                }
                else
                {
                    name = command;
                    int currGrade = int.Parse(Console.ReadLine());
                    sum = sum + currGrade;
                    counterOfAllGrades++;
                    if (currGrade < 5)
                    {
                        counterOfBadGrades++;
                        if (counterOfBadGrades >= numberOfBadGrades)
                        {
                            Console.WriteLine($"You need a break, {counterOfBadGrades} poor grades.");
                            break;
                        }
                    }
                }
                
            }
            if (counterOfBadGrades < numberOfBadGrades)
            {
                Console.WriteLine($"Average score: {(sum * 1.0 / counterOfAllGrades):F2}");
                Console.WriteLine($"Number of problems: {counterOfAllGrades}");
                Console.WriteLine($"Last problem: {name}");
            }
        }
    }
}
