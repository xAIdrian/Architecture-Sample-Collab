@file:Suppress("unused")

package net.samystudio.beaver.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import net.samystudio.beaver.SoshiApplication
import net.samystudio.beaver.data.service.ServiceBuilderModule
import net.samystudio.beaver.di.qualifier.ApplicationContext
import net.samystudio.beaver.ui.ActivityBuilderModule
import javax.inject.Singleton

@Module(
    includes = [CrashlyticsModule::class, TimberModule::class, AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class, ServiceBuilderModule::class, SystemServiceModule::class,
        NetworkModule::class, FirebaseModule::class, PicassoModule::class]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: SoshiApplication): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}