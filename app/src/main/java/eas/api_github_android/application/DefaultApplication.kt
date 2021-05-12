package eas.api_github_android.application

import android.app.Application
import eas.api_github_android.di.dataModule
import eas.api_github_android.di.moduleRepository
import eas.api_github_android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DefaultApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DefaultApplication)
            modules(
                listOf(
                    dataModule,
                    moduleRepository,
                    viewModelModule
                )
            )
        }
    }
}