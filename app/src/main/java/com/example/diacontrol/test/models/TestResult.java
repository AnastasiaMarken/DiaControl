package com.example.diacontrol.test.models;

public class TestResult {
	private int minScore;
	private int maxScore;
	private String riskLevel;
	private String statistics;
	private String recommendation;

	public TestResult(int minScore, int maxScore, String riskLevel, String statistics, String recommendation) {
		this.minScore = minScore;
		this.maxScore = maxScore;
		this.riskLevel = riskLevel;
		this.statistics = statistics;
		this.recommendation = recommendation;
	}

	public int getMinScore() {
		return minScore;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public String getRiskLevel() {
		return riskLevel;
	}
	public String getRiskLevelDescription() {
		return "У Вас " + riskLevel + " степень риска заболевания";
	}


	public String getStatistics() {
		return statistics;
	}

	public String getRecommendation() {
		return recommendation;
	}
}
