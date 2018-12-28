package com.keepimproving.shivam.multiplerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.keepimproving.shivam.multiplerecyclerview.multipleviewadaptor.MultipleViewAdaptor
import com.keepimproving.shivam.multiplerecyclerview.multipleviewadaptor.model.DataList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataOne = DataList("Steve Jobs",null)
        var dataTwo = DataList("A Great Visionary",null)
        var dataThree=DataList(null,R.drawable.stevejobs)
        var dataList = listOf<DataList>(dataThree,dataOne,dataTwo)
        multipleRecyclerView.layoutManager =LinearLayoutManager(this)
        multipleRecyclerView.adapter=MultipleViewAdaptor(dataList)

    }
}
