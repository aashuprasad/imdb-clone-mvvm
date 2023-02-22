package com.example.imdbsandbox.detail

import android.view.View

interface DetailOnClickListener {
    fun onOpenIMDBCLick(view: View, url : String)
}