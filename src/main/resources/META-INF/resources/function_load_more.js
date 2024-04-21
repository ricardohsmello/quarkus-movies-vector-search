async function loadMoreMovies(movieIds) {
    try {
        const moviesIdsRequest = {ids: movieIds};
        alert(moviesIdsRequest.ids);
        const loadMoreButton = document.getElementById('load-more');
        loadMoreButton.innerHTML = 'Loading...';
        const response = await fetch('http://localhost:8080/movies/loadMore', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(moviesIdsRequest),
        });
        const data = await response.json();
        // Handle the loaded movies data
        loadMoreButton.innerHTML = 'Load more';
    } catch (error) {
        console.error('Error:', error);
        loadMoreButton.innerHTML = 'Load more';
    }
}