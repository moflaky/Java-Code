// ConvertLengthProject.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	int feet, inches;
	double centimeters;

	cout << "Please enter number of feet:";
	cin >> feet;
	cout << "Please enter number of inches:";
	cin >> inches;

	centimeters = (12 * feet + inches)*2.54;

	cout << "Value in centimeters:" << centimeters << endl;

    return 0;
}

