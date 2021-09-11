package ir.pchas.tayehclient.repository.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.pchas.tayehclient.model.Product
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 0

public class ProductPagingSource(
    private val tayehAPI: TayehAPI,
    private val token: String,
    private val instanceId: Int,
    private val search: String,
    private val sort: String,
    private val min_price: Int?,
    private val max_price: Int?,
    private val brands: List<String>?,
    private val category: String?,
    private val filter: List<String>?,
    private val only_available: Boolean?,
    private val similar_to: String?,
) : PagingSource<Int, Product>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val nextPageNumber = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response =
                tayehAPI.searchProducts(
                    tokenString = token,
                    instanceId = instanceId,
                    search = search,
                    sort = sort,
                    min_price = min_price,
                    max_price = max_price,
                    brands = brands,
                    category = category,
                    filter = filter,
                    only_available = only_available,
                    similar_to = similar_to,
                    page = nextPageNumber,
                    perPage = params.loadSize
                )
            val products = response.products

            LoadResult.Page(
                data = products,
                prevKey = if (nextPageNumber == STARTING_PAGE_INDEX) null else nextPageNumber - 1,
                nextKey = if (products.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}