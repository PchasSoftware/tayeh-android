package ir.pchas.tayehclient

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.pchas.tayehclient.repository.TayehRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val tayehRepository = TayehRepository(
        11,
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI3ZmI3MGNjNi04MDkxLTQ3MWQtYjgxMy04MTEwNDM5MjI5MjUiLCJpc3MiOiJ0YXllaCIsInIiOiJhcGkiLCJvIjoiKiIsImlhdCI6MTYyMzE1NjU0OCwiZXhwIjoxNjU0MjYwNTQ4fQ.J9hFEvixWsbeb5gOe8nepv5-QhZsfBjINOeZvpGPxck"
    )

    fun smockTest() {
        println("Hello from MainViewModel")
    }
}