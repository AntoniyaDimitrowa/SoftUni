using System;

namespace P06._CinemaTickets
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();
            int totalSoldTickets = 0;
            int totalStudentTickets = 0;
            int totalStandardTickets = 0;
            int totalKidsTickets = 0;

            while (command != "Finish")
            {
                string movieName = command;
                int freeSeats = int.Parse(Console.ReadLine());
                string commsnd2 = Console.ReadLine();
                int occupiedSeats = 0;

                while (commsnd2 != "End")
                {
                    occupiedSeats++;
                    string ticketType = commsnd2;
                    int studentTickets = 0;
                    int standardTickets = 0;
                    int kidsTickets = 0;
                    if (ticketType == "student")
                    {
                        studentTickets++;
                    }
                    else if (ticketType == "standard")
                    {
                        standardTickets++;
                    }
                    else if (ticketType == "kid")
                    {
                        kidsTickets++;
                    }
                    totalKidsTickets = totalKidsTickets + kidsTickets;
                    totalStudentTickets = totalStudentTickets + studentTickets;
                    totalStandardTickets = totalStandardTickets + standardTickets;
                    totalSoldTickets = totalSoldTickets + studentTickets + standardTickets + kidsTickets;

                    if (occupiedSeats == freeSeats)
                    {
                        break;
                    }
                    commsnd2 = Console.ReadLine();
                }
                Console.WriteLine($"{movieName} - {((occupiedSeats * 1.0 / freeSeats) * 100):F2}% full.");
                command = Console.ReadLine();
            }
            Console.WriteLine($"Total tickets: {totalSoldTickets}");
            Console.WriteLine($"{((totalStudentTickets * 1.0 / totalSoldTickets) * 100):F2}% student tickets.");
            Console.WriteLine($"{((totalStandardTickets * 1.0 / totalSoldTickets) * 100):F2}% standard tickets.");
            Console.WriteLine($"{((totalKidsTickets * 1.0 / totalSoldTickets) * 100):F2}% kids tickets.");
        }
    }
}
