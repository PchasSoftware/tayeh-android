package ir.pchas.tayehclient.repository.network

public sealed class Result<T>(
    public val data: T? = null,
    public val exception: Exception? = null,
) {
    public class Success<T>(data: T) : Result<T>(data)
    public class Error<T>(exception: Exception, data: T? = null) : Result<T>(data, exception)
}