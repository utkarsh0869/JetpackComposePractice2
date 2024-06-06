package com.example.jetpackcomposepractice2.ui.theme

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var bottomNavState = mutableIntStateOf(0)
}