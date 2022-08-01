
const form = document.getElementById("registerForm")
form.addEventListener("submit", (event) => {
    event.preventDefault();

    axios.get('http://localhost:9090/game-active').then(resp  => {
    console.log('resp active game :>> ', resp.data.active);
    let gameStatusCheck = resp.data.active

    const user = document.getElementById("user").value;
    const password = document.getElementById("password").value;

    let value = {
        user,
        password
    }

    axios.post('http://localhost:3000/register', value).then(resp => {
        console.log("user was register on mongoDB");
        console.log(resp.data._id);
        let userdata = resp.data._id

        if(gameStatusCheck == false){
        axios.post('http://localhost:9090/create-game').then(resp => {
            console.log('game create');
        });
        }

        axios.post('http://localhost:9090/create-user/' + userdata).then(resp => {
            window.alert("Data Save");
        });

    }).catch(function (error) {
        window.alert("Este usuario ya se encuentra registrado");
    });
});
});




