package com.multicinescc.app

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.mappers.toView
import com.multicinescc.app.presenter.MoviesPresenter
import com.multicinescc.domain.interactor.usecase.RetrieveMoviesUseCase
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.Schedule
import com.multicinescc.domain.repository.MoviesRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import com.multicinescc.app.presenter.MoviesPresenter.View as Moviesview

/**
 * RecoveryPasswordPresenterTest.
 */
@RunWith(MockitoJUnitRunner::class)
class MoviesPresenterTest {

    companion object {
        private val schedule1 = listOf(Schedule("13:00", "", "13€"))
        private val movie1 = Movie("1", "Movie1", "Movie1Img", "+13", schedule1)
        private val movies = mutableListOf(movie1)
    }

    private val view: Moviesview = mock()

    private val errorHandler: ErrorHandler = mock()

    private lateinit var presenter: MoviesPresenter

    private val repository = mock<MoviesRepository> {

    }

    private val retrieveMoviesUseCase: RetrieveMoviesUseCase = spy(RetrieveMoviesUseCase(repository, MockExecutor()))

    @Before
    fun setUp() {
        presenter = MoviesPresenter(retrieveMoviesUseCase = retrieveMoviesUseCase, view = view, errorHandler = errorHandler)
    }

    @Test
    fun shouldRetrieveMoviesWhenScreenIsLoaded() {
        //Given
        whenever(repository.getMovies()).thenReturn(Single.just(movies))

        //When
        presenter.initialize()

        //Then
        verify(view).showProgress()
        verify(view).showMovies(movies.map { it.toView() })
        verify(view).hideProgress()
    }

    @Test
    fun shouldClearUseCasesOnDestroy() {
        //When
        presenter.destroy()

        //Then
        verify(retrieveMoviesUseCase).clear()
    }

}