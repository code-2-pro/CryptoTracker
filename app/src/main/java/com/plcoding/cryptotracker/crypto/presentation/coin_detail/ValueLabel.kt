package com.plcoding.cryptotracker.crypto.presentation.coin_detail

import java.util.Locale
import java.text.NumberFormat

data class ValueLabel(
    val value: Float,
    val unit: String
){
    fun formatted(): String{
        val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
            val fractionDigits = when
            {
                value > 1000 -> 0
                value in 2f..999f -> 2
                else -> 3
            }
            maximumFractionDigits = fractionDigits
            minimumFractionDigits = 0
        }
        return "${formatter.format(value)}$unit"
    }
}
