package com.ap.vi.portfolio

class WealthManager {
    companion object {
        // (ალიხან (6) + პაშაევი (7)) / დაბადების თარიღი (5)
        private const val K = 2.6
    }

    fun calculateSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * K
    }
}