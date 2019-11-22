package com.felipe.androidportfolio.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.felipe.androidportfolio.R
import com.felipe.androidportfolio.adapter.PortfolioListAdapter
import com.felipe.androidportfolio.listener.OnListItemClickListener
import kotlinx.android.synthetic.main.fragment_portfolio_list.*

/**
 * A simple [Fragment] subclass.
 */
class PortfolioListFragment : Fragment(), OnListItemClickListener {

    private lateinit var mAdapter: PortfolioListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_list, container, false)
    }

    override fun onResume() {
        super.onResume()

        mAdapter = PortfolioListAdapter(context!!, this)
        elvPortfolio.setAdapter(mAdapter)
        elvPortfolio.setGroupIndicator(null)
    }

    override fun onItemClick(action: Int) {
        findNavController().navigate(action)
    }
}
