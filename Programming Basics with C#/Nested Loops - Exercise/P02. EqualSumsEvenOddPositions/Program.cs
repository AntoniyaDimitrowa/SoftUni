using System;

namespace P02._EqualSumsEvenOddPositions
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int firstNum = int.Parse(Console.ReadLine());
            int secondNum = int.Parse(Console.ReadLine());

            for (int i = firstNum; i <= secondNum; i++)
            {
                string currNum = i.ToString();
                int sumOddPositions = 0;
                int sumEvenPositions = 0;
                for (int j = 0; j < currNum.Length; j++)
                {
                    if (j % 2 == 0)
                    {
                        sumEvenPositions += currNum[j];
                    }
                    else
                    {
                        sumOddPositions += currNum[j];
                    }
                }
                if (sumOddPositions == sumEvenPositions)
                {
                    Console.Write(currNum + " ");
                }
            }
        }
    }
}
