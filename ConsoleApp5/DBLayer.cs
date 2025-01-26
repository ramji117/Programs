using System;
using System.Data.SqlClient;

namespace Utility
{
    public static class DBLayer
    {
        private static readonly object lockObject = new object();


        private static string dbConnectionString = null;

        private static SqlConnection sqlConnection = null;


        public static SqlConnection GetConnection()
        {
            if (string.IsNullOrEmpty(dbConnectionString))
            {
                throw new InvalidOperationException("Database connection string is not set.");

            }
            lock (lockObject)
            {
                try
                {
                    if (sqlConnection == null || sqlConnection.State == System.Data.ConnectionState.Closed)
                    {
                        sqlConnection = new SqlConnection(dbConnectionString);
                        sqlConnection.Open();

                    }
                }
                catch (SqlException ex)
                {
                    throw new Exception("Failed to connect to the database. Check the connection string and database server.", ex);
                }
                catch (InvalidOperationException ex)
                {
                    throw new Exception("Connection string is in an invalid format.", ex);
                }
            }

            return sqlConnection;
        }

        public static void CloseConnection()
        {
            try
            {
                if (sqlConnection != null && sqlConnection.State == System.Data.ConnectionState.Open)
                {
                    sqlConnection.Close();
                    sqlConnection = null;
                }
            }
            catch (Exception ex)
            {
                throw new Exception("Failed To Close Connection", ex);
            }

        }
    }

}