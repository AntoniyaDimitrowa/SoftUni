function updateMoviesList(arr) {
    let movies = [];

    arr.forEach((element) => {
        if(element.includes('addMovie')) {
            let movieName = element.split("addMovie ")[1];
            movies.push({name: movieName})
        } else if(element.includes('directedBy')) {
            let [movieName, director] = element.split(" directedBy ");
            let searching = movies.find((el) => el.name === movieName);

            if (searching) {
                searching['director'] = director;
            }
        } else if(element.includes('onDate')) {
            let [movieName, date] = element.split(" onDate ");
            let searching = movies.find((el) => el.name === movieName);

            if (searching) {
                searching['date'] = date;
            }
        } else {
            console.log("Incorrect input!");
        }
    });

    movies.forEach((movie) => {
        if(movie.name && movie.date && movie.director) {
            console.log(JSON.stringify(movie));
        }
    });
}

updateMoviesList([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen']);

updateMoviesList([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo']);