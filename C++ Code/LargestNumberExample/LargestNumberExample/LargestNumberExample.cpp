// LargestNumberExample.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;
double larger(double, double);

int main()
{
	double num;
	double max;
	int count;

	cout << "Please enter ten numbers: " << endl;
	for (count = 1; count <= 10; count++)
	{
		cin >> num;
		if (count == 1)
			max = num;
		else
			max = larger(max, num);
	}
	cout << "The largest number entered is: " << max << endl;

    return 0;
}

double larger(double x, double y)
{
	double z;
	if (x >= y)
		return x;
	else
		return y;

}