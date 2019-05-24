package net.samystudio.beaver.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import net.samystudio.beaver.SoshiApplication
import net.samystudio.beaver.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<SoshiApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SoshiApplication): Builder

        fun build(): ApplicationComponent
    }
}