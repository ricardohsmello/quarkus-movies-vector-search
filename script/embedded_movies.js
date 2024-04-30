const { MongoClient, ObjectId } = require('mongodb');
const axios = require('axios');
const url = 'https://api.openai.com/v1/embeddings';
const headers = {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer <BEARER>,
    'Cookie': '__cf_bm=tII5A062TNL22wD8wP1XCnKvkiU63z3BZx88H5blaps-1713671399-1.0.1.1-A3dQc_CRLeAkD4GjU4CT9cMO1O6Hdb6obs6nuXco9stwYtAxtjEWqB55X8LlOtDJm5OW0mjNNyFxi1b8I_AClQ; _cfuvid=D3BM50GLthY1FkdxEZobKDirGC040sWd23ftcatdMc8-1713671399184-0.0.1.1-604800000'
};

async function start() {
    console.log("starting..");

    const uri = 'mongodb+srv://USER:PASSWORD@cluster0.ybhjkym.mongodb.net/';
    const client = new MongoClient(uri);
    try {
        console.log("try..");
        await client.connect();
        console.log("connect..");
        
        const database = client.db('sample_mflix');
        const moviesCollection = database.collection('movies');

        const moviesCursor = moviesCollection.find({ movie_embedded: { $exists: false } });

        await moviesCursor.forEach(async function(movie) {
            let inputText = movie.plot + movie.title + movie.cast + movie.genres;
            let embedded = await getEmbedding(inputText);
           
            await update(moviesCollection, movie, embedded); 
        });
        

    } catch(error) {
        console.error('error', error);
        throw error;
    } finally {
        await client.close();
    }
}

async function update(moviesCollection, movie, embedded) {
    await moviesCollection.updateOne(
        { _id: movie._id },
        { $set: { movie_embedded: embedded } }
    );
}


async function getEmbedding(inputText) {
    const data = {
        input: inputText,
        model: "text-embedding-ada-002"
    };

    console.log(data);

    return axios.post(url, data, {headers: headers, timeout: 50000})
    .then(response => response.data.data[0].embedding)
    .catch(error => {
        console.error('Error:' + inputText, error);
        throw error;
    });
   
}

start();