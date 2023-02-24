package com.example.imdbsandbox.listners

import android.view.View

interface DetailOnClickListener {
    fun onOpenIMDBCLick(view: View, url : String)
}