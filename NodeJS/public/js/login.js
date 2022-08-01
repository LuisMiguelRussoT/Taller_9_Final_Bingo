const formLogin = document.getElementById("loginform");

form.addEventListener("submit", (event,resp) => {
   
   var cookies = location.search;
   console.log('cookies :>> ', cookies);


    event.preventDefault();

    const user = document.getElementById("user").value;
    const password =  document.getElementById("password").value;

    let value = {
        user,
        password 
    }

        axios.post('http://localhost:3000/login', value).then(resp => {
            console.log( "loggin OK");
            
            console.log('resp :>> ', resp);
          
        }).catch(function (error) {
            window.alert(error);
        });
    }

);


