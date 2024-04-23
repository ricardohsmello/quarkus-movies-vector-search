async function fetchAndDisplayMovies(data) {
    try {
        const resultsDiv = document.getElementById('movieResults');
        resultsDiv.innerHTML = '<div class="loading"><span class="badge bg-light text-dark" style="font-size: 30px">Loading movies...</span></div>';

        const response = await fetch('http://localhost:8080/movies/findSimilar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });
        return await response.json();
    } catch (error) {
        console.error('Error:', error);
        return [];
    }
}
