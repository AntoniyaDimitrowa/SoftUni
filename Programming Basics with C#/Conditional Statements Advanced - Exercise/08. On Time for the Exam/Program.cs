using System;

namespace _08._On_Time_for_the_Exam
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int hourExam = int.Parse(Console.ReadLine());
            int minuteExam = int.Parse(Console.ReadLine());
            int hourArrival = int.Parse(Console.ReadLine());
            int minuteArrival = int.Parse(Console.ReadLine());

            if(hourExam == hourArrival)
            {
                if(minuteExam == minuteArrival)
                {
                    Console.WriteLine("On time");
                }
                else if(minuteExam>minuteArrival)
                {
                    if(minuteExam-minuteArrival>30)
                    {
                        Console.WriteLine("Early");  
                    }
                    else
                    {
                        Console.WriteLine("On time");
                    }
                    Console.WriteLine($"{minuteExam - minuteArrival} minutes before the start");
                }
                else
                {
                    Console.WriteLine("Late");
                    Console.WriteLine($"{minuteArrival - minuteExam} minutes after the start");
                }
            }
            else if(hourExam>hourArrival)
            {
                if(minuteArrival==minuteExam)
                {
                    Console.WriteLine("Early");
                    Console.WriteLine($"{hourExam - hourArrival}:00 hours before the start");
                }
                else if(minuteArrival>minuteExam)
                {
                    int hours = hourExam - hourArrival - 1;
                    int minutes = 60 - minuteArrival + minuteExam;
                    if(hours==0)
                    {
                        if(minutes>30)
                        {
                            Console.WriteLine("Early");
                        }
                        else 
                        { 
                            Console.WriteLine("On time");
                        }
                        Console.WriteLine($"{minutes} minutes before the start");
                    }
                    else
                    {
                        Console.WriteLine("Early");
                        if (minutes<10)
                        {
                            Console.WriteLine($"{hours}:0{minutes} hours before the start");
                        }
                        else
                        {
                            Console.WriteLine($"{hours}:{minutes} hours before the start");
                        }
                    }
                }
                else
                {
                    Console.WriteLine("Early");
                    if (minuteExam-minuteArrival < 10)
                    {
                        Console.WriteLine($"{hourExam - hourArrival}:0{minuteExam - minuteArrival} hours before the start");
                    }
                    else
                    {
                        Console.WriteLine($"{hourExam - hourArrival}:{minuteExam - minuteArrival} hours before the start");
                    }
                }
            }
            else
            {
                if(minuteExam == minuteArrival)
                {
                    Console.WriteLine("Late");
                    Console.WriteLine($"{hourArrival - hourExam}:00 hours after the start");
                }
                else if(minuteExam < minuteArrival)
                {
                    Console.WriteLine("Late");
                    if (minuteArrival -minuteExam < 10)
                    {
                        Console.WriteLine($"{hourArrival - hourExam}:0{minuteArrival - minuteExam} hours after the start");
                    }
                    else
                    {
                        Console.WriteLine($"{hourArrival - hourExam}:{minuteArrival - minuteExam} hours after the start");
                    }
                }
                else
                {
                    int hours = hourArrival - hourExam - 1;
                    int minutes = 60-(minuteExam - minuteArrival);
                    Console.WriteLine("Late");
                    if (hours==0)
                    {
                        Console.WriteLine($"{minutes} minutes after the start");
                    }
                    else
                    {
                        if(minutes < 10)
                        {
                            Console.WriteLine($"{hours}:0{minutes} hours after the start");
                        }
                        else
                        {
                            Console.WriteLine($"{hours}:{minutes} hours after the start");
                        }
                    }
                }
            }
        }
    }
}
