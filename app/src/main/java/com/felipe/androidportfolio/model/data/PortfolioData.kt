package com.felipe.androidportfolio.model.data

import com.felipe.androidportfolio.R
import com.felipe.androidportfolio.model.Portfolio
import com.felipe.androidportfolio.model.PortfolioItem

object PortfolioData {

    fun getFullPortfolio(): ArrayList<Portfolio> {
        return arrayListOf(
            Portfolio(
                "List",
                R.drawable.ic_list,
                getListItems()
            )
        )
    }

    private fun getListItems(): ArrayList<PortfolioItem> {
        return arrayListOf(
            PortfolioItem("Single Line Item", R.id.action_portfolioListFragment_to_oneItemListFragment)
        )
    }
}