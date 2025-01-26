using NLog;
using System;
using System.Collections.Generic;

namespace ConsoleApp5
{
    public class Program
    {
        public static void Main(string[] args)
        {
            // Your API URL
            List<string> list = new List<string>();
            list.Add("Ramjirao");
            list.Add("Developer");

            foreach (string item in list) {

                {
                    Console.WriteLine(item);
                }

                Print(3);

            }

              void Print(int number)
            {
                Logger log = LogManager.GetCurrentClassLogger();
                try
                {
                    Console.WriteLine(0);
                    log.Info("Success");

                }
                catch (Exception ex)
                {
                    {
                        log.Error("Divide By Zero");
                    }


                }
            }
        }

    }
}


