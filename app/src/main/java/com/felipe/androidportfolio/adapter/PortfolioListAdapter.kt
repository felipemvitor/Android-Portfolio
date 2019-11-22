package com.felipe.androidportfolio.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.felipe.androidportfolio.R
import com.felipe.androidportfolio.listener.OnListItemClickListener
import com.felipe.androidportfolio.model.Portfolio
import com.felipe.androidportfolio.model.PortfolioItem
import com.felipe.androidportfolio.model.data.PortfolioData

class PortfolioListAdapter(var context: Context, var listener: OnListItemClickListener? = null) :
    ExpandableListAdapter {

    private var portfolioList = PortfolioData.getFullPortfolio()

    override fun getChildrenCount(groupPosition: Int): Int {
        return portfolioList[groupPosition].items.size
    }

    override fun getGroup(groupPosition: Int): Portfolio {
        return portfolioList[groupPosition]
    }

    override fun onGroupCollapsed(groupPosition: Int) {

    }

    override fun isEmpty(): Boolean {
        return portfolioList.isEmpty()
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {
    }

    override fun getChild(groupPosition: Int, childPosition: Int): PortfolioItem {
        return portfolioList[groupPosition].items[childPosition]
    }

    override fun onGroupExpanded(groupPosition: Int) {
    }

    override fun getCombinedChildId(groupId: Long, childId: Long): Long {
        return -1
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val child = getChild(groupPosition, childPosition)

        var view = convertView
        view = LayoutInflater.from(context).inflate(R.layout.item_portfolio, null, false)

        view.setOnClickListener {
            listener?.onItemClick(child.action)
        }

        val itemText = view.findViewById<TextView>(R.id.itemText)
        itemText.text = child.name

        return view!!
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getCombinedGroupId(groupId: Long): Long {
        return -1
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val group = getGroup(groupPosition)

        var view = convertView
        view = LayoutInflater.from(context).inflate(R.layout.item_portfolio_header, parent, false)

        val itemIcon = view.findViewById<ImageView>(R.id.itemIcon)
        val itemText = view.findViewById<TextView>(R.id.itemText)

        itemIcon.setImageDrawable(context.getDrawable(group.icon))
        itemText.text = group.name


        return view!!
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }

    override fun getGroupCount(): Int {
        return portfolioList.size
    }

}