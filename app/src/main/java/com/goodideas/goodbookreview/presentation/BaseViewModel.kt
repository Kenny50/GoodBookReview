package com.goodideas.goodbookreview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goodideas.goodbookreview.util.ViewEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

open class BaseViewModel:ViewModel() {
    private val channel = Channel<ViewEvent>()
    val receiveChannelAsFlow = channel.consumeAsFlow()

    private suspend fun apiCallWithViewEvent(block:suspend () -> Unit){
        channel.send(ViewEvent.LOADING)
        try {
            block.invoke()
            channel.send(ViewEvent.FINISH)
        } catch (cancelException: CancellationException){
            throw cancelException
        } catch (e:Exception) {
            channel.send(ViewEvent.FAIL)
        }
    }

    protected fun apiCall(block: suspend () -> Unit) : Job {
        return viewModelScope.launch {
            apiCallWithViewEvent(block)
        }
    }

    protected fun <T> Flow<T>.addViewEventTracker() =
        this.onStart {
            channel.send(ViewEvent.LOADING)
        }.catch {
            channel.send(ViewEvent.FAIL)
        }.onCompletion {
            channel.send(ViewEvent.FINISH)
        }

    override fun onCleared() {
        super.onCleared()
        channel.close()
    }

}