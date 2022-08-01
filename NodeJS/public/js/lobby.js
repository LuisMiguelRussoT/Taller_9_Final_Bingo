tableCreateBingo();
function dothis() {
    

    axios.get('http://localhost:9090/allballot/1').then(resp => {
        console.log("seleccionaste " + this.value);
      
        resp.data.forEach(element => {

            if (element.number == this.id) {
                document.getElementById(this.id).setAttribute("style", "background-color: red");
                document.getElementById(this.id).removeEventListener("click", dothis);



                let bodySelectBallot = {
                    "user_id" : document.getElementById("userid").innerHTML,
                    "idGame" : 1,
                    "letter" : element.letter,
                    "number" : element.number,
                }

                
                axios.post('http://localhost:9090/playgame',bodySelectBallot).then(response => {
                    console.log('response :>> ', response);
                  
                });
            }
        })
  
    });
}


setInterval(function () {
    tableCreateBingo();
}, 5000);

function tableCreateUser() {

    axios.get('http://localhost:9090/table/' + location.hash.substring(1)).then(resp => {

        document.getElementById("username").innerHTML = location.search.substring(1);
        document.getElementById("userid").innerHTML = location.hash.substring(1);


        var numbersB = resp.data.letters[0].numbers;
        var numbersI = resp.data.letters[1].numbers;
        var numbersN = resp.data.letters[2].numbers;
        var numbersG = resp.data.letters[3].numbers;
        var numbersO = resp.data.letters[4].numbers;


        console.log(numbersB, numbersI, numbersN, numbersG, numbersO);


        console.log(numbersB);

        var body = document.getElementById('table');
        var tbl = document.createElement('table');
        tbl.style.width = '100%';
        tbl.setAttribute('class', 'userTable');
        var tbdy = document.createElement('tbody');
        for (var i = 0; i < 5; i++) {
            var tr = document.createElement('tr');

            for (var j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    var td = document.createElement('button');
                    td.innerHTML = "BINGO"
                    td.setAttribute("style","background-color : #0080d5")
                    td.appendChild(document.createTextNode('\u0020'))
                    tr.appendChild(td)

                } else {
                    var td = document.createElement('button');
                    if (j == 0) { td.innerHTML = numbersB[i], td.setAttribute("value", "B" + numbersB[i]), td.setAttribute("id", numbersB[i]) };
                    if (j == 1) { td.innerHTML = numbersI[i], td.setAttribute("value", "I" + numbersI[i]), td.setAttribute("id", numbersI[i]) };
                    if (j == 2) { td.innerHTML = numbersN[i], td.setAttribute("value", "N" + numbersN[i]), td.setAttribute("id", numbersN[i]) };
                    if (j == 3) { td.innerHTML = numbersG[i], td.setAttribute("value", "G" + numbersG[i]), td.setAttribute("id", numbersG[i]) };
                    if (j == 4) { td.innerHTML = numbersO[i], td.setAttribute("value", "O" + numbersO[i]), td.setAttribute("id", numbersO[i]) };

                    td.appendChild(document.createTextNode('\u0020'))
                    tr.appendChild(td)
                    td.addEventListener("click", dothis)

                }
            }
            tbdy.appendChild(tr);
        }
        tbl.appendChild(tbdy);
        body.appendChild(tbl)

    }).catch(function (error) {
        window.alert(error);
    });


}


tableCreateUser();

function tableCreateBingo() {

    axios.get('http://localhost:9090/get-winner-game').then(respWinner => {

        if(respWinner.data.idwinner != null){
            location.replace("http://localhost:3000/winner?"+respWinner.data.idwinner);
        }else{

        axios.get('http://localhost:9090/ballot/1').then(resp => {

            $('#ballot').empty();
    
            
    
            resp.data.forEach(element => {
    
                var body = document.getElementById('ballot');
                var div = document.createElement("div");
                div.setAttribute("class", "circle");
                div.innerText = element.letter + element.number;
                body.appendChild(div);
    
            });
    
    
        }).catch(function (error) {
            window.alert(error);
        });
    }
    });

   



}



















