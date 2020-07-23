package com.nwar.umjunsik.viewModel.subscriber

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.subscribers.DisposableSubscriber

class Subscriber<T>(val observeAction : (item : T) -> Unit = {}, val completeAction : () -> Unit = {}, val errorAction : (t : Throwable?) -> Unit = {}) : DisposableSubscriber<RequestResult<T>>() {
    override fun onComplete() = completeAction()

    override fun onError(t: Throwable?) = errorAction(t)

    override fun onNext(t: RequestResult<T>) = if(t.isSuccess()) observeAction(t.getValue()!!) else errorAction(t.getException())
}