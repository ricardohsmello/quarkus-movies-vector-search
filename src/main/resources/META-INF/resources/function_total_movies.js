async function fetchTotalMovies() {
    try {
        const response = await fetch('http://localhost:8080/movies/total');
        if (!response.ok) {
            throw new Error('Failed to fetch total number of movies');
        }
        const data = await response.json();
        totalMovies = data;
        document.getElementById('totalMovies').innerHTML = `Total Movies: ${totalMovies}`;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('totalMovies').innerHTML = '<p>Failed to retrieve total number of movies.</p>';
    }
}