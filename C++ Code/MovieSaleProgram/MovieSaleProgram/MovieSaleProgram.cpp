// MovieSaleProgram.cpp : Defines the entry point for the console application.
//
#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main()
{
	string movieName;
	double adultTicketPrice, childTicketPrice, grossAmount, percentDonation, amountDonated, netSaleAmount;
	int noOfAdultTicketsSold, noOfChildTicketsSold;

	cout << fixed << showpoint << setprecision(2);

	cout << "Enter the Movie Name: ";
	getline(cin, movieName);
	cout << endl;

	cout << "Enter the price of an adult ticket: ";
	cin >> adultTicketPrice;
	cout << endl;

	cout << "Enter the price of a child ticket: ";
	cin >> childTicketPrice;
	cout << endl;

	cout << "Enter the number of adult tickets sold: ";
	cin >> noOfAdultTicketsSold;
	cout << endl;

	cout << "Enter the number of child tickets sold: ";
	cin >> noOfChildTicketsSold;
	cout << endl;

	cout << "Enter the percent of gross amount donated: ";
	cin >> percentDonation;
	cout << endl;

	grossAmount = noOfAdultTicketsSold * adultTicketPrice + noOfChildTicketsSold * childTicketPrice;
	amountDonated = grossAmount * percentDonation / 100;
	netSaleAmount = grossAmount - amountDonated;

	cout << "_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*" << endl;

	cout << setfill('.') << left << setw(35) << "Movie Name: " << right << " " << movieName << endl;

	cout << left << setw(35) << "Number of Tickets Sold: " << setfill(' ') << right << setw(10) << noOfAdultTicketsSold + noOfChildTicketsSold << endl;

	cout << setfill('.') << left << setw(35) << "Gross Amount: " << setfill(' ') << right << "$" << setw(8) << grossAmount << endl;

	cout << setfill('.') << left << setw(35) << "Percentage of Gross Amount Donated: " << setfill(' ') << right << setw(9) << percentDonation << '%' << endl;

	cout << setfill('.') << left << setw(35) << "Amount Donated: " << setfill(' ') << right << "$" << setw(8) << amountDonated << endl;

	cout << setfill('.') << left << setw(35) << "Net Sale: " << setfill(' ') << right << "$" << setw(8) << netSaleAmount << endl;

    return 0;
}

