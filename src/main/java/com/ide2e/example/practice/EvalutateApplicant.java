package com.ide2e.example.practice;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class EvalutateApplicant {

	static Predicate<Applicant> evaluateCreditScore = anApplicant -> anApplicant.getCreditScore() > 500;
	
	static Predicate<Applicant> evaluateCrimeRecord = Applicant::isCrimeRecord;
	
	public static String evaluateApplicant(Applicant applicant) {
		return evaluate(applicant, evaluateCreditScore.and(evaluateCrimeRecord));
	}

	private static String evaluate(Applicant anApplicant, Predicate<Applicant> evaluator ) {
		return evaluator.test(anApplicant) ? "accepted": "rejected";
	}
	
	public static boolean isPrime(int number) {	
		return number > 1 && IntStream.range(1, number).noneMatch(i-> number % i == 0);
	}
	
	public static void main(String []  args) {
	
		String result = EvalutateApplicant.evaluateApplicant(new Applicant("Johnathan","KK", 700, false));
	    System.out.println(" result :" + result);
	}
}
