package com.Malay.ExpenseTracker.services.stats;

import com.Malay.ExpenseTracker.dto.GraphDTO;
import com.Malay.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();

    StatsDTO getStats();
}
