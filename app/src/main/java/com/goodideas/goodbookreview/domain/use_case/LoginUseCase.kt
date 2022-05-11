package com.goodideas.goodbookreview.domain.use_case

import com.goodideas.goodbookreview.data.remote.dto.LoginDto
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import com.goodideas.goodbookreview.util.Constant
import com.goodideas.goodbookreview.util.DataStoreManager
import com.goodideas.goodbookreview.util.Resource
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val repo: GoodReviewRepository
) {
    suspend operator fun invoke(loginDto: LoginDto) = flow {
        emit(Resource.Loading())
        try {
            val result = repo.login(loginDto)
            dataStoreManager.write(Constant.DataStoreTokenKey, result.token)
            emit(Resource.Success(result))
        } catch (cancelException: CancellationException) {
            throw cancelException
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: e.message.toString()))
        }
    }

}