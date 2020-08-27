package com.messiasjunior.digiointerfaceclone

import android.app.Application
import com.messiasjunior.digiointerfaceclone.datasource.remoteDataSourceModule
import com.messiasjunior.digiointerfaceclone.presentation.home.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DigioInterfaceCloneApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DigioInterfaceCloneApplication)
            koin.loadModules(
                listOf(
                    remoteDataSourceModule,
                    homeModule
                )
            )
        }
    }
}
