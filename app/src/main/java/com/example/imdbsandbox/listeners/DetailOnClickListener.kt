package com.example.imdbsandbox.listeners

import android.view.View

interface DetailOnClickListener {
    fun onOpenIMDBCLick(view: View, url : String)
}