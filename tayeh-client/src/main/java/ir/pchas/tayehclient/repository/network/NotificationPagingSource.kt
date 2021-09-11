package ir.pchas.tayehclient.repository.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.pchas.tayehclient.model.Notification
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 0

public class NotificationPagingSource(
    private val tayehAPI: TayehAPI,
    private val token: String,
) : PagingSource<Int, Notification>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Notification> {
        val nextPageNumber = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = tayehAPI.getNotifications(
                tokenString = token,
                page = nextPageNumber,
                perPage = params.loadSize
            )
            val notifications = response.objects

            LoadResult.Page(
                data = notifications,
                prevKey = if (nextPageNumber == STARTING_PAGE_INDEX) null else nextPageNumber - 1,
                nextKey = if (notifications.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Notification>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}