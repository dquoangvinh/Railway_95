package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;

public class Program {
	public static void main(String[] args) {

		Department dept1 = new Department(1, "Marketing");
		Department dept2 = new Department(2, "Sale");
		Department dept3 = new Department(3, "BOD");

		Position pos1 = new Position(1, PositionName.Dev);
		Position pos2 = new Position(2, PositionName.PM);
		Position pos3 = new Position(3, PositionName.Scrum_Master);

		Account acc1 = new Account(1, "daonq1@email.com", "daonq1", "Dao Nguyen 1", dept1, pos1, LocalDate.now());
		Account acc2 = new Account(2, "daonq2@email.com", "daonq2", "Dao Nguyen 2", dept2, pos2,
				LocalDate.of(2021, 3, 17));
		Account acc3 = new Account(3, "daonq3@email.com", "daonq3", "Dao Nguyen 3", dept3, pos3, LocalDate.now());

		Group group1 = new Group(1, "Testing System", acc1, LocalDate.now());
		Group group2 = new Group(2, "Development", acc2, LocalDate.now());
		Group group3 = new Group(3, "Sale", acc3, LocalDate.now());

		acc1.setGroups(new Group[] { group1, group2 });
		acc2.setGroups(new Group[] { group3, group2 });
		acc3.setGroups(new Group[] { group3 });

		group1.setAccounts(new Account[] { acc1 });
		group2.setAccounts(new Account[] { acc1, acc2 });
		group3.setAccounts(new Account[] { acc2, acc3 });

		TypeQuestion type1 = new TypeQuestion(1, TypeName.Multiple_Choice);
		TypeQuestion type2 = new TypeQuestion(2, TypeName.Essay);
		TypeQuestion type3 = new TypeQuestion(3, TypeName.Multiple_Choice);

		CategoryQuestion cat1 = new CategoryQuestion(1, "Java");
		CategoryQuestion cat2 = new CategoryQuestion(2, "SQL");
		CategoryQuestion cat3 = new CategoryQuestion(3, "Testing");

		Question quest1 = new Question(1, "What is polymorphism in Java?", cat1, type1, acc1, LocalDate.now());
		Question quest2 = new Question(2, "Explain inheritance concept", cat1, type2, acc1, LocalDate.now());
		Question quest3 = new Question(3, "What is JOIN in SQL?", cat2, type1, acc2, LocalDate.now());

		Answer ans1 = new Answer(1,
				"Polymorphism allows objects of different types to be treated as instances of the same type", quest1,
				true);
		Answer ans2 = new Answer(2, "Method overloading", quest1, false);
		Answer ans3 = new Answer(3,
				"Inheritance is a mechanism where a new class inherits properties from existing class", quest2, true);

		Exam exam1 = new Exam(1, "JAVA_001", "Java Fundamentals Test", cat1, 60, acc1, LocalDate.now());
		Exam exam2 = new Exam(2, "SQL_001", "SQL Basics Test", cat2, 45, acc2, LocalDate.now());
		Exam exam3 = new Exam(3, "TEST_001", "Software Testing Exam", cat3, 90, acc3, LocalDate.now());

		exam1.setQuestions(new Question[] { quest1, quest2 });
		exam2.setQuestions(new Question[] { quest3 });

		System.out.println("=== DEPARTMENTS ===");
		System.out.println(dept1);
		System.out.println(dept2);
		System.out.println(dept3);

		System.out.println("\n=== POSITIONS ===");
		System.out.println(pos1);
		System.out.println(pos2);
		System.out.println(pos3);

		System.out.println("\n=== ACCOUNTS ===");
		System.out.println(acc1);
		System.out.println("Groups: " + acc1.getGroups()[0].getName() + ", " + acc1.getGroups()[1].getName());
		System.out.println(acc2);
		System.out.println("Groups: " + acc2.getGroups()[0].getName() + ", " + acc2.getGroups()[1].getName());
		System.out.println(acc3);
		System.out.println("Groups: " + acc3.getGroups()[0].getName());

		System.out.println("\n=== GROUPS ===");
		System.out.println(group1);
		System.out.println(group2);
		System.out.println(group3);

		System.out.println("\n=== TYPE QUESTIONS ===");
		System.out.println(type1);
		System.out.println(type2);
		System.out.println(type3);

		System.out.println("\n=== CATEGORY QUESTIONS ===");
		System.out.println(cat1);
		System.out.println(cat2);
		System.out.println(cat3);

		System.out.println("\n=== QUESTIONS ===");
		System.out.println(quest1);
		System.out.println(quest2);
		System.out.println(quest3);

		System.out.println("\n=== ANSWERS ===");
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);

		System.out.println("\n=== EXAMS ===");
		System.out.println(exam1);
		System.out.println(exam2);
		System.out.println(exam3);
	}
}