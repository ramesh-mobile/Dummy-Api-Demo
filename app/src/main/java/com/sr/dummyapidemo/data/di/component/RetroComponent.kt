package com.sr.dummyapidemo.data.di.component

import com.sr.dummyapidemo.data.di.module.RetroModule
import com.sr.dummyapidemo.ui.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ramesh on 17-10-2021
 */
@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun injectRetro(mainActivityViewModel: MainActivityViewModel)
}