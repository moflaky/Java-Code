// ValueReturningFunc.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

char calculateGrade(int cScore);

int main()
{
	int cScore;

	cout << "Based on the course score, " << "this program computes the course grade." << endl;

	cout << "Enter course score: ";
	cin >> cScore;
	cout << "The couse score is: " << cScore << endl;

	cout << "The course grade is: " << calculateGrade(cScore) << endl;

    return 0;
}

char calculateGrade(int cScore)
{
	if (cScore >= 90)
		return 'A';
	else if (cScore >= 80)
		return 'B';
	else if (cScore >= 70)
		return 'C';
	else if (cScore >= 60)
		return 'D';
	else
		return 'F';
}
