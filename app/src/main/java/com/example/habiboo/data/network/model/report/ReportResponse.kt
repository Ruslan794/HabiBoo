package com.example.habiboo.data.network.model.report

import com.example.habiboo.data.network.model.room.Meta

data class ReportResponse (
    val data: List<ReportData>,
    val meta: Meta
)