// 2CarDistanceProject.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
#include<iomanip>
#include <math.h>
using namespace std;

int main()
{
	int speedA;
	int speedB;
	double hours, minutes;
	double t;
	double distance;
	
	cout << "Please enter the average speed of car A in mph: ";
	cin >> speedA;
	cout << endl;

	cout << "Please enter the average speed of car B in mph: ";
	cin >> speedB;
	cout << endl;

	cout << "Please enter the number of hours elapsed: ";
	cin >> hours;
	cout << endl;
	
	cout << "Please enter the number of minutes elapsed: ";
	cin >> minutes;
	cout << fixed << setprecision(2);

	t = hours + minutes / 60;
	distance = sqrt(pow(speedA*t, 2) + pow(speedB*t, 2));
	cout << endl;

	cout << "The Shortest Distance Between Car A and Car B = " << distance << " Miles" << endl;

	return 0;
}