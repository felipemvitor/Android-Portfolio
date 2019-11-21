package com.felipe.androidportfolio.model

import androidx.annotation.DrawableRes

data class Portfolio(
    var name: String, @DrawableRes var icon: Int,
    var items: ArrayList<PortfolioItem>
)