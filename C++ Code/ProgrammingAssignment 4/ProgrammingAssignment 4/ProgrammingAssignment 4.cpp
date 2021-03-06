// ProgrammingAssignment 4.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

struct studentTest
{
	string name;
	double testScore[5];
	double averageScore;
	char grade;
};

const int NUMBER_OF_PEOPLE = 10;
const int NUMBER_OF_TESTS = 5;

void read(string names[], int nameLength, double scores[][NUMBER_OF_TESTS], int scoreRowSize);
void calculate(double matrix[], double scores[][NUMBER_OF_TESTS], int scoreRowSize);
void print(double matrix[], string names[], int namesSize);

int main()
{
	studentTest student[10];

	read(student, 10);
	calculate(grades, scores, 10);
	print(grades, names, 10);

	return 0;
}

void read(studentTest student[], int count)
{

	cout << "Enter all student names followed by their 5 test scores: " << endl;

	for (int i = 0; i < count; count++)
	{
		cin >> student[i].name;

		for (int j = 0; j < 5; j++)
			cin >> student[i].testScore[j];

		student[i].averageScore = 0.0;
	}
}
void calculate(double matrix[], double scores[][NUMBER_OF_TESTS], int scoreRowSize)
{
	int counter = 0;
	int num = 0;
	double total = 0;
	double average = 0;

	cout << fixed << showpoint << setprecision(2) << endl;

	while (counter < scoreRowSize)
	{
		while (num < NUMBER_OF_TESTS)
		{
			total = total + scores[counter][num];
			num++;
		}
		average = (total / NUMBER_OF_TESTS);
		matrix[counter] = average;
		total = 0;
		average = 0;
		num = 0;
		counter++;
	}
}
void print(double matrix[], string names[], int namesSize)
{
	int counter = 0;

	cout << setw(10) << "Name" << setw(12) << "Grade" << endl;

	for (counter = 0; counter < namesSize; counter++)
	{
		cout << setw(10) << names[counter] << setw(12) << matrix[counter] << endl;
	}
}