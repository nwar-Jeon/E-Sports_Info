package com.nwar.umjunsik.di.module.activity

import com.nwar.umjunsik.di.module.fragment.*
import com.nwar.umjunsik.ui.fragment.*
import com.nwar.umjunsik.ui.splash.Splash
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityInjector::class])
abstract class MainActivityModule() {
    @ContributesAndroidInjector
    abstract fun splash() : Splash

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment() : MainFragment

    @ContributesAndroidInjector(modules = [SignInModule::class])
    abstract fun signInFragment() : SigninFragment

    @ContributesAndroidInjector(modules = [SignUpModule::class])
    abstract fun signUpFragment() : SignupFragment

    @ContributesAndroidInjector(modules = [ChangeNicknameModule::class])
    abstract fun changeNicknameFragment() : ChangeNicknameFragment

    @ContributesAndroidInjector(modules = [TeamFollowModule::class])
    abstract fun teamFollowFragment() : TeamFollowFragment
}

@Module
class MainActivityInjector {

}