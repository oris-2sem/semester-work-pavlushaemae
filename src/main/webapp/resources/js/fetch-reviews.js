function fetchData(id) {
    fetch(`http://localhost/reviews/${id}`)
        .then(function (response) {
            if (response.status !== 200) {
                return Promise.reject(new Error(response.statusText))
            }
            return Promise.resolve(response)
        })
        .then(response => response.json())
        .then(data => {
            const reviews = data;
            const container = document.getElementById('postContainer');
            container.innerHTML = '';
            for (let i = 0; i < reviews.length; i++) {
                container.innerHTML += `
                        <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${reviews[i].userName}</h5>
                                    <p class="card-text">${reviews[i].text}</p>
                                    <h6 class="card-subtitle mb-2 text-muted">${reviews[i].dateOfCreated}</h6>
                                </div>
                            </div>
        `;
            }
            // try {
            //     console.log('data', data);
            // } catch (err) {
            //     console.error(err);
            //     console.log('response text:', data.text());
            // }
            // console.log('data', data);
        })
        .catch(error => console.log(error));
}