package com.nwar.umjunsik.di.module

import com.nwar.domain.useCase.*
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Module
class UseCaseModule() {

    @Singleton
    @Provides
    fun loadGameScheduleUseCase(mainSchedule: Scheduler) = LoadGameScheduleListUseCase(mainSchedule)

    @Singleton
    @Provides
    fun voteTeamInMatchUseCase(mainSchedule: Scheduler) = VoteTeamInMatchUseCase(mainSchedule)

    @Singleton
    @Provides
    fun likeMatchUseCase(mainSchedule: Scheduler) = LikeMatchUseCase(mainSchedule)

    @Singleton
    @Provides
    fun signInUseCase(mainScheduler: Scheduler) = SignInUseCase(mainScheduler)

    @Singleton
    @Provides
    fun checkDuplIdUseCase(scheduler: Scheduler) = CheckDuplicateIdUseCase(scheduler)

    @Singleton
    @Provides
    fun checkDuplNicknameUseCase(scheduler: Scheduler) = CheckDuplicateNicknameUseCase(scheduler)

    @Singleton
    @Provides
    fun signUpUseCase(scheduler: Scheduler) = SignUpUseCase(scheduler)

    @Singleton
    @Provides
    fun loadTeamListForFollowUseCase(mainScheduler : Scheduler) = LoadTeamListForFollowUseCase(mainScheduler)

    @Singleton
    @Provides
    fun likeNewsFeedUseCase(mainScheduler : Scheduler) = LikeNewsFeedUseCase(mainScheduler)
}